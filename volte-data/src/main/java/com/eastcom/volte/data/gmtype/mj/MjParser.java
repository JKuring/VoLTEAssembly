package com.eastcom.volte.data.gmtype.mj;

import com.eastcom.volte.data.DataParser;
import com.eastcom.volte.utilities.StringParse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by linghang.kong on 2016/8/16.
 */
public class MjParser extends DataParser<Mj> {

    private static Logger logger = LoggerFactory.getLogger(MjParser.class);

    public Mj parse(List<String> dataList) throws Exception {
        try {
            Mj mj = new Mj();
            mj.setInterface(StringParse.parseInt(dataList.get(2)));
            mj.setXdr_id(dataList.get(3));
            mj.setStart_time(StringParse.parseLong(dataList.get(9)));
            mj.setDest_ne_ip(dataList.get(22));
            mj.setAlerting_time(StringParse.parseInt(dataList.get(55)));
            return mj;
        } catch (Exception e) {
            logger.debug("data size: {}, need the most length: 56.", dataList.size());
            throw e;
        }
    }
}
