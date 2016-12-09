package com.eastcom.volte.storm.common.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by linghang.kong on 2016/8/15.
 */
public class MQFactory {

    public static Logger logger = LoggerFactory.getLogger(MQFactory.class);

    public static MQConsumer createConsumer(int CONSUMER_TYPE) {
        logger.info("get a message queue");
        switch (CONSUMER_TYPE) {
            case MQConsumer.ACTIVEMQ:
                return new ActiveMQConsumer();
            case MQConsumer.REDISMQ:
                return null;
            default:
                return null;
        }
    }
}
