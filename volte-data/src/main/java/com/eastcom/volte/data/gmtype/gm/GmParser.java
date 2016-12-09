package com.eastcom.volte.data.gmtype.gm;

import com.eastcom.volte.data.DataParser;
import com.eastcom.volte.utilities.StringParse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by linghang.kong on 2016/8/16.
 */
public class GmParser extends DataParser<Gm> {

    private static Logger logger = LoggerFactory.getLogger(GmParser.class);

    public Gm parse(List<String> dataList) throws Exception {
        try {
            Gm gm = new Gm();
            gm.setInterface(StringParse.parseInt(dataList.get(2)));
            gm.setXdr_id(dataList.get(3));
            gm.setStart_time(StringParse.parseLong(dataList.get(9)));
            gm.setDest_ne_ip(dataList.get(22));
            gm.setAlerting_time(StringParse.parseInt(dataList.get(55)));
            return gm;
        } catch (Exception e) {
            logger.debug("data size: {}, need the most length: 56.", dataList.size());

            throw e;
        }
    }
}
