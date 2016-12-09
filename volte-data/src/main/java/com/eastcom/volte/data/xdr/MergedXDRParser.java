package com.eastcom.volte.data.xdr;

import com.eastcom.volte.data.DataParser;
import com.eastcom.volte.utilities.StringParse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by linghang.kong on 2016/8/18.
 */
public class MergedXDRParser extends DataParser<MergedXDR> {
    private static Logger logger = LoggerFactory.getLogger(MergedXDRParser.class);

    public MergedXDR parse(List<String> dataList) throws Exception {
        try {
            MergedXDR mergedXDR = new MergedXDR();
            mergedXDR.setLength(StringParse.parseInt(dataList.get(0)));
            mergedXDR.setCity(dataList.get(1));
            mergedXDR.setInterface(StringParse.parseInt(dataList.get(2)));
            mergedXDR.setXdr_id(dataList.get(3));
            mergedXDR.setRat(StringParse.parseInt(dataList.get(4)));
            mergedXDR.setImsi_caller(dataList.get(5));
            mergedXDR.setImei_caller(dataList.get(6));
            mergedXDR.setMsisdn_caller(dataList.get(7));
            mergedXDR.setCell_caller(dataList.get(8));
            mergedXDR.setTac_caller(dataList.get(9));
            mergedXDR.setImsi_callee(dataList.get(10));
            mergedXDR.setImei_callee(dataList.get(11));
            mergedXDR.setMsisdn_callee(dataList.get(12));
            mergedXDR.setCell_callee(dataList.get(13));
            mergedXDR.setTac_callee(dataList.get(14));
            mergedXDR.setStart_time(StringParse.parseLong(dataList.get(15)));
            mergedXDR.setEnd_time(StringParse.parseLong(dataList.get(16)));
            mergedXDR.setXdr_number(StringParse.parseInt(dataList.get(17)));
            mergedXDR.setXDR_ID1(dataList.get(18));
            mergedXDR.setXDR_ID2(dataList.get(19));
            mergedXDR.setXDR_ID3(dataList.get(20));
            mergedXDR.setXDR_ID4(dataList.get(21));
            mergedXDR.setXDR_ID5(dataList.get(22));
            mergedXDR.setXDR_ID6(dataList.get(23));
            mergedXDR.setXDR_ID7(dataList.get(24));
            mergedXDR.setXDR_ID8(dataList.get(25));
            mergedXDR.setXDR_ID9(dataList.get(26));
            mergedXDR.setXDR_ID10(dataList.get(27));
            mergedXDR.setXDR_ID11(dataList.get(28));
            mergedXDR.setXDR_ID12(dataList.get(29));
            mergedXDR.setXDR_ID13(dataList.get(30));
            mergedXDR.setXDR_ID14(dataList.get(31));
            mergedXDR.setXDR_ID15(dataList.get(32));
            mergedXDR.setXDR_ID16(dataList.get(33));
            mergedXDR.setXDR_ID17(dataList.get(34));
            mergedXDR.setXDR_ID18(dataList.get(35));
            mergedXDR.setXDR_ID19(dataList.get(36));
            mergedXDR.setXDR_ID20(dataList.get(37));
            mergedXDR.setXDR_ID21(dataList.get(38));
            mergedXDR.setXDR_ID22(dataList.get(39));
            mergedXDR.setXDR_ID23(dataList.get(40));
            mergedXDR.setXDR_ID24(dataList.get(41));
            mergedXDR.setXDR_ID25(dataList.get(42));
            mergedXDR.setXDR_ID26(dataList.get(43));
            mergedXDR.setXDR_ID27(dataList.get(44));
            mergedXDR.setXDR_ID28(dataList.get(45));
            mergedXDR.setXDR_ID29(dataList.get(46));
            mergedXDR.setXDR_ID30(dataList.get(47));
            mergedXDR.setXDR_ID31(dataList.get(48));
            mergedXDR.setXDR_ID32(dataList.get(49));
            mergedXDR.setXDR_ID33(dataList.get(50));
            mergedXDR.setXDR_ID34(dataList.get(51));
            mergedXDR.setXDR_ID35(dataList.get(52));
            mergedXDR.setXDR_ID36(dataList.get(53));
            mergedXDR.setXDR_ID37(dataList.get(54));
            mergedXDR.setXDR_ID38(dataList.get(55));
            mergedXDR.setXDR_ID39(dataList.get(56));
            mergedXDR.setXDR_ID40(dataList.get(57));
            mergedXDR.setXDR_ID41(dataList.get(58));
            mergedXDR.setXDR_ID42(dataList.get(59));
            mergedXDR.setXDR_ID43(dataList.get(60));
            mergedXDR.setXDR_ID44(dataList.get(61));
            mergedXDR.setXDR_ID45(dataList.get(62));
            mergedXDR.setXDR_ID46(dataList.get(63));
            mergedXDR.setXDR_ID47(dataList.get(64));
            mergedXDR.setXDR_ID48(dataList.get(65));
            mergedXDR.setXDR_ID49(dataList.get(66));
            mergedXDR.setXDR_ID50(dataList.get(67));
            mergedXDR.setXDR_ID51(dataList.get(68));
            mergedXDR.setXDR_ID52(dataList.get(69));
            mergedXDR.setXDR_ID53(dataList.get(70));
            mergedXDR.setXDR_ID54(dataList.get(71));
            mergedXDR.setXDR_ID55(dataList.get(72));
            mergedXDR.setXDR_ID56(dataList.get(73));
            mergedXDR.setXDR_ID57(dataList.get(74));
            mergedXDR.setXDR_ID58(dataList.get(75));
            mergedXDR.setScenario_id(StringParse.parseInt(dataList.get(76)));
            mergedXDR.setTime_o_rx_aar(StringParse.parseLong(dataList.get(77)));
            mergedXDR.setTime_o_rx_reserved(StringParse.parseLong(dataList.get(78)));
            mergedXDR.setTime_t_rx_aar(StringParse.parseLong(dataList.get(79)));
            mergedXDR.setTime_t_rx_reserved(StringParse.parseLong(dataList.get(80)));
            mergedXDR.setTime_t_sh_udr(StringParse.parseLong(dataList.get(81)));
            mergedXDR.setTime_t_sh_reserved(StringParse.parseLong(dataList.get(82)));

            return mergedXDR;
        } catch (Exception e) {
            logger.debug("data size: {}, need the most length: 83.", dataList.size());
            throw e;
        }
    }
}
