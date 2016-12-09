package com.eastcom.volte.data.cxtype.cx;

import com.eastcom.volte.data.DataParser;
import com.eastcom.volte.utilities.StringParse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by linghang.kong on 2016/8/16.
 */
public class CxParser extends DataParser<Cx> {

    private static Logger logger = LoggerFactory.getLogger(CxParser.class);

    public Cx parse(List<String> dataList) throws Exception {
        try {
            Cx cx = new Cx();
            cx.setInterface(StringParse.parseInt(dataList.get(2)));
            cx.setXdr_id(dataList.get(3));
            cx.setStart_time(StringParse.parseLong(dataList.get(8)));
            cx.setEnd_time(StringParse.parseLong(dataList.get(9)));
            cx.setDest_ne_ip(dataList.get(14));
            return cx;
        } catch (Exception e) {
            logger.debug("data size: {}, need the most length: 15.", dataList.size());
            throw e;
        }
    }
}
