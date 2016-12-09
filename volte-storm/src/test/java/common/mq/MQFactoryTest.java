package common.mq;

import com.eastcom.volte.storm.common.mq.MQConsumer;
import com.eastcom.volte.storm.common.mq.MQFactory;
import common.JUnit4ClassRunner;

/**
 * Created by linghang.kong on 2016/8/15.
 */
public class MQFactoryTest {
    @org.junit.Test
    public void createConsumer() throws Exception {
        JUnit4ClassRunner.initLog4j();
        System.out.println("开始测试");
        MQConsumer consumer = MQFactory.createConsumer(MQConsumer.ACTIVEMQ);
        consumer.createMQ(null, null, "tcp://10.221.247.23:61616", "Q_EVENT_PMCA_FILE");

        for (int i = 0; i < 1000; i++) {

            System.out.println(i + ":" + consumer.receive());

        }
        consumer.close();
        System.out.println("完成测试");
    }
}