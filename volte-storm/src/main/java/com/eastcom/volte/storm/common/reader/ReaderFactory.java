package com.eastcom.volte.storm.common.reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by linghang.kong on 2016/8/18.
 */
public class ReaderFactory {
    private static Logger logger = LoggerFactory.getLogger(ReaderFactory.class);

    public static Readable getReader(int READER_TYPE) {
        logger.info("get a message reader");
        switch (READER_TYPE) {
            case Readable.FTP_READER:
                return new FTPReader();
            default:
                return null;
        }
    }
}
