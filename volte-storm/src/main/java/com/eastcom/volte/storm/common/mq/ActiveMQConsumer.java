package com.eastcom.volte.storm.common.mq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;

/**
 * Created by linghang.kong on 2016/8/15.
 */
public class ActiveMQConsumer implements MQConsumer {

    private static Logger logger = LoggerFactory.getLogger(ActiveMQConsumer.class);

    private String userName;
    private String password;
    private String brokerURL;
    private String queueName;
    private Connection connection;
    private Session session;
    private MessageConsumer messageConsumer;

    public void createMQ(String userName, String password, String brokerURL, String queueName) throws InterruptedException {
        this.userName = userName;
        this.password = password;
        this.brokerURL = brokerURL;
        this.queueName = queueName;
        this.init();
    }

    private void init() throws InterruptedException {
        try {
            logger.info("init Active Consumer.");
            logger.debug("userName {}, password {}, brokerURL {}.", userName, password, brokerURL);
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(userName, password, brokerURL);
            this.connection = connectionFactory.createConnection();
            this.connection.start();
            this.session = this.connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = this.session.createQueue(this.queueName);
            this.messageConsumer = this.session.createConsumer(destination);
            if (this.messageConsumer == null) {
                throw new JMSException("Can't create MQ.");
            }
        } catch (JMSException e) {
            logger.error(e.getMessage());
            this.reconnect();
        }
    }

    public String receive() throws InterruptedException {
        try {
            ObjectMessage objectMessage = (ObjectMessage) this.messageConsumer.receive();
            String message = (String) objectMessage.getObject();
            return message;
        } catch (JMSException e) {
            logger.error("MQ receive exception: {}.", e.getMessage());
            this.reconnect();
        }
        return null;
    }

    private void reconnect() throws InterruptedException {
        try {
            logger.info("reconnect the server of message queue");
            this.close();
            this.init();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            logger.error("reconnect false");
            throw e;
        }
    }

    public void close() {
        try {
            logger.info("close consumer");
            this.messageConsumer.close();
            this.session.close();
            this.connection.close();
            logger.info("successful close consumer");
        } catch (Exception e) {
            logger.error("close exception: " + e.getMessage());
        }
    }
}
