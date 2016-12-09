package com.eastcom.volte.storm.common.writer;

/**
 * Created by linghang.kong on 2016/8/17.
 */
public interface Writable {
    /**
     * Write data to some writer that implement the interface.
     *
     * @param fileUri file URL
     * @throws Exception
     */
    public void read(String fileUri) throws Exception;
}
