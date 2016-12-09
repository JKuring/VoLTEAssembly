package com.eastcom.volte.data.gmtype.isc;

import org.junit.Test;

/**
 * Created by konglinghang on 9/18/16.
 */
public class ISCParserTest {
    @Test
    public void parse() throws Exception {
        ISC isc = null;
        String data = "337|21|18|610509098092916301|6|460001609183360|354378067096890|8613901602058|3|1473217536346|1473217536356||0|||||10.184.5.9|aqrrqr2r3p1a35r6b00rbra8as53287p@S.5.114.sh.chinamobile.com||10.184.5.9||10.184.5.82|||2|25577739|6299|460001609183360|354378067096890|||||||3600000|3600000||||||||||||200|||||||||||43753828|||||";
        ISCParser iscParser = new ISCParser();
        isc = iscParser.parse(iscParser.split(data));
//
//        String a  = "123";
//        int b = StringParse.parseInt(a);
//        System.out.println(b);
    }

}