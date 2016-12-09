package com.eastcom.volte.storm.storm.base;

import com.eastcom.volte.storm.common.mq.MQConsumer;
import com.eastcom.volte.storm.common.mq.MQFactory;
import com.eastcom.volte.storm.common.pool.RedisProxyConnectionPool;
import com.eastcom.volte.storm.common.reader.Readable;
import com.eastcom.volte.storm.common.reader.ReaderFactory;
import com.eastcom.volte.storm.storm.service.LoaderService;
import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.util.Pool;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;


/**
 * Created by linghang.kong on 2016/7/5.
 * Base Storm Spout Class.
 * Don`t include any applied context, and just for some base spout functions,
 * but there are multi read threads to fetch data to spout queue.
 * One emitted thread consume the queue at the same time.
 */
public abstract class BaseSpoutImpl<T, E> extends BaseRichSpout implements BaseSpout {

    private final Logger logger = LoggerFactory.getLogger(BaseSpoutImpl.class);
    // configuration
    private String spoutTupleName = "spoutData";
    private int fileThread_NUM;
    //    private int readThread_NUM;
    private String mqURL;
    private String mqUserName;
    private String mqPassword;
    private String queueName;
    private String mqName;
    private int redisMinMultiple;
    private String redisPassword;
    private List<String> redisAddresses;
    // operation params
    private Pool<Jedis> jedisPool;
    private SpoutOutputCollector spoutOutputCollector;
    private Queue<E> dataQueue;

    public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
        logger.info(" Start Spout ID: " + context.getThisComponentId());
        config(conf);

        // init
        this.jedisPool = new RedisProxyConnectionPool(redisAddresses, redisPassword, redisMinMultiple);

        this.spoutOutputCollector = collector;

        // start loader services.
        for (int i = 0; i < fileThread_NUM; i++) {
            MQConsumer consumer = MQFactory.createConsumer(MQConsumer.ACTIVEMQ);
            try {
                consumer.createMQ(mqUserName, mqPassword, mqURL, queueName);
            } catch (InterruptedException e) {
                logger.error("Can't connect the message queue {}. Exception: {}.", mqURL, e.getMessage());
            }
            Readable readable = ReaderFactory.getReader(Readable.FTP_READER);
            new LoaderService(consumer, readable, jedisPool, spoutOutputCollector).start();
        }
        this.dataQueue = new ConcurrentLinkedQueue<E>();

    }

    public void nextTuple() {
        Thread.yield();
    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields(this.spoutTupleName));
    }

    abstract public void fetchTuple(Queue dataQueue) throws Exception;

    /**
     * Instanced the data to be an object.
     *
     * @param data E
     * @return T
     */
    abstract public T instanceObject(E data);

    public String getSpoutTupleName() {
        return spoutTupleName;
    }

    public void setSpoutTupleName(String spoutTupleName) {
        this.spoutTupleName = spoutTupleName;
    }

    public String getMqURL() {
        return mqURL;
    }

    public void setMqURL(String mqURL) {
        this.mqURL = mqURL;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public String getMqName() {
        return mqName;
    }

    public void setMqName(String mqName) {
        this.mqName = mqName;
    }

    public int getFileThread_NUM() {
        return fileThread_NUM;
    }

    public void setFileThread_NUM(int fileThread_NUM) {
        this.fileThread_NUM = fileThread_NUM;
    }


    public String getMqUserName() {
        return mqUserName;
    }

    public void setMqUserName(String mqUserName) {
        this.mqUserName = mqUserName;
    }

    public String getMqPassword() {
        return mqPassword;
    }

    public void setMqPassword(String mqPassword) {
        this.mqPassword = mqPassword;
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

    public Pool<Jedis> getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(Pool<Jedis> jedisPool) {
        this.jedisPool = jedisPool;
    }

    public Queue<E> getDataQueue() {
        return dataQueue;
    }

}
