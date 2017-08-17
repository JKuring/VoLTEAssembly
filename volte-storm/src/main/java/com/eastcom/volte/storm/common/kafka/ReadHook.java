package com.eastcom.volte.storm.common.kafka;

import java.util.concurrent.BlockingQueue;

public interface ReadHook<QV> {

    public void afterEmitFile(String topic, int lines, long useTime);

    public void afterEmit(String topic, Object data, String message);

    public void putValues(BlockingQueue<QV> bufferQueue, Object data, String topicName) throws Exception;

    public BlockingQueue<QV> getBufferQueue();

    public void afterParse(Object data);
}
