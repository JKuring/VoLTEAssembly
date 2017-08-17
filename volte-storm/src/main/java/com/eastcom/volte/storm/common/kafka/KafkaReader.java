package com.eastcom.volte.storm.common.kafka;

import org.apache.commons.collections4.MapUtils;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static com.google.common.base.Preconditions.checkArgument;


/**
 * yaml配置如下:
 * <p>
 * kafka.topics.names: ["topic1:2", "topic2:2"] kafka.group.id: ue_topology
 * kafka.bootstrap.servers: "x.x.x.x:xxxx/root" kafka.key.deserializer: xxx
 * kafka.value.deserializer: xxx
 *
 * @author Louyj
 */

public class KafkaReader<QV> {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    private List<Thread> readers;

    @SuppressWarnings({"rawtypes", "unchecked"})
    public KafkaReader(final Map conf, ReadHook<QV> readHook) {

        checkArgument(conf.get(ConfigKey.KAFKA_GROUP_ID) != null);
        checkArgument(conf.get(ConfigKey.KAFKA_BOOTSTRAP_SERVERS) != null);
        checkArgument(conf.get(ConfigKey.KAFKA_TOPIC_NAMES) != null);
        checkArgument(conf.get(ConfigKey.KAFKA_KEY_DESERIALIZER) != null);
        checkArgument(conf.get(ConfigKey.KAFKA_VALUE_DESERIALIZER) != null);

        Properties configProps = getKafkaConsumerConfig(conf);

        List<String> topics = (List<String>) conf.get(ConfigKey.KAFKA_TOPIC_NAMES);
        Integer threadNum = MapUtils.getInteger(conf, ConfigKey.PROJECT_SPOUT_KAFKA_READER_THREADS, 3);

        this.readers = new ArrayList<>();
        for (int i = 0; i < threadNum; i++) {
            Consumer<byte[], byte[]> consumer = new KafkaConsumer<>(configProps);
            consumer.subscribe(topics);

            String threadName = "kafka-reader-" + i;
            TopicConsumer reader = new TopicConsumer(threadName, consumer, readHook);
            this.readers.add(reader);
            reader.start();
        }
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

}
