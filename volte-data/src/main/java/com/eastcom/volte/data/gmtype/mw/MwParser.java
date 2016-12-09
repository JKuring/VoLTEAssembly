package com.eastcom.volte.data.gmtype.mw;

import com.eastcom.volte.data.DataParser;
import com.eastcom.volte.utilities.StringParse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by linghang.kong on 2016/8/16.
 */
public class MwParser extends DataParser<Mw> {

    private static Logger logger = LoggerFactory.getLogger(MwParser.class);

    public Mw parse(List<String> dataList) throws Exception {
        try {
            Mw mw = new Mw();
            mw.setInterface(StringParse.parseInt(dataList.get(2)));
            mw.setXdr_id(dataList.get(3));
            mw.setStart_time(StringParse.parseLong(dataList.get(9)));
            mw.setDest_ne_ip(dataList.get(22));
            mw.setAlerting_time(StringParse.parseInt(dataList.get(55)));
            return mw;
        } catch (Exception e) {
            logger.debug("data size: {}, need the most length: 56.", dataList.size());
            throw e;
        }
    }
}
