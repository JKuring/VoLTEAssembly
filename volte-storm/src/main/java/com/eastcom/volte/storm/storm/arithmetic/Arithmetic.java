package com.eastcom.volte.storm.storm.arithmetic;

import com.eastcom.volte.data.xdr.MergedXDR;

import java.util.Map;

/**
 * Created by linghang.kong on 2016/9/1.
 */
public interface Arithmetic<T> {

    public Arithmetic create(MergedXDR mergedXDR, Map<String, String> networkElementMap);

    public T doMerge();
}
