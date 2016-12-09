package com.eastcom.volte.cyclework;

import com.eastcom.volte.cyclework.clean.DataClear;
import com.eastcom.volte.cyclework.load.DBCPConnectionPool;
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

    private String driverName;
    private String connectURL;
    private String userName;
    private String password;


    private String clearRedisIP;
    private int clearRedisPort;
    private String clearRedisPassword;

    private int DELAY_TIME;
    private int CLEAR_TIME;

    private Jedis jedisNet;
    private DBCPConnectionPool dbcpConnectionPool;
    private Jedis jedisClear;

    public static void main(String[] args) throws InterruptedException, IOException {
        InputStream path = CycleExecutor.class.getResourceAsStream("/cycle_task.properties");
//        String path = "E:\\百度云同步盘\\东信软件EastCom\\workspace\\VoLTEAssembly\\volte-cycle-work\\src\\main\\resources\\cycle_task.properties";
//        String path = "cycle_task.properties";
        CycleExecutor cycleExecutor = new CycleExecutor();
        cycleExecutor.doLoad(path);

        Thread.currentThread().join();
    }

    private void loadConfigration(InputStream path) throws IOException {
//
        Properties properties = new Properties();
        properties.load(path);

        tableName = properties.getProperty("tableName");
        netRedisIP = properties.getProperty("netRedisIP");
        netRedisPort = Integer.parseInt(properties.getProperty("netRedisPort"));
        netRedisPassword = properties.getProperty("netRedisPassword");

        driverName = properties.getProperty("driverName");
        connectURL = properties.getProperty("connectURL");
        userName = properties.getProperty("userName");
        password = properties.getProperty("password");

        jedisNet = new Jedis(netRedisIP, netRedisPort);
        jedisNet.auth(netRedisPassword);
        dbcpConnectionPool = new DBCPConnectionPool(driverName, connectURL, userName, password);


        clearRedisIP = properties.getProperty("clearRedisIP");
        clearRedisPort = Integer.parseInt(properties.getProperty("clearRedisPort"));
        clearRedisPassword = properties.getProperty("clearRedisPassword");

        DELAY_TIME = Integer.parseInt(properties.getProperty("DELAY_TIME"));
        CLEAR_TIME = Integer.parseInt(properties.getProperty("CLEAR_TIME"));
    }

    public void doLoad(InputStream path) throws IOException {
        loadConfigration(path);
        NetworkElementLoader networkElementLoader = new NetworkElementLoader(dbcpConnectionPool, jedisNet, "select * from " + tableName + ";", tableName);
        networkElementLoader.doLoad();

        new DataClear(DELAY_TIME, CLEAR_TIME).cleanScheduler();
    }
}
