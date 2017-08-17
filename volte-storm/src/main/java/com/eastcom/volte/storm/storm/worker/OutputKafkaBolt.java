package com.eastcom.volte.storm.storm.worker;

import com.eastcom.volte.storm.common.kafka.KafkaWriter;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Tuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by linghang.kong on 2017/8/10.
 */
public class OutputKafkaBolt extends BaseRichBolt {

    private final Logger logger = LoggerFactory.getLogger(OutputKafkaBolt.class);
    private final int bufferQueueSize = 3000;
    private ExecutorService executor;
    private BlockingQueue<String> bufferQueue;
    private KafkaWriter<String, String> kafkaWriter;

    @Override
    public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {

        this.kafkaWriter = new KafkaWriter<>(stormConf);

        this.executor = Executors.newFixedThreadPool(this.kafkaWriter.getKafkaWriterThreadsNum());
        this.bufferQueue = new ArrayBlockingQueue<>(bufferQueueSize);

        for (int i = 0; i < kafkaWriter.getKafkaWriterThreadsNum(); i++) {
            this.executor.execute(new Runnable() {
                @Override
                public void run() {
                    Producer<String, String> kafkaProducer = kafkaWriter.getProducer();
                    String topic = kafkaWriter.getTopicName();
                    while (true) {
                        try {
                            if (bufferQueue.isEmpty()) {
                                Thread.sleep(5);
                            } else {
                                sendToKafka(bufferQueue.poll(), kafkaProducer, topic);
                            }
                        } catch (Exception e) {
                            logger.warn("Failed to fetch data.");
                        }
                    }
                }
            });
        }

    }

    @Override
    public void execute(Tuple input) {
        String csfb = String.valueOf(input.getValueByField("boltData"));
        try {
            bufferQueue.put(csfb);
        } catch (InterruptedException e) {
            logger.warn("buffer queue exception.", e);
            try {
                Thread.sleep(2);
            } catch (InterruptedException e1) {
//                execute(input);
            }
        }
    }

    private synchronized void sendToKafka(String data, Producer<String, String> producer, String topic) {
        if (data != null) {
            producer.send(new ProducerRecord<String, String>(topic, data));
        }
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        //To do nothing
    }
}
