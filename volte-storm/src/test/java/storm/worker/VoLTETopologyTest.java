package storm.worker;

import com.eastcom.volte.storm.storm.worker.VoLTETopology;
import common.JUnit4ClassRunner;
import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.utils.Utils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by linghang.kong on 2016/9/2.
 */
public class VoLTETopologyTest {

    private final Logger logger = LoggerFactory.getLogger(VoLTETopologyTest.class);

    @Test
    public void main() throws Exception {
        JUnit4ClassRunner.initLog4j();
        logger.info("启动程序");

        Config config = new Config();
        VoLTETopology voLTETopology = new VoLTETopology();

        // 本地模式用于开发、测试，模拟一个完整的集群模式
        HashMap env = new HashMap();
        env.put("project.spout.parallelism", 10);
        env.put("project.bolt.parallelism", 10);

        env.put("project.spout.name", "VoLTESpout");
        env.put("project.bolt.name", "VoLTEBolt");
        env.put("project.output.name", "OutputDataBolt");
        env.put("project.spout.threads.file", 1);
        env.put("project.spout.threads.read", 1);
        env.put("project.activemq.broker.mqURL", "tcp://10.221.247.23:61616");
        env.put("project.activemq.name", "ActiveMQ");
        env.put("project.activemq.queue.name", "Q_EVENT_PMCA_FILE");
        env.put("project.spout.tuple.name", "spoutData");
        env.put("project.bolt.tuple.name", "boltData");
        env.put("project.output.name", "outputHDFS");
        env.put("project.hdfs.url", "hdfs://nameservice1");
        env.put("project.hdfs.path", "/rawdata/xdr/lte/volte/volte_timeseg");
//        env.put("project.properties.path", "E:\\百度云同步盘\\东信软件EastCom\\workspace\\VoLTEAssembly\\volte-storm\\src\\main\\resources\\flux\\volte-configration.properties");

        JedisInfo jedisInfo = new JedisInfo();
        env.put("jedis.minIdle", jedisInfo.getMinIdle());
        env.put("jedis.password", jedisInfo.getPassword());
        env.put("jedis.addresses", jedisInfo.getAddresses());
        logger.info(Arrays.toString(env.keySet().toArray()));

        config.putAll(env);
        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology("volte-topology", config, voLTETopology.getTopology(config));
        Utils.sleep(10000);
        cluster.killTopology("volte-topology");
        cluster.shutdown();

    }

}