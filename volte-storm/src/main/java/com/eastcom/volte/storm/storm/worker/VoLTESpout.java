package com.eastcom.volte.storm.storm.worker;

import com.eastcom.volte.data.DataCommon;
import com.eastcom.volte.storm.storm.base.BaseSpoutImpl;
import org.apache.commons.collections.MapUtils;

import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Created by linghang.kong on 2016/8/25.
 */
public class VoLTESpout extends BaseSpoutImpl<DataCommon, String> {

    public void config(Map conf) {
        // 定制化参数需要改
        setSpoutTupleName(MapUtils.getString(conf, "project.spout.tuple.name"));
        setFileThread_NUM(MapUtils.getIntValue(conf, "project.spout.threads.file"));
        setMqURL(MapUtils.getString(conf, "project.activemq.broker.mqURL"));
        setQueueName(MapUtils.getString(conf, ("project.activemq.queue.name")));
        setMqName(MapUtils.getString(conf, "project.activemq.name"));
        setRedisMinMultiple(MapUtils.getInteger(conf, "jedis.minIdle"));
        setRedisPassword(MapUtils.getString(conf, "jedis.password"));
        setRedisAddresses((List<String>) conf.get("jedis.addresses"));
    }

    public void fetchTuple(Queue dataQueue) throws Exception {
        // do noting
    }

    public DataCommon instanceObject(String data) {
        return null;
    }
}