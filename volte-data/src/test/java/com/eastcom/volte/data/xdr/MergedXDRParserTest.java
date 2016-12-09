package com.eastcom.volte.data.xdr;

import org.junit.Test;

/**
 * Created by linghang.kong on 2016/10/18.
 */
public class MergedXDRParserTest {
    @Test
    public void parse() throws Exception {

        String xdr = "337|6308|13|14760065281343670|6|460007544183655|358366061639660|8613917570489|7356301|6308|||8618116320589|||1476065346590|1476065383943||2334317426642413097||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||";
        MergedXDRParser mergedXDRParser = new MergedXDRParser();
        MergedXDR mergedXDR = mergedXDRParser.parse(mergedXDRParser.split(xdr));
        System.out.println(mergedXDR.getImsi_caller());
    }

}