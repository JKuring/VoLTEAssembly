package com.eastcom.volte.storm.storm.worker;

import com.eastcom.volte.data.DataCommon;
import com.eastcom.volte.storm.common.kafka.ConfigKey;
import com.eastcom.volte.storm.common.kafka.KafkaReader;
import com.eastcom.volte.storm.common.mq.MQConsumer;
import com.eastcom.volte.storm.common.mq.MQFactory;
import com.eastcom.volte.storm.common.reader.Readable;
import com.eastcom.volte.storm.common.reader.ReaderFactory;
import com.eastcom.volte.storm.storm.base.BaseSpoutImpl;
import com.eastcom.volte.storm.storm.service.LoaderService;
import org.apache.commons.collections.MapUtils;
import org.apache.storm.spout.SpoutOutputCollector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by linghang.kong on 2016/8/25.
 */
public class VoLTESpout extends BaseSpoutImpl<DataCommon, String> {

    private final Logger logger = LoggerFactory.getLogger(VoLTESpout.class);

    private SpoutOutputCollector spoutOutputCollector;


    public void config(Map conf) {
        // 定制化参数需要改
        setSpoutType(MapUtils.getString(conf, ConfigKey.PROJECT_SPOUT_TYPE));
        setFileThread_NUM(MapUtils.getIntValue(conf, ConfigKey.PROJECT_SPOUT_FTP_READER_THREADS));
        setMqURL(MapUtils.getString(conf, ConfigKey.PROJECT_MQ_BROKER_URL));
        setQueueName(MapUtils.getString(conf, ConfigKey.PROJECT_MQ_QUEUE_NAME));
        setRedisMinMultiple(MapUtils.getInteger(conf, ConfigKey.JEDIS_MINDLE));
        setRedisPassword(MapUtils.getString(conf, ConfigKey.JEDIS_PASSWORD));
        setRedisAddresses((List<String>) conf.get(ConfigKey.JEDIS_ADDRESSES));

        this.spoutOutputCollector = getSpoutOutputCollector();
    }

    public void fetchTuple(Queue dataQueue) throws Exception {

        String spoutType = getSpoutType();
        // start loader services.
        if (Objects.equals(spoutType, "ftp")) {
            for (int i = 0; i < getFileThread_NUM(); i++) {
                MQConsumer consumer = MQFactory.createConsumer(MQConsumer.ACTIVEMQ);
                try {
                    consumer.createMQ(getMqUserName(), getMqPassword(), getMqURL(), getQueueName());
                } catch (InterruptedException e) {
                    logger.error("Can't connect the message queue {}. Exception: {}.", getMqURL(), e.getMessage());
                }
                Readable readable = ReaderFactory.getReader(Readable.FTP_READER);
                new LoaderService(consumer, readable, getJedisPool(), this.spoutOutputCollector).start();
            }
        } else if (Objects.equals(spoutType, "kafka")) {
            new KafkaReader<>(getConfig(), this);
            for (int i = 0; i < MapUtils.getIntValue(getConfig(), ConfigKey.PROJECT_SPOUT_KAFKA_READER_THREADS); i++) {
                new LoaderService(getJedisPool(), this.spoutOutputCollector, getBufferQueue()).start();
            }
        }
    }

    public DataCommon instanceObject(String data) {
        return null;
    }

    @Override
    public void afterEmitFile(String topic, int lines, long useTime) {

    }

    @Override
    public void afterEmit(String topic, Object data, String message) {

    }

    @Override
    public void putValues(BlockingQueue bufferQueue, Object data, String topicName) throws Exception {
        // put queue
        bufferQueue.put(data);
    }


    @Override
    public void afterParse(Object data) {

    }
}