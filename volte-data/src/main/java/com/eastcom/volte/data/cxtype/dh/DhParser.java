package com.eastcom.volte.data.cxtype.dh;

import com.eastcom.volte.data.DataParser;
import com.eastcom.volte.utilities.StringParse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by linghang.kong on 2016/8/16.
 */
public class DhParser extends DataParser<Dh> {

    private static Logger logger = LoggerFactory.getLogger(DhParser.class);

    public Dh parse(List<String> dataList) throws Exception {
        try {
            Dh dh = new Dh();
            dh.setInterface(StringParse.parseInt(dataList.get(2)));
            dh.setXdr_id(dataList.get(3));
            dh.setStart_time(StringParse.parseLong(dataList.get(8)));
            dh.setEnd_time(StringParse.parseLong(dataList.get(9)));
            dh.setDest_ne_ip(dataList.get(14));
            return dh;
        } catch (Exception e) {
            logger.debug("data size: {}, need the most length: 15.", dataList.size());
            throw e;
        }
    }
}
