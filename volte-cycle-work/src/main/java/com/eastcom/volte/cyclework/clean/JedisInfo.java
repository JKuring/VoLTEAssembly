package com.eastcom.volte.cyclework.clean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by linghang.kong on 2016/9/2.
 */
public class JedisInfo {

    private static final Logger logger = LoggerFactory.getLogger(JedisInfo.class);


    private int minIdle;
    private String password;
    private List<String> addresses;

    public JedisInfo(String password, int minIdle) {
        this.password = password;
        this.minIdle = minIdle;
        this.addresses = new ArrayList<>();
        String userDir = System.getProperty("user.dir") + "/../conf/redisList.txt";
        logger.info("redis list path: {}.", userDir);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(userDir))) {
            String tmp;
            while ((tmp = bufferedReader.readLine()) != null) {
                tmp = tmp.replaceAll(" ", "");
                logger.info(tmp);
                addresses.add(tmp);
            }
            logger.info("Finish fetching redis list.");
        } catch (IOException e) {
            logger.error("Failed to read the redis list.", e);
        }
    }

    public int getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }
}
