package com.eastcom.volte.storm.common.utilities;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by linghang.kong on 2016/11/4.
 */
public class IPv6Standardization {

    private static final Logger logger = LoggerFactory.getLogger(IPv6Standardization.class);

    private static final Splitter splitter = Splitter.onPattern(":").trimResults();

    public static String standard(String ipv6) {
        try {
            if (ipv6.length() > 15) {
                StringBuffer buffer = new StringBuffer();
                List<String> paritionArray = splitter.splitToList(ipv6);
                for (String tmp : paritionArray
                        ) {
                    if (tmp.length() < 4) {
                        buffer.append(Strings.padStart(tmp, 4, '0')).append(':');
                    } else {
                        buffer.append(tmp).append(':');
                    }
                }
                return buffer.toString().substring(0, 39);
            }
        } catch (Exception e) {
            logger.error("IPv6 standard false! exception: {}, return ip {}.", e.getMessage(), ipv6);
        }
        return ipv6;
    }
}
