package com.eastcom.volte.cyclework.load;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by linghang.kong on 2016/9/28.
 */
public class NetworkElementLoader implements Loader {

    private static final Logger logger = LoggerFactory.getLogger(NetworkElementLoader.class);

    private final long DELAY_TIME = 0 * 60;
    private final long LOAD_TIME = 1 * 60;
    private DBCPConnectionPool dbcpConnectionPool;
    private Jedis jedis;
    private String sql;
    private byte[] networkElementKeyName;
    private ScheduledExecutorService scheduledExecutorService;
    private Runnable load;

    public NetworkElementLoader(DBCPConnectionPool dbcpConnectionPool, Jedis jedis, String sql, String networkElementKeyName) {
        this.dbcpConnectionPool = dbcpConnectionPool;
        this.jedis = jedis;
        this.sql = sql;
        this.networkElementKeyName = networkElementKeyName.getBytes();

        this.scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    }


    public void doLoad() {
        if (load == null) {
            load = new Runnable() {
                public void run() {
                    Pipeline pipeline = null;
                    try {
                        int ip_address_column = 2;
                        int ne_name_column = 3;
                        ResultSet resultSet = dbcpConnectionPool.executeQuery(dbcpConnectionPool.getConnection(), sql);
                        ResultSetMetaData metaData = resultSet.getMetaData();

                        pipeline = jedis.pipelined();

                        for (int i = 1; i < metaData.getColumnCount(); i++) {
                            if ("ip_address" == metaData.getColumnName(i)) {
                                ip_address_column = i;
                            } else if ("ne_name" == metaData.getColumnName(i)) {
                                ne_name_column = i;
                            }
                        }
                        while (resultSet.next()) {
                            pipeline.hset(networkElementKeyName, resultSet.getString(ip_address_column).getBytes(), resultSet.getString(ne_name_column).getBytes());
                        }
                        pipeline.sync();
                    } catch (Exception e) {
                        logger.error(" Network Element load error, exception: {}.", e.getMessage());
                        pipeline.sync();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e1) {
                            logger.error("{}", e.getMessage());
                        }
                        while (!jedis.isConnected()) {
                            logger.info("reconnect redis.");
                            jedis.connect();
                        }
                    }
                }
            };
            scheduledExecutorService.scheduleAtFixedRate(load, DELAY_TIME, LOAD_TIME, TimeUnit.MINUTES);
        }
    }
}
