package com.eastcom.volte.storm.common.utilities.time;

import org.junit.Test;

/**
 * Created by linghang.kong on 2016/9/7.
 */
public class TimeTransformTest {

    private final long DELAY_TIME = 2 * 60;

    @Test
    public void getTimestamp() throws Exception {

        long date = 1474620091010L;
        System.out.println(TimeTransform.getDate(System.currentTimeMillis()));
        System.out.println(TimeTransform.getDate(System.currentTimeMillis() - DELAY_TIME * 60 * 1000));
    }

}