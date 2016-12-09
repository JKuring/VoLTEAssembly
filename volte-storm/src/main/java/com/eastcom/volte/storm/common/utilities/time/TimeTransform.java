package com.eastcom.volte.storm.common.utilities.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by linghang.kong on 2016/8/25.
 */
public class TimeTransform {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm");


    public static String getDate(long timestamp) {

        String date = simpleDateFormat.format(new Date(timestamp));

        return date;
    }

    public static long getTimestamp(String date) throws ParseException {

        long timestamp = simpleDateFormat.parse(date).getTime();

        return timestamp;
    }
}
