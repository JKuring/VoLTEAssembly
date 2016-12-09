package com.eastcom.volte.utilities;


/**
 * Created by konglinghang on 9/18/16.
 */
public class StringParse {


    public static int parseInt(String s) {
        return parseInt(s, 10);
    }

    public static int parseInt(String s, int radix) {
        if (s == null || s.length() == 0) return 0;
        return Integer.parseInt(s, radix);
    }

    public static long parseLong(String s) {
        return parseLong(s, 10);
    }

    public static long parseLong(String s, int radix) {
        if (s == null || s.length() == 0) return 0;
        return Long.parseLong(s, radix);
    }
}
