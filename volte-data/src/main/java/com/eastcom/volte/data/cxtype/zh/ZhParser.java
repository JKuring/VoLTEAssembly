package com.eastcom.volte.data.cxtype.zh;

import com.eastcom.volte.data.DataParser;
import com.eastcom.volte.utilities.StringParse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by linghang.kong on 2016/8/16.
 */
public class ZhParser extends DataParser<Zh> {

    private static Logger logger = LoggerFactory.getLogger(ZhParser.class);

    public Zh parse(List<String> dataList) throws Exception {
        try {
            Zh zh = new Zh();
            zh.setInterface(StringParse.parseInt(dataList.get(2)));
            zh.setXdr_id(dataList.get(3));
            zh.setStart_time(StringParse.parseLong(dataList.get(8)));
            zh.setEnd_time(StringParse.parseLong(dataList.get(9)));
            zh.setDest_ne_ip(dataList.get(14));
            return zh;
        } catch (Exception e) {
            logger.debug("data size: {}, need the most length: 15.", dataList.size());
            throw e;
        }
    }
}
