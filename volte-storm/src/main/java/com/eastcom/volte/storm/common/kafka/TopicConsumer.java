package com.eastcom.volte.storm.common.kafka;

import com.eastcom.volte.data.DataParser;
import com.google.common.base.Charsets;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TopicConsumer<QV> extends Thread {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private Consumer<byte[], byte[]> consumer;

    private ReadHook<QV> readHook;

    public TopicConsumer(String name, Consumer<byte[], byte[]> consumer, ReadHook<QV> readHook) {
        super(name);
        this.consumer = consumer;
        this.readHook = readHook;
    }

    @Override
    public void run() {
        logger.warn("Thread {} started.", this.getName());
        while (this.isInterrupted() == false) {
            try {
                fillBuffer();
            } catch (InterruptedException e) {
                this.interrupt();
            } catch (Throwable e) {
                logger.error("", e);
            }
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        logger.warn("线程{}中断退出。", this.getName());
    }

    private void fillBuffer() throws Exception {
        while (true) {
            ConsumerRecords<byte[], byte[]> records = consumer.poll(100);
            if (records == null) {
                continue;
            }
            for (ConsumerRecord<byte[], byte[]> record : records) {
                String topicName = record.topic();
                if (topicName.startsWith("r_volte_")) {
                    topicName = topicName.substring(8);
                } else if (topicName.startsWith("r_nc_")) {
                    topicName = topicName.substring(2);
                } else {
                    throw new Exception("not found topic " + topicName);
                }
                String line = new String(record.value(), Charsets.UTF_8);
                DataParser<?> csvParser = getCSVParser(topicName);
                Object csvObject = toObject(topicName, csvParser, line);
                if (csvObject != null) {
                    readHook.afterParse(csvObject);
                    readHook.putValues(readHook.getBufferQueue(), csvObject, topicName);
                    readHook.afterEmit(topicName, csvObject, line);
                }
            }
        }
    }

    protected DataParser<?> getCSVParser(String topicName) {
        return DataParser.getParser(topicName);
    }

    protected Object toObject(String topic, DataParser<?> csvParser, String line) {
        Object data = null;
        if (csvParser != null) {
            try {
                data = csvParser.parse(csvParser.split(line));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return data;
    }
}
