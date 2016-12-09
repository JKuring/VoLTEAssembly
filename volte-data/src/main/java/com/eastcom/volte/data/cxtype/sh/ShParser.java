package com.eastcom.volte.data.cxtype.sh;

import com.eastcom.volte.data.DataParser;
import com.eastcom.volte.utilities.StringParse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by linghang.kong on 2016/8/16.
 */
public class ShParser extends DataParser<Sh> {

    private static Logger logger = LoggerFactory.getLogger(ShParser.class);

    public Sh parse(List<String> dataList) throws Exception {
        try {
            Sh sh = new Sh();
            sh.setInterface(StringParse.parseInt(dataList.get(2)));
            sh.setXdr_id(dataList.get(3));
            sh.setStart_time(StringParse.parseLong(dataList.get(8)));
            sh.setEnd_time(StringParse.parseLong(dataList.get(9)));
            sh.setDest_ne_ip(dataList.get(14));
            return sh;
        } catch (Exception e) {
            logger.debug("data size: {}, need the most length: 15.", dataList.size());
            throw e;
        }
    }
}
