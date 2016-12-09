package com.eastcom.volte.storm.storm.arithmetic;

import com.eastcom.volte.data.DataCommon;
import com.eastcom.volte.data.xdr.MergedXDR;
import com.eastcom.volte.storm.storm.service.DataPartitioning;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.util.Pool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linghang.kong on 2016/9/1.
 */
public class Analysis {

    private static final Logger logger = LoggerFactory.getLogger(Analysis.class);

    private Pool<Jedis> jedisPool;
    private DataPartitioning dataPartitioning;

    public Analysis setRedis(Pool<Jedis> jedisPool) {
        this.jedisPool = jedisPool;
        this.dataPartitioning = new DataPartitioning(this.jedisPool);
        return this;
    }

    public List<DataCommon> analyse(MergedXDR mergedXDR) {
        List<String> dataList = new ArrayList();
        try {
            dataList.add(mergedXDR.getXDR_ID1());
            dataList.add(mergedXDR.getXDR_ID2());
            dataList.add(mergedXDR.getXDR_ID3());
            dataList.add(mergedXDR.getXDR_ID4());
            dataList.add(mergedXDR.getXDR_ID5());
            dataList.add(mergedXDR.getXDR_ID6());
            dataList.add(mergedXDR.getXDR_ID7());
            dataList.add(mergedXDR.getXDR_ID8());
            dataList.add(mergedXDR.getXDR_ID9());
            dataList.add(mergedXDR.getXDR_ID10());
            dataList.add(mergedXDR.getXDR_ID11());
            dataList.add(mergedXDR.getXDR_ID12());
            dataList.add(mergedXDR.getXDR_ID13());
            dataList.add(mergedXDR.getXDR_ID14());
            dataList.add(mergedXDR.getXDR_ID15());
            dataList.add(mergedXDR.getXDR_ID16());
            dataList.add(mergedXDR.getXDR_ID17());
            dataList.add(mergedXDR.getXDR_ID18());
            dataList.add(mergedXDR.getXDR_ID19());
            dataList.add(mergedXDR.getXDR_ID20());
            dataList.add(mergedXDR.getXDR_ID21());
            dataList.add(mergedXDR.getXDR_ID22());
            dataList.add(mergedXDR.getXDR_ID23());
            dataList.add(mergedXDR.getXDR_ID24());
            dataList.add(mergedXDR.getXDR_ID25());
            dataList.add(mergedXDR.getXDR_ID26());
            dataList.add(mergedXDR.getXDR_ID27());
            dataList.add(mergedXDR.getXDR_ID28());
            dataList.add(mergedXDR.getXDR_ID29());
            dataList.add(mergedXDR.getXDR_ID30());
            dataList.add(mergedXDR.getXDR_ID31());
            dataList.add(mergedXDR.getXDR_ID32());
            dataList.add(mergedXDR.getXDR_ID33());
            dataList.add(mergedXDR.getXDR_ID34());
            dataList.add(mergedXDR.getXDR_ID35());
            dataList.add(mergedXDR.getXDR_ID36());
            dataList.add(mergedXDR.getXDR_ID37());
            dataList.add(mergedXDR.getXDR_ID38());
            dataList.add(mergedXDR.getXDR_ID39());
            dataList.add(mergedXDR.getXDR_ID40());
            dataList.add(mergedXDR.getXDR_ID41());
            dataList.add(mergedXDR.getXDR_ID42());
            dataList.add(mergedXDR.getXDR_ID43());
            dataList.add(mergedXDR.getXDR_ID44());
            dataList.add(mergedXDR.getXDR_ID45());
            dataList.add(mergedXDR.getXDR_ID46());
            dataList.add(mergedXDR.getXDR_ID47());
            dataList.add(mergedXDR.getXDR_ID48());
            dataList.add(mergedXDR.getXDR_ID49());
            dataList.add(mergedXDR.getXDR_ID50());
            dataList.add(mergedXDR.getXDR_ID51());
            dataList.add(mergedXDR.getXDR_ID52());
            dataList.add(mergedXDR.getXDR_ID53());
            dataList.add(mergedXDR.getXDR_ID54());
            dataList.add(mergedXDR.getXDR_ID55());
            dataList.add(mergedXDR.getXDR_ID56());
            dataList.add(mergedXDR.getXDR_ID57());
            dataList.add(mergedXDR.getXDR_ID58());
        } catch (Exception e) {
            logger.error("analysis exception: {}.", e.getMessage());
        }

        return this.dataPartitioning.get(dataList);
    }
}
