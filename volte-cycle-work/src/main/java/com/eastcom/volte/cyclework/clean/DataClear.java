package com.eastcom.volte.cyclework.clean;

import com.google.common.base.Splitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by linghang.kong on 2016/8/24.
 */
public class DataClear {
    private static final Logger logger = LoggerFactory.getLogger(DataClear.class);
    private final int BATCH = 10000;
    private long DELAY_TIME;
    private long CLEAR_TIME;
    private JedisInfo jedisInfo;
    private String jedisIP;
    private int jedisPort;
    private Splitter splitter = Splitter.on('|').trimResults();
    private ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    //    private ScheduledExecutorService s = new ScheduledThreadPoolExecutor(5);
    private Runnable doClean;

    private static final String algorithm = "MD5";

    public DataClear(long DELAY_TIME, long CLEAR_TIME) {
        this.DELAY_TIME = DELAY_TIME;
        this.CLEAR_TIME = CLEAR_TIME;
        this.jedisInfo = new JedisInfo();
    }

    /**
     * 多个spout上启动，每一分钟同时进行该操作，
     * 这个操作放到topology中，只在提交的节点上运行，避免造成多节点的并发一致性问题。
     * 如果解决不了，使用zk实现锁机制。
     */
    public void cleanScheduler() {
        try {
            if (doClean == null) {
                logger.info("Start a clean scheduler to delete expired data.");
                doClean = new Runnable() {
                    public void run() {
                        Pipeline pipeline = null;
                        String partitionName = null;
                        String xdr_id = null;
                        List<String> tmp;
                        Jedis jedis = null;
                        int clearNUM = BATCH;
                        try {
                            do {
                                jedis = createJedisHandle(jedisInfo.getAddresses());
                                logger.info("connect redis.");
                            } while (jedis == null && !jedis.isConnected());
                            pipeline = jedis.pipelined();
                            String currentTime = TimeTransform.getDate(System.currentTimeMillis() - DELAY_TIME * 60 * 60 * 1000);
                            //添加加密分区算法
                            String encodedTimePartitionName = subMD5String(currentTime) + "|" + currentTime;

                            Set<String> expireTable = jedis.smembers(encodedTimePartitionName);
                            int table_size = expireTable.size();
                            logger.info("table size {}, encodedTimePartitionName {}; ip: {}, port: {}.", expireTable.size(), encodedTimePartitionName, jedisIP, jedisPort);
                            if (table_size > 0) {
                                for (String expireInfo : expireTable
                                        ) {
                                    tmp = splitter.splitToList(expireInfo);
                                    partitionName = tmp.get(0);
                                    xdr_id = tmp.get(1);
                                    pipeline.hdel(partitionName.getBytes(), xdr_id.getBytes());
                                    clearNUM--;
                                    if (clearNUM <= 0) {
                                        clearNUM = BATCH;
                                        pipeline.sync();
                                        pipeline = jedis.pipelined();
                                    }
                                    logger.debug("partition: {}, xdr_id: {}.", partitionName, xdr_id);
                                }
                                pipeline.del(encodedTimePartitionName);
                                pipeline.sync();
                            }
                        } catch (Exception e) {
                            logger.error("Exception {}, clear false! ip: {}, port: {}.", e.getMessage(), jedisIP, jedisPort);
                            pipeline.sync();
                        } finally {
                            jedis.close();
                        }
                    }
                };
                executorService.scheduleAtFixedRate(doClean, 0, this.CLEAR_TIME, TimeUnit.MINUTES);
            } else
                logger.warn("There is a clean scheduler with the process.");
        } catch (Exception e) {
            logger.error("Cleared the expired data is failure.");
        }
    }

    private Jedis createJedisHandle(List<String> addresses) {
        Jedis jedis = null;
        try {
            String[] host = addresses.get(new Random().nextInt(addresses.size())).split(":");
            jedisIP = host[0];
            jedisPort = Integer.parseInt(host[1]);
            jedis = new Jedis(jedisIP, jedisPort);
            jedis.auth(jedisInfo.getPassword());
            jedis.connect();
        } catch (Exception e) {
            logger.error("Create a  Jedis Handle , Exception: {}.", e.getMessage());
        }
        return jedis;
    }

    private String subMD5String(String string) {
        String encodedString = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.update(string.getBytes());
            String tmp = new BigInteger(messageDigest.digest()).toString();
            int length = tmp.length();
            encodedString = algorithm + tmp.substring(length - 5);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encodedString;
    }
}
