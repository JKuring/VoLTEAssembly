package com.eastcom.volte.data.cxtype.dx;

import com.eastcom.volte.data.DataParser;
import com.eastcom.volte.utilities.StringParse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by linghang.kong on 2016/8/16.
 */
public class DxParser extends DataParser<Dx> {

    private static Logger logger = LoggerFactory.getLogger(DxParser.class);

    public Dx parse(List<String> dataList) throws Exception {
        try {
            Dx dx = new Dx();
            dx.setInterface(StringParse.parseInt(dataList.get(2)));
            dx.setXdr_id(dataList.get(3));
            dx.setStart_time(StringParse.parseLong(dataList.get(8)));
            dx.setEnd_time(StringParse.parseLong(dataList.get(9)));
            dx.setDest_ne_ip(dataList.get(14));
            return dx;
        } catch (Exception e) {
            logger.debug("data size: {}, need the most length: 15.", dataList.size());
            throw e;
        }
    }
}
