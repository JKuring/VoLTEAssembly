package com.eastcom.volte.cyclework.load;


import com.eastcom.volte.cyclework.beans.NetworkElement;
import com.eastcom.volte.cyclework.dao.NetworkElementDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by linghang.kong on 2016/9/28.
 * 网元信息加载周期为1分钟，通过调节LOAD_TIME更改周期时间。
 */
public class NetworkElementLoader implements Loader {

    private static final Logger logger = LoggerFactory.getLogger(NetworkElementLoader.class);

    private final long DELAY_TIME = 0 * 60;
    private final long LOAD_TIME = 1;
    private String databaseConfigFile;
    private Jedis jedis;
    private byte[] networkElementKeyName;
    private ScheduledExecutorService scheduledExecutorService;
    private Runnable load;
    private SqlSessionFactory sqlSessionFactory;

    public NetworkElementLoader(String databaseConfigFile, Jedis jedis, String networkElementKeyName) {
        this.databaseConfigFile = databaseConfigFile;
        DataBaseConnection.init(this.databaseConfigFile);
        this.sqlSessionFactory = DataBaseConnection.getSqlSessionFactory();

        this.jedis = jedis;
        this.networkElementKeyName = networkElementKeyName.getBytes();

        this.scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    }


    public void doLoad() {
        if (load == null) {
            load = new Runnable() {
                public void run() {
                    Pipeline pipeline = jedis.pipelined();
                    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
                        List<NetworkElement> networkElementList = sqlSession.getMapper(NetworkElementDao.class).selectAll();

                        for (NetworkElement netWorkElement : networkElementList
                                ) {
                            pipeline.hset(networkElementKeyName, netWorkElement.getIp().getBytes(), netWorkElement.getNetwork_element_name().getBytes());
                        }
                        pipeline.sync();
                        logger.info("load network element table.");
                    } catch (Exception e) {
                        logger.error(" Network Element load error, exception: {}.", e.getMessage());
                        pipeline.sync();
                        try {
                            pipeline.close();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
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
