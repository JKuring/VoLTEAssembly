package com.eastcom.volte.storm.storm.worker;

import com.eastcom.volte.data.DataCommon;
import com.eastcom.volte.data.xdr.MergedXDR;
import com.eastcom.volte.storm.common.kafka.ConfigKey;
import com.eastcom.volte.storm.storm.arithmetic.MergedArithmetic;
import com.eastcom.volte.storm.storm.base.BaseBoltImpl;
import org.apache.commons.collections.MapUtils;
import org.apache.storm.task.OutputCollector;
import org.apache.storm.tuple.Values;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * Created by linghang.kong on 2016/8/26.
 */
public class VoLTEBolt extends BaseBoltImpl<String, DataCommon> {

    private static final Logger logger = LoggerFactory.getLogger(VoLTEBolt.class);

    private String xdr_id = null;

    // 为什么这里需要序列化对象呢？
    // 为什么使用kryo的序列化com.esotericsoftware.kryo.serializers.JavaSerializer 不行呢？
    //com.eastcom.volte.storm.storm.arithmetic.MergedArithmetic: com.esotericsoftware.kryo.serializers.JavaSerializer
//    private Arithmetic arithmetic = new MergedArithmetic();


    public void config(Map config) {
        // read configuration from local yaml file


        setRedisMinMultiple(MapUtils.getIntValue(config, ConfigKey.JEDIS_MINDLE));
        setRedisPassword(MapUtils.getString(config, ConfigKey.JEDIS_PASSWORD));
        setRedisAddresses((List<String>) config.get(ConfigKey.JEDIS_ADDRESSES));
        setTableName((String) config.get(ConfigKey.PROJECT_NETWORK_ELEMENT_TABLE_NAME));

    }


    @Override
    public void analyzeTuple(DataCommon dataCommon, OutputCollector collector) {
        try {
            MergedXDR mergedXDR = (MergedXDR) dataCommon;
            String volte = new MergedArithmetic(getJedisPool()).create(mergedXDR, getNetworkElementData()).doMerge().toString();
            if (volte != null)
                collector.emit(new Values(volte));
        } catch (Exception e) {
            logger.error("Exception: {}.", e.getMessage());
        }
    }

}
