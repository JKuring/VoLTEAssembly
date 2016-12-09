package com.eastcom.volte.data.gmtype.mi;

import com.eastcom.volte.data.DataParser;
import com.eastcom.volte.utilities.StringParse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by linghang.kong on 2016/8/16.
 */
public class MiParser extends DataParser<Mi> {

    private static Logger logger = LoggerFactory.getLogger(MiParser.class);

    public Mi parse(List<String> dataList) throws Exception {
        try {
            Mi mi = new Mi();
            mi.setInterface(StringParse.parseInt(dataList.get(2)));
            mi.setXdr_id(dataList.get(3));
            mi.setStart_time(StringParse.parseLong(dataList.get(9)));
            mi.setDest_ne_ip(dataList.get(22));
            mi.setAlerting_time(StringParse.parseInt(dataList.get(55)));
            return mi;
        } catch (Exception e) {
            logger.debug("data size: {}, need the most length: 56.", dataList.size());
            throw e;
        }
    }
}
