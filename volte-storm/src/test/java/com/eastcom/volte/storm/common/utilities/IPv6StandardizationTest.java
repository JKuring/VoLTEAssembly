package com.eastcom.volte.storm.common.utilities;

import org.junit.Test;

/**
 * Created by linghang.kong on 2016/11/4.
 */
public class IPv6StandardizationTest {
    @Test
    public void standard() throws Exception {

        String a = "2409:8014:8201:10:0:0:0:9";
        System.out.println(IPv6Standardization.standard(a));
    }

}