package com.eastcom.volte.storm.storm.base;

import org.apache.storm.task.OutputCollector;

import java.util.Map;

/**
 * Created by linghang.kong on 2016/7/5.
 */
public interface BaseBolt<T, W> {

    /**
     * Configured some storm params.
     *
     * @param config configuration
     */
    public void config(Map config);

    public void analyzeTuple(W data, OutputCollector collector);


}
