package com.eastcom.volte.data.gmtype.isc;

import com.eastcom.volte.data.DataParser;
import com.eastcom.volte.utilities.StringParse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by linghang.kong on 2016/8/16.
 */
public class ISCParser extends DataParser<ISC> {

    private static Logger logger = LoggerFactory.getLogger(ISCParser.class);

    public ISC parse(List<String> dataList) throws Exception {
        try {
            ISC ISC = new ISC();
            ISC.setInterface(StringParse.parseInt(dataList.get(2)));
            ISC.setXdr_id(dataList.get(3));
            ISC.setStart_time(StringParse.parseLong(dataList.get(9)));
            ISC.setDest_ne_ip(dataList.get(22));
            ISC.setAlerting_time(StringParse.parseInt(dataList.get(55)));
            return ISC;
        } catch (Exception e) {
            logger.debug("data size: {}, need the most length: 56.", dataList.size());
            throw e;
        }
    }
}
