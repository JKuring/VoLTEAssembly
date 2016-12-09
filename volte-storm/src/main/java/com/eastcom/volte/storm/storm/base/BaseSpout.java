package com.eastcom.volte.storm.storm.base;

import java.util.Map;
import java.util.Queue;

/**
 * Created by linghang.kong on 2016/7/6.
 * common spout interface for data processing.
 */
public interface BaseSpout<T, E> {

    /**
     * Configured some storm params.
     *
     * @param conf configuration
     */
    public void config(Map conf);

    /**
     * Fetched data from resource db or data stream etc.
     * Storm will open multi threads to process it.
     * The "dataQueue" param has a consumed queue, and need to put data object in it.
     *
     * @param dataQueue the queue of data source object.
     */
    public void fetchTuple(Queue<E> dataQueue) throws Exception;
}
