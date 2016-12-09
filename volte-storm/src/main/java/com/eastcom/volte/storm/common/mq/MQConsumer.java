package com.eastcom.volte.storm.common.mq;

import java.io.Closeable;

/**
 * Created by linghang.kong on 2016/8/15.
 */
public interface MQConsumer extends Closeable {
    static final int ACTIVEMQ = 0;
    static final int REDISMQ = 1;

    public void createMQ(String userName, String password, String brokerURL, String queueName) throws InterruptedException;


    public String receive() throws InterruptedException;
}
