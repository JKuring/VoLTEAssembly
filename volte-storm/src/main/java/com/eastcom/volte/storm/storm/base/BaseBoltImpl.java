package com.eastcom.volte.storm.storm.base;


import com.eastcom.volte.data.DataCommon;
import com.eastcom.volte.storm.common.pool.RedisProxyConnectionPool;
import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.util.Pool;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by linghang.kong on 2016/7/5.
 */
public abstract class BaseBoltImpl<T, W> extends BaseRichBolt implements BaseBolt<T, W> {

    private static final Logger logger = LoggerFactory.getLogger(BaseBoltImpl.class);

    // 输出外部配置更改，这里也要更改，declare先于prepare
    private String boltTupleName = "boltData";
    private int redisMinMultiple;
    private String redisPassword;
    private List<String> redisAddresses;
    private String tableName;
    // process data
    private OutputCollector collector;
    private Pool<Jedis> jedisPool;
    private Jedis jedis;

    //网元数据
    private ConcurrentMap networkElementData;

    private ExecutorService executorService;
    private DataCommon dataCommon;

    //统计成功率

    public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
        logger.info(" Start Bolt ID: " + context.getThisComponentId());
        config(stormConf);

        this.collector = collector;

        this.jedisPool = new RedisProxyConnectionPool(redisAddresses, redisPassword, redisMinMultiple);

        this.jedis = jedisPool.getResource();

        // 加载网元数据
        this.networkElementData = new ConcurrentHashMap(jedis.hgetAll(tableName));
        this.jedisPool.returnResource(this.jedis);

        this.executorService = Executors.newCachedThreadPool();

    }

    public void execute(final Tuple input) {
        final BaseBoltImpl baseBolt = this;
        dataCommon = (DataCommon) input.getValueByField("partition");
        if (dataCommon != null) {
//            this.executorService.execute(new Runnable() {
//                @Override
//                public void run() {
            analyzeTuple((W) dataCommon, baseBolt.collector);
//                }
//            });
        }
    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields(this.boltTupleName));
    }


    public abstract void analyzeTuple(W data, OutputCollector collector);


    public String getBoltTupleName() {
        return boltTupleName;
    }

    public void setBoltTupleName(String boltTupleName) {
        this.boltTupleName = boltTupleName;
    }

    public int getRedisMinMultiple() {
        return redisMinMultiple;
    }

    public void setRedisMinMultiple(int redisMinMultiple) {
        this.redisMinMultiple = redisMinMultiple;
    }

    public String getRedisPassword() {
        return redisPassword;
    }

    public void setRedisPassword(String redisPassword) {
        this.redisPassword = redisPassword;
    }

    public List<String> getRedisAddresses() {
        return redisAddresses;
    }

    public void setRedisAddresses(List<String> redisAddresses) {
        this.redisAddresses = redisAddresses;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }


    public Map getNetworkElementData() {
        return networkElementData;
    }

    public Pool<Jedis> getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(Pool<Jedis> jedisPool) {
        this.jedisPool = jedisPool;
    }
}
