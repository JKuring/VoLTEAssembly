package com.eastcom.volte.storm.common.kafka;

import org.apache.kafka.clients.producer.Producer;

import java.util.Properties;

/**
 * Created by linghang.kong on 2017/8/10.
 */
public class KafkaProducer<K, V> {

    private Properties configProps;

    public KafkaProducer(Properties configProps) {
        this.configProps = configProps;
    }

    public Producer<K, V> createProducer() {
        Producer<K, V> producer = new org.apache.kafka.clients.producer.KafkaProducer<>(this.configProps);
        return producer;
    }

    public void close(Producer producer) {
        producer.close();
    }
}
