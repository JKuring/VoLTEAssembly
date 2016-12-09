package com.eastcom.volte.storm.storm.service;

import com.eastcom.volte.data.DataCommon;
import com.eastcom.volte.storm.common.utilities.serialization.KryoUtillity;
import com.eastcom.volte.storm.common.utilities.time.TimeTransform;
import com.esotericsoftware.kryo.Kryo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.util.Pool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linghang.kong on 2016/8/23.
 */
public class DataPartitioning implements Partitioning<DataCommon, String> {

    private static final Logger logger = LoggerFactory.getLogger(DataPartitioning.class);
    private static int intcount = 0;
    private static int outcount = 0;
    private static int countNUM = 10000;
    private final int size = 100;
    private final int partitionSize = 1000;
    private final int xdr_id_min_len = 3;
    private Kryo kryo = KryoUtillity.getKryo();
    private Pool<Jedis> jedisPool;
    private Jedis jedis;
    private Pipeline pipeline;

    private int cacheSize;


    public DataPartitioning(Pool<Jedis> jedisPool) {
        this.jedisPool = jedisPool;
        this.jedis = jedisPool.getResource();
        this.cacheSize = this.size;
    }

    /**
     * 分区算法
     * 由于获取数据的时候，只知道XDR_ID 所以，分区name只能由该ID组成
     *
     * @param xdr_id
     * @return partition number
     */
    private String partitioning(String xdr_id) {
        // 16进制处理方式
//        char[] subID = xdr_id.substring(8).toLowerCase().toCharArray();
//        int decNum = HexToDec.hexToDec(subID);
//        int partitionNum = decNum % this.partitionSize;
//        return String.valueOf(partitionNum);

        // 原xdr_id 长 19 位 十进制数
        int length = xdr_id.length();
        int subLength;
        if (length <= xdr_id_min_len) {
            return null;
        } else {
            subLength = length - xdr_id_min_len;
            String subID = xdr_id.substring(subLength);
            return String.valueOf(Integer.parseInt(subID) % this.partitionSize);
        }
    }

    private void init() {
        this.pipeline = jedis.pipelined();
    }


    /**
     * 加载四个接口数据到redis
     *
     * @param dataCommon data object
     * @return boolean
     */
    public boolean put(DataCommon dataCommon) {
        boolean status = false;
        if (dataCommon != null) {
            if (this.pipeline == null)
                init();
            String partition = null;
            String xdr_id = null;
            try {
                xdr_id = dataCommon.getXdr_id();
                partition = dataPartitionPrefix + this.partitioning(xdr_id);
                byte[] bytesData = KryoUtillity.serialize(this.kryo, dataCommon);
                // store data to data table.
                pipeline.hset((partition).getBytes(), xdr_id.getBytes(), bytesData);
                // store data to expired table.
                pipeline.sadd(TimeTransform.getDate(System.currentTimeMillis()), partition + '|' + xdr_id);
                this.cacheSize--;
                if (this.cacheSize <= 0) {
                    // sync and close pipeline
                    pipeline.sync();
                    try {
                        reconnect();
                        this.pipeline = this.jedis.pipelined();
                    } catch (Exception e) {
                        throw new Exception(e.getMessage() + ", reset is false!");
                    }
                    this.cacheSize = this.size;
                }
                status = true;
            } catch (Exception e) {
                logger.error("Get an exception by added the {} of interface data, exception: {};" +
                        " partition: {}, xdr_id: {}.", dataCommon.getClass().getName(), e.getMessage(), partition, xdr_id);
                // reconnect
                try {
                    this.pipeline.sync();
                } catch (Exception e1) {
                    logger.error("sync is false!");
                }
                reconnect();
                this.pipeline = this.jedis.pipelined();
                status = false;
            }
        }
        return status;
    }


    /**
     * 读取4个接口数据
     *
     * @param xdr_id
     * @return
     */
    public List<DataCommon> get(List<String> xdr_id) {
        List<DataCommon> dataCommonList = new ArrayList<DataCommon>();
        int listSize;
        byte[] xdrBytes = null;
        int length;
        String[] partition_array;
        try {
            length = xdr_id.size();
            partition_array = new String[length];

            for (int i = 0; i < length; i++) {
                partition_array[i] = dataPartitionPrefix + this.partitioning(xdr_id.get(i));
            }
            for (int i = 0; i < length; i++) {
                String xdr_id_tmp = xdr_id.get(i);
                String partition_tmp = partition_array[i];
                listSize = dataCommonList.size();
                byte[] partition = partition_tmp.getBytes();
                byte[] xdr_id_Bytes = xdr_id_tmp.getBytes();
                try {
                    // 查询
                    if (xdr_id_tmp != null && xdr_id_tmp.length() > 0) {
                        try {
                            logger.debug("xdr_id: {}, {}.", xdr_id_tmp, i);
                            xdrBytes = jedis.hget(partition, xdr_id_Bytes);
                            intcount++;
                        } catch (Exception e) {
                            logger.error("Exception {}, can't find partition {} and xdr {}, index {}.", e.getMessage(), partition_tmp, xdr_id_tmp, i);
                            reconnect();
                        }
                        // redo schedule
//                        int redo_times = 3;
//                        while(redo_times > 0) {
//                            try {
//                                logger.debug("xdr_id: {}, {}.", xdr_id_tmp, i);
//                                xdrBytes = jedis.hget(partition, xdr_id_Bytes);
//                                intcount++;
//                                break;
//                            } catch (Exception e) {
//                                logger.error("Exception {}, can't find partition {} and xdr {}, index {}.", e.getMessage(), partition_tmp, xdr_id_tmp, i);
//                                logger.info("redo to add data {}.",xdr_id_tmp);
//                                reconnect();
//                                redo_times--;
//                            }
//                        }
                        if (xdrBytes != null && xdrBytes.length > 0) {
                            dataCommonList.add(getObject(xdrBytes));
                            // clear used xdr
//                            try {
//                                jedis.hdel(partition, xdr_id_Bytes);
//                            }catch (Exception e){
//                                reconnect();
//                                logger.debug("{}, Can't delete xdr {}, {}.",e.getMessage(), xdr_id_tmp,i);
//                            }
                            outcount++;
                            logger.debug("count {}, {}, add xdr: {}, {}.", intcount, outcount, xdr_id_tmp, i);
                        } else dataCommonList.add(null);
                    } else dataCommonList.add(null);
                } catch (Exception e) {
                    //防止异常，导致的数据顺序不一致
                    if (listSize == dataCommonList.size()) {
                        dataCommonList.add(null);
                    }
                    logger.error("fetch xdr exception: {}, xdr_id: {}.", e.getMessage(), xdr_id.get(i));
                }
            }
            this.jedisPool.returnResource(jedis);
            //test
            if (intcount >= countNUM) {
                logger.info("success rate: intput {}, output {}.", intcount, outcount);
                intcount = outcount = 0;
            }

        } catch (Exception e) {
            logger.error("Got data object is failure. Exception: {}.", e.getMessage());
            //reconnect
            this.jedisPool.returnBrokenResource(jedis);
            logger.error("reconnect redis service.");
        }
        return dataCommonList;
    }

    private DataCommon getObject(byte[] xdrBytes) {
        try {
            if (xdrBytes != null)
                return (DataCommon) KryoUtillity.deserialize(KryoUtillity.getKryo(),
                        xdrBytes);
        } catch (Exception e) {
            logger.error("get invalid object.");
        }
        return null;
    }

    private void reconnect() {
        //reconnect
//        if (!jedis.isConnected()) {
        this.jedisPool.returnBrokenResource(jedis);
//        } else {
//            this.jedisPool.returnResource(jedis);
//        }
        this.jedis = this.jedisPool.getResource();
        logger.debug("reconnect redis service.");
    }

}
