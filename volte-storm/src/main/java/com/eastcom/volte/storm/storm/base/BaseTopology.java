package com.eastcom.volte.storm.storm.base;

import org.apache.storm.Config;
import org.apache.storm.generated.StormTopology;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.tuple.Fields;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by linghang.kong on 2016/7/5.
 */
public abstract class BaseTopology {

    private final Logger logger = LoggerFactory.getLogger(BaseTopology.class);

    private String spoutName;
    private String boltName;
    private String outputName;
    private int spoutParallelism;
    private int boltParallelism;
    private String spoutTupleName;
    private String hdfsURL;
    private String hdfsPath;

    private String volte_properties_path;

    private String redisPassword;
    private List<String> redisAddresses;

    private String jdbcDriver;
    private String jdbcUrl;
    private String jdbcUserName;
    private String jdbcPassword;
    private String tableName;


    public StormTopology getTopology(Config config) throws IOException {
        logger.info("Init topology configuration.");
        config(config);

        TopologyBuilder builder = new TopologyBuilder();

        BaseSpoutImpl spout = getSpout();
        BaseBoltImpl bolt = getBolt();
        OutputDataBolt outputDataBolt = getOputputDataBolt();

        builder.setSpout(spoutName, spout, spoutParallelism);
        builder.setBolt(boltName, bolt, boltParallelism).fieldsGrouping(spoutName, new Fields(spoutTupleName));
        builder.setBolt(outputName, outputDataBolt, boltParallelism).shuffleGrouping(boltName);

        return builder.createTopology();

    }

    abstract public void config(Config conf);

    abstract public BaseSpoutImpl getSpout();

    abstract public BaseBoltImpl getBolt();

    abstract public OutputDataBolt getOputputDataBolt();

    public Logger getLogger() {
        return logger;
    }

    public String getSpoutName() {
        return spoutName;
    }

    public void setSpoutName(String spoutName) {
        this.spoutName = spoutName;
    }

    public String getBoltName() {
        return boltName;
    }

    public void setBoltName(String boltName) {
        this.boltName = boltName;
    }

    public String getOutputName() {
        return outputName;
    }

    public void setOutputName(String outputName) {
        this.outputName = outputName;
    }

    public int getSpoutParallelism() {
        return spoutParallelism;
    }

    public void setSpoutParallelism(int spoutParallelism) {
        this.spoutParallelism = spoutParallelism;
    }

    public int getBoltParallelism() {
        return boltParallelism;
    }

    public void setBoltParallelism(int boltParallelism) {
        this.boltParallelism = boltParallelism;
    }

    public String getSpoutTupleName() {
        return spoutTupleName;
    }

    public void setSpoutTupleName(String spoutTupleName) {
        this.spoutTupleName = spoutTupleName;
    }

    public String getHdfsURL() {
        return hdfsURL;
    }

    public void setHdfsURL(String hdfsURL) {
        this.hdfsURL = hdfsURL;
    }

    public String getHdfsPath() {
        return hdfsPath;
    }

    public void setHdfsPath(String hdfsPath) {
        this.hdfsPath = hdfsPath;
    }

    public String getVolte_properties_path() {
        return volte_properties_path;
    }

    public void setVolte_properties_path(String volte_properties_path) {
        this.volte_properties_path = volte_properties_path;
    }

    public String getRedisPassword() {
        return redisPassword;
    }

    public void setRedisPassword(String redisPassword) {
        this.redisPassword = redisPassword;
    }

    public List<String> getRedisAddresses() {
        return redisAddresses;
    }

    public void setRedisAddresses(List<String> redisAddresses) {
        this.redisAddresses = redisAddresses;
    }

    public String getJdbcDriver() {
        return jdbcDriver;
    }

    public void setJdbcDriver(String jdbcDriver) {
        this.jdbcDriver = jdbcDriver;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getJdbcUserName() {
        return jdbcUserName;
    }

    public void setJdbcUserName(String jdbcUserName) {
        this.jdbcUserName = jdbcUserName;
    }

    public String getJdbcPassword() {
        return jdbcPassword;
    }

    public void setJdbcPassword(String jdbcPassword) {
        this.jdbcPassword = jdbcPassword;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
