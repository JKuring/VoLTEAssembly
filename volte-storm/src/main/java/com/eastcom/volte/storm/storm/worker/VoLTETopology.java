package com.eastcom.volte.storm.storm.worker;

import com.eastcom.volte.storm.storm.base.BaseBoltImpl;
import com.eastcom.volte.storm.storm.base.BaseSpoutImpl;
import com.eastcom.volte.storm.storm.base.BaseTopology;
import com.eastcom.volte.storm.storm.base.OutputDataBolt;
import org.apache.logging.log4j.core.util.Integers;
import org.apache.storm.Config;
import org.apache.storm.StormSubmitter;
import org.apache.storm.generated.AlreadyAliveException;
import org.apache.storm.generated.AuthorizationException;
import org.apache.storm.generated.InvalidTopologyException;
import org.apache.storm.hdfs.bolt.format.DefaultFileNameFormat;
import org.apache.storm.hdfs.bolt.format.DelimitedRecordFormat;
import org.apache.storm.hdfs.bolt.format.FileNameFormat;
import org.apache.storm.hdfs.bolt.format.RecordFormat;
import org.apache.storm.hdfs.bolt.rotation.FileRotationPolicy;
import org.apache.storm.hdfs.bolt.rotation.TimedRotationPolicy;
import org.apache.storm.hdfs.bolt.sync.CountSyncPolicy;
import org.apache.storm.hdfs.bolt.sync.SyncPolicy;

import java.io.IOException;
import java.util.List;

/**
 * Created by linghang.kong on 2016/8/31.
 */
public class VoLTETopology extends BaseTopology {

    // Hdfs Service
    private static final float CREATE_HDFS_FILE_INTERVAL = 5.0f;
    private static final int SYNC_COUNT = 100;

    //private static final String volte_properties_path = "../flux/volte-configration.properties";

    public static void main(String[] args) throws InvalidTopologyException, AuthorizationException, AlreadyAliveException, IOException, InterruptedException {

        Config config = new Config();
        VoLTETopology voLTETopology = new VoLTETopology();

        // 提交到集群
        StormSubmitter.submitTopology("volte-topology", config, voLTETopology.getTopology(config));

//        // 自死锁主线程
//        System.out.println("###### 自锁主线程1 ######");
//        Thread.currentThread().join();
//        System.out.println("###### 自锁主线程2 ######");

    }

    public void config(Config config) {
        setSpoutName((String) config.get("project.spout.name"));
        setBoltName((String) config.get("project.bolt.name"));
        setOutputName((String) config.get("project.output.name"));

        setSpoutParallelism(Integers.parseInt(String.valueOf(config.get("project.spout.parallelism"))));
        setBoltParallelism(Integers.parseInt(String.valueOf(config.get("project.bolt.parallelism"))));

        setSpoutTupleName((String) config.get("project.spout.tuple.name"));

        setHdfsURL((String) config.get("project.hdfs.url"));
        setHdfsPath((String) config.get("project.hdfs.path"));

        setVolte_properties_path((String) config.get("project.properties.path"));

        setRedisAddresses((List<String>) config.get("jedis.addresses"));
        setRedisPassword((String) config.get("jedis.password"));

        setJdbcDriver((String) config.get("project.jdbc.driver"));
        setJdbcUrl((String) config.get("project.jdbc.url"));
        setJdbcUserName((String) config.get("project.jdbc.username"));
        setJdbcPassword((String) config.get("project.jdbc.password"));
        setTableName((String) config.get("project.jdbc.table.name"));
//
//        Properties volte_properties = new Properties();
//        FileInputStream fileInputStream = new FileInputStream(getVolte_properties_path());
//        volte_properties.load(fileInputStream);

    }

    public BaseSpoutImpl getSpout() {
        return new VoLTESpout();
    }

    public BaseBoltImpl getBolt() {
        return new VoLTEBolt();
    }

    public OutputDataBolt getOputputDataBolt() {
        OutputDataBolt outputDataBolt = new OutputDataBolt();
        // use "|" instead of "," for field delimiter
        RecordFormat format = new DelimitedRecordFormat().withFieldDelimiter("|");
        // sync the filesystem after every 1k tuples
        SyncPolicy syncPolicy = new CountSyncPolicy(SYNC_COUNT);
        // rotate files， 5 minutes
        FileRotationPolicy rotationPolicy = new TimedRotationPolicy(CREATE_HDFS_FILE_INTERVAL, TimedRotationPolicy.TimeUnit.MINUTES);
        FileNameFormat fileNameFormat = new DefaultFileNameFormat().withPath(getHdfsPath()).withPrefix("volte_")
                .withExtension(".csv");
        outputDataBolt.withFsUrl(getHdfsURL()).withFileNameFormat(fileNameFormat).withRecordFormat(format)
                .withRotationPolicy(rotationPolicy).withSyncPolicy(syncPolicy);
        return outputDataBolt;
    }

}
