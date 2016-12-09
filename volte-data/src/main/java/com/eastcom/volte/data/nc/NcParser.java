package com.eastcom.volte.data.nc;

import com.eastcom.volte.data.DataParser;
import com.eastcom.volte.data.utilities.TimeTransform;
import com.eastcom.volte.utilities.StringParse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by linghang.kong on 2016/8/30.
 */
public class NcParser extends DataParser<Nc> {

    private static Logger logger = LoggerFactory.getLogger(NcParser.class);

    @Override
    public Nc parse(List<String> dataList) throws Exception {
        try {
            Nc nc = new Nc();
            nc.setStart_time(TimeTransform.getTimestamp(dataList.get(0)));
            nc.setAcmoffset(StringParse.parseLong(dataList.get(27)));
            nc.setXdr_id(dataList.get(43));
            return nc;
        } catch (Exception e) {
            logger.debug("data size: {}, need the most length: 44.", dataList.size());
            throw e;
        }
    }
}
