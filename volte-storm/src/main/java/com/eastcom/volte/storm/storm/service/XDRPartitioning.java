package com.eastcom.volte.storm.storm.service;

import com.eastcom.volte.data.DataCommon;
import com.eastcom.volte.data.xdr.MergedXDR;
import com.eastcom.volte.storm.common.utilities.HexToDec;
import com.eastcom.volte.storm.common.utilities.serialization.KryoUtillity;
import com.esotericsoftware.kryo.Kryo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.exceptions.JedisConnectionException;
import redis.clients.util.Pool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linghang.kong on 2016/8/25.
 */
public class XDRPartitioning implements Partitioning<DataCommon, String> {

    public static final int size = 100;
    public static final int partitionSize = 100;
    private static final Logger logger = LoggerFactory.getLogger(XDRPartitioning.class);
    private Kryo kryo = KryoUtillity.getKryo();
    private Pool<Jedis> jedisPool;
    private Jedis jedis;
    private Pipeline pipeline;
    private int cacheSize;


    public XDRPartitioning(Pool<Jedis> jedisPool) {
        this.jedisPool = jedisPool;
        this.jedis = jedisPool.getResource();
        this.pipeline = this.jedis.pipelined();
        this.cacheSize = size;
    }

    /**
     * 分区算法
     * 由于获取数据的时候，只知道XDR_ID 所以，分区name只能由该ID组成
     *
     * @param xdr_id
     * @return partition number
     */
    private String partitioning(String xdr_id) {
        char[] subID = xdr_id.substring(8).toLowerCase().toCharArray();
        int decNum = HexToDec.hexToDec(subID);
        int partitionNum = decNum % partitionSize;
        return String.valueOf(partitionNum);
    }

    public boolean put(DataCommon dataCommon) {
        boolean status = false;
        String partition = null;
        String xdr_id;
        try {
            xdr_id = dataCommon.getXdr_id();
            partition = xdrPartitionPrefix + this.partitioning(xdr_id);
            byte[] bytesData = KryoUtillity.serialize(this.kryo, dataCommon);
            // store data to data table.
            this.pipeline.hset(partition.getBytes(), xdr_id.getBytes(), bytesData);
            this.cacheSize--;
            if (this.cacheSize == 0) {
                this.pipeline.sync();
                this.cacheSize = this.size;
            }
            status = true;
        } catch (JedisConnectionException e) {
            logger.error("Get an exception by added the object of merged xdr data, exception: {};\n" +
                    " partition: {}.", e.getMessage(), partition);
            //reconnect
            this.jedisPool.returnResource(this.jedis);
            this.jedis = this.jedisPool.getResource();
            logger.error("reconnect redis service.");
            this.pipeline = this.jedis.pipelined();
            put(dataCommon);
            status = true;
        } finally {
            return status;
        }
    }

    // 处理合成xdr中的xdr_id
    public List<DataCommon> get(List<String> xdr_id) {
        String partition = null;
        List<DataCommon> dataCommonList = new ArrayList<DataCommon>();
        try {
            int length = xdr_id.size();
            for (int i = 0; i < length; i++) {
                partition = xdrPartitionPrefix + this.partitioning(xdr_id.get(i));
                dataCommonList.add(
                        (DataCommon) KryoUtillity.deserialize(this.kryo,
                                this.jedis.hget(partition.getBytes(), xdr_id.get(i).getBytes())
                        )
                );
                this.jedis.hdel(partition.getBytes(), xdr_id.get(i).getBytes());
            }
        } catch (JedisConnectionException e) {
            logger.error("Got data object is failure. Exception: {}.", e.getMessage());
            //reconnect
            this.jedisPool.returnResource(this.jedis);
            this.jedis = this.jedisPool.getResource();
            logger.error("reconnect redis service.");
            get(xdr_id);
        }
        return dataCommonList;
    }

    public MergedXDR get(String xdr_id, int partition) {
        String partitionName = null;
        try {
            partitionName = xdrPartitionPrefix + partition;
            return KryoUtillity.deserialize(KryoUtillity.getKryo(), this.jedis.hget(partitionName.getBytes(), xdr_id.getBytes()));
        } catch (Exception e) {
            logger.error("Get an merged xdr form {}.", partitionName);
            return null;
        }
    }

}
