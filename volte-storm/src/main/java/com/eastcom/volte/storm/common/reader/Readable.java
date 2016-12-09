package com.eastcom.volte.storm.common.reader;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by linghang.kong on 2016/8/15.
 * The interface about read data form source.
 */
public interface Readable {

    public static int FTP_READER = 0;


    /**
     * Read data from some reader that implement the interface.
     *
     * @param fileUri file URL
     * @return BufferedReader, store data in the buffer.
     * @throws Exception
     */
    public BufferedReader read(String fileUri) throws IOException;

}
