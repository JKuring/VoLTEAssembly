package com.eastcom.volte.data.gmtype.mg;

import com.eastcom.volte.data.DataParser;
import com.eastcom.volte.utilities.StringParse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by linghang.kong on 2016/8/16.
 */
public class MgParser extends DataParser<Mg> {

    private static Logger logger = LoggerFactory.getLogger(MgParser.class);

    public Mg parse(List<String> dataList) throws Exception {
        try {
            Mg mg = new Mg();
            mg.setInterface(StringParse.parseInt(dataList.get(2)));
            mg.setXdr_id(dataList.get(3));
            mg.setStart_time(StringParse.parseLong(dataList.get(9)));
            mg.setDest_ne_ip(dataList.get(22));
            mg.setAlerting_time(StringParse.parseInt(dataList.get(55)));
            return mg;
        } catch (Exception e) {
            logger.debug("data size: {}, need the most length: 56.", dataList.size());
            throw e;
        }
    }
}
