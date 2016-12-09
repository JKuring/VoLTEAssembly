package com.eastcom.volte.storm.storm.service;

import com.eastcom.volte.data.DataCommon;
import com.eastcom.volte.data.DataParser;
import com.eastcom.volte.data.xdr.MergedXDR;
import com.eastcom.volte.storm.common.mq.MQConsumer;
import com.eastcom.volte.storm.common.reader.Readable;
import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.tuple.Values;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.util.Pool;

import java.io.BufferedReader;

/**
 * Created by linghang.kong on 2016/8/18.
 */
public class LoaderService extends Thread implements Loader {

    private static Logger logger = LoggerFactory.getLogger(LoaderService.class);
    private static int count = 0;
    private final int THREAD_WRITING = 1000;
    private MQConsumer mqConsumer;
    private Readable readable;
    private Pool<Jedis> jedisPool;
    private SpoutOutputCollector spoutOutputCollector;

    public LoaderService(MQConsumer mqConsumer, Readable readable, Pool<Jedis> jedisPool, SpoutOutputCollector spoutOutputCollector) {
        this.mqConsumer = mqConsumer;
        this.readable = readable;
        this.jedisPool = jedisPool;
        this.spoutOutputCollector = spoutOutputCollector;
        init();
    }

    private void init() {
//        if (this.jedis != null) {
//            this.jedisPool.returnResource(jedis);
//        }
//        this.jedis = this.jedisPool.getResource();
    }

    @Override
    public void run() {
        try {
            doLoad();
        } catch (Exception e) {
            logger.error("Exception:{}, restart the thread: {}.", e.getMessage(), Thread.currentThread().getId());
            init();
            doLoad();
        }
    }

    /**
     * load data
     */
    public void doLoad() {
        String messgae;
        String type = null;
        DataParser dataParser;

        BufferedReader bufferedReader;

        DataCommon dataCommon;
        // same jedis handle to process data，is OK? yes now.
//        XDRPartitioning xdrPartitioning = new XDRPartitioning(this.jedis);
        DataPartitioning dataPartitioning = new DataPartitioning(this.jedisPool);

        try {
            while (true) {
                messgae = this.mqConsumer.receive();
                if (messgae != null) {
                    try {
                        if ((type = getDataType(messgae)) != null) {
//                            readTimes = 3;
                            dataParser = DataParser.getParser(type);
//                            do {
                            bufferedReader = this.readable.read(messgae);
//                                if (bufferedReader.ready()) {
                            String data = bufferedReader.readLine();
                            if (type != DataParser.MERGED_XDR) {
                                while (data != null) {
                                    dataCommon = getDataCommon(dataParser, data);
                                    dataPartitioning.put(dataCommon);

                                    data = bufferedReader.readLine();
                                }
                            } else {
                                while (data != null) {
                                    //test
                                    MergedXDR mergedXDR = (MergedXDR) getDataCommon(dataParser, data);
                                    if (mergedXDR != null && mergedXDR.getScenario_id() > 0) {
                                        spoutOutputCollector.emit(new Values(mergedXDR));
                                    }
                                    data = bufferedReader.readLine();
                                }
                            }
                        }
                    } catch (Exception e) {
                        logger.error("Read is failure. Type: {}, exception: {}, message: {}.", type, e.getMessage(), messgae);
                    }
                } else
                    Thread.sleep(THREAD_WRITING);
            }
        } catch (InterruptedException e) {
            logger.error("MQ thread interrupted, cause: {}. Interrupt current thread: {}.", e.getMessage(), this.getId());
            if (!this.isInterrupted()) this.interrupt();
        }
    }

    /**
     * instantiation
     *
     * @param dataParser data parser
     * @param data       data
     * @return a data object
     */
    private DataCommon getDataCommon(DataParser dataParser, String data) throws Exception {
        try {
            return (DataCommon) dataParser.parse(dataParser.split(data));
        } catch (Exception e) {
            logger.debug("Got data object is failure, data: {}.", data);
        }
        return null;
    }

    /**
     * get a type of the data
     *
     * @param message message
     * @return type
     */
    private String getDataType(String message) {
        for (String type : DataParser.INTERFACES
                ) {
            if (message.contains(type)) {
                return type;
            }
        }
        return null;
    }
}
