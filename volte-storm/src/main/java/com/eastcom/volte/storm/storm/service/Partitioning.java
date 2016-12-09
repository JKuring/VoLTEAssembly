package com.eastcom.volte.storm.storm.service;

import java.util.List;

/**
 * Created by linghang.kong on 2016/8/25.
 */
public interface Partitioning<T, E> {

    public static String xdrPartitionPrefix = "MergedXDR-";

    public static String dataPartitionPrefix = "DataPartition-";

    /**
     * put data to data partition
     *
     * @param dataCommon data object
     * @return boolean
     */
    public boolean put(T dataCommon);

    /**
     * get data from data partition
     *
     * @param xdr_id xdr id
     * @return List of data object
     */
    public List<T> get(List<E> xdr_id);

}
