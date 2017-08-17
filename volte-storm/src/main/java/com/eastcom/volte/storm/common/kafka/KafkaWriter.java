package com.eastcom.volte.storm.common.kafka;

import org.apache.commons.collections4.MapUtils;
import org.apache.kafka.clients.producer.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Properties;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Created by linghang.kong on 2017/8/10.
 */
public class KafkaWriter<K, V> {


    final Logger logger = LoggerFactory.getLogger(this.getClass());

    private Properties configProps;
    private KafkaProducer<K, V> kafkaProducer;

    private String topicName;
    private int kafkaWriterThreadsNum;

    @SuppressWarnings({"rawtypes", "unchecked"})
    public KafkaWriter(final Map conf) {

        checkArgument(conf.get(ConfigKey.PROJECT_BOLT_KAFKA_WRITER_TOPIC) != null);
        checkArgument(conf.get(ConfigKey.KAFKA_BOOTSTRAP_SERVERS) != null);
        checkArgument(conf.get(ConfigKey.KAFKA_BATCH_SIZE) != null);
        checkArgument(conf.get(ConfigKey.KAFKA_BUFFER_MEMORY) != null);
        checkArgument(conf.get(ConfigKey.KAFKA_KEY_SERIALIZER) != null);
        checkArgument(conf.get(ConfigKey.KAFKA_VALUE_SERIALIZER) != null);

//        Producer<String, String> producer = new KafkaProducer<>(props);
//        for(int i = 0; i < 100; i++)
//            producer.send(new ProducerRecord<String, String>("my-topic", Integer.toString(i), Integer.toString(i)));
//
//        producer.close();

        this.configProps = getKafkaConsumerConfig(conf);
        this.kafkaProducer = new KafkaProducer<K, V>(this.configProps);


        this.topicName = MapUtils.getString(conf, ConfigKey.PROJECT_BOLT_KAFKA_WRITER_TOPIC);
        this.kafkaWriterThreadsNum = MapUtils.getIntValue(conf, ConfigKey.PROJECT_BOLT_KAFKA_WRITER_THREADS);
    }

    public Producer<K, V> getProducer() {
        return this.kafkaProducer.createProducer();
    }


    private Properties getKafkaConsumerConfig(Map<String, Object> stormConfig) {
        String prefix = "kafka.";
        final Properties prop = new Properties();
        for (Map.Entry<String, Object> entry : stormConfig.entrySet()) {
            if (entry.getKey().startsWith(prefix)) {
                prop.setProperty(entry.getKey().substring(prefix.length()), String.valueOf(entry.getValue()));
            }
        }
        return prop;
    }

    public void close(Producer producer) {
        this.kafkaProducer.close(producer);
    }

    public String getTopicName() {
        return topicName;
    }

    public int getKafkaWriterThreadsNum() {
        return kafkaWriterThreadsNum;
    }
}
