package com.eastcom.volte.cyclework;

import com.eastcom.volte.cyclework.clean.DataClear;
import com.eastcom.volte.cyclework.load.NetworkElementLoader;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by linghang.kong on 2016/10/9.
 */
public class CycleExecutor {
    private String tableName;
    private String netRedisIP;
    private int netRedisPort;
    private String netRedisPassword;

    private String databaseConfigFile;


    private int DELAY_TIME;
    private int CLEAR_TIME;

    private Jedis jedisNet;

    public static void main(String[] args) throws InterruptedException {
        try {
            InputStream path = CycleExecutor.class.getResourceAsStream("/cycle_task.properties");

            CycleExecutor cycleExecutor = new CycleExecutor();
            cycleExecutor.doLoad(path);
        } catch (Exception e) {
        }
        Thread.currentThread().join();
    }

    private void loadConfigration(InputStream path) throws IOException {
//
        Properties properties = new Properties();
        properties.load(path);

        this.tableName = properties.getProperty("tableName");
        this.netRedisIP = properties.getProperty("netRedisIP");
        this.netRedisPort = Integer.parseInt(properties.getProperty("netRedisPort"));
        this.netRedisPassword = properties.getProperty("netRedisPassword");

        this.databaseConfigFile = properties.getProperty("databaseConfigFile");

        this.jedisNet = new Jedis(netRedisIP, netRedisPort);
        this.jedisNet.auth(netRedisPassword);

        this.DELAY_TIME = Integer.parseInt(properties.getProperty("DELAY_TIME"));
        this.CLEAR_TIME = Integer.parseInt(properties.getProperty("CLEAR_TIME"));
    }

    public void doLoad(InputStream path) throws IOException {
        loadConfigration(path);
        NetworkElementLoader networkElementLoader = new NetworkElementLoader(this.databaseConfigFile, this.jedisNet, this.tableName);
        networkElementLoader.doLoad();

        new DataClear(this.DELAY_TIME, this.CLEAR_TIME).cleanScheduler();
    }
}
