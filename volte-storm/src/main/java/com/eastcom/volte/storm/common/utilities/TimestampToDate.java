package com.eastcom.volte.storm.common.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by linghang.kong on 2016/8/25.
 */
public class TimestampToDate {

    public static String getData(long timestamp) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        String date = simpleDateFormat.format(new Date(timestamp));

        return date;
    }
}
