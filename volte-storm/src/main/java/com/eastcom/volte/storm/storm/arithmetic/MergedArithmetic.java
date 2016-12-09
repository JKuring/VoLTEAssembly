package com.eastcom.volte.storm.storm.arithmetic;

import com.eastcom.volte.data.volte.VoLTE;
import com.eastcom.volte.data.xdr.MergedXDR;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.util.Pool;

import java.util.Map;

/**
 * Created by linghang.kong on 2016/9/1.
 */
public class MergedArithmetic implements Arithmetic<VoLTE> {

    private static final Logger logger = LoggerFactory.getLogger(MergedArithmetic.class);

    private Analysis analysis;
    private Merger merger;
    private MergedXDR mergedXDR;
    private Map<String, String> networkElementMap;
    private Pool<Jedis> jedisPool;

    public MergedArithmetic(Pool<Jedis> jedisPool) {
        this.jedisPool = jedisPool;
        this.analysis = new Analysis();
        this.merger = new Merger();
    }

    public MergedArithmetic create(MergedXDR mergedXDR, Map<String, String> networkElementMap) {
        this.mergedXDR = mergedXDR;
        this.networkElementMap = networkElementMap;
        this.analysis.setRedis(this.jedisPool);
        return this;
    }

    @Override
    public VoLTE doMerge() {
        try {
            return this.merger.create(mergedXDR, this.analysis.analyse(mergedXDR), networkElementMap).doMerge();
        } catch (Exception e) {
            logger.error("Failed to merge xdr, exception: {}.", e.getMessage());
        }
        return null;
    }
}
