package com.eastcom.volte.storm.storm.arithmetic;

import com.eastcom.volte.data.DataCommon;
import com.eastcom.volte.data.volte.VoLTE;
import com.eastcom.volte.data.xdr.MergedXDR;
import com.eastcom.volte.data.xdr.MergedXDRParser;
import com.eastcom.volte.data.xdr.MergedXDRSerializer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by linghang.kong on 2016/10/18.
 */
public class MergerTest {
    @Test
    public void doMerge() throws Exception {

        String xdr = "337|6308|13|14760065281343670|6|460007544183655|358366061639660|8613917570489|7356301|6308|||8618116320589|||1476065346590|1476065383943||2334317426642413097||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||";
        MergedXDRParser mergedXDRParser = new MergedXDRParser();
        MergedXDR mergedXDR = mergedXDRParser.parse(mergedXDRParser.split(xdr));

        MergedXDRSerializer mergedXDRSerializer = new MergedXDRSerializer();

        Merger merger = new Merger();
        merger.create(mergedXDR, new ArrayList<DataCommon>(), new HashMap<String, String>());
        VoLTE voLTE = merger.doMerge();
        System.out.println(voLTE.getImsi_caller());
    }

}