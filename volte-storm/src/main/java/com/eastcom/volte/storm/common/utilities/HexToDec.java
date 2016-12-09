package com.eastcom.volte.storm.common.utilities;

import java.util.HashMap;

/**
 * Created by linghang.kong on 2016/8/24.
 */
public class HexToDec {

    private static HashMap<Character, Integer> hexMap = new HashMap<Character, Integer>() {
        {
            put('0', 0);
            put('1', 1);
            put('2', 2);
            put('3', 3);
            put('4', 4);
            put('5', 5);
            put('6', 6);
            put('7', 7);
            put('8', 8);
            put('9', 9);
            put('a', 10);
            put('b', 11);
            put('c', 12);
            put('d', 13);
            put('e', 14);
            put('f', 15);
        }
    };


    public static int hexToDec(char[] chars) {
        int bit = chars.length - 1;
        int number;
        int sum = 0;
        for (char tmp : chars
                ) {
            number = (int) (hexMap.get(tmp) * Math.pow(16, bit));
            sum += number;
            bit--;
        }
        return sum;
    }
}
