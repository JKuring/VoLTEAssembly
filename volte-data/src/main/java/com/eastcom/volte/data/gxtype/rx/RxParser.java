package com.eastcom.volte.data.gxtype.rx;

import com.eastcom.volte.data.DataParser;
import com.eastcom.volte.utilities.StringParse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by linghang.kong on 2016/11/11.
 */
public class RxParser extends DataParser<Rx> {

    private static Logger logger = LoggerFactory.getLogger(RxParser.class);

    @Override
    public Rx parse(List<String> dataList) throws Exception {
        try {
            Rx rx = new Rx();
            rx.setInterface(StringParse.parseInt(dataList.get(2)));
            rx.setXdr_id(dataList.get(3));
            rx.setDest_ne_ip(dataList.get(15));
            return rx;
        } catch (Exception e) {
            logger.debug("data size: {}, need the most length: 15.", dataList.size());
            throw e;
        }
    }
}
