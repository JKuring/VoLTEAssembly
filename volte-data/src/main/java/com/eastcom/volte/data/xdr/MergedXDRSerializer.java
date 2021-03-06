package com.eastcom.volte.data.xdr;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/**
 * Created by linghang.kong on 2016/8/18.
 */
public class MergedXDRSerializer extends Serializer<MergedXDR> {
    public void write(Kryo kryo, Output output, MergedXDR mergedXDR) {
        output.writeInt(mergedXDR.getLength(), true);
        output.writeString(mergedXDR.getCity());
        output.writeInt(mergedXDR.getInterface(), true);
        output.writeString(mergedXDR.getXdr_id());
        output.writeInt(mergedXDR.getRat(), true);
        output.writeString(mergedXDR.getImsi_caller());
        output.writeString(mergedXDR.getImei_caller());
        output.writeString(mergedXDR.getMsisdn_caller());
        output.writeString(mergedXDR.getCell_caller());
        output.writeString(mergedXDR.getTac_caller());
        output.writeString(mergedXDR.getImsi_callee());
        output.writeString(mergedXDR.getImei_callee());
        output.writeString(mergedXDR.getMsisdn_callee());
        output.writeString(mergedXDR.getCell_callee());
        output.writeString(mergedXDR.getTac_callee());
        output.writeLong(mergedXDR.getStart_time(), true);
        output.writeLong(mergedXDR.getEnd_time(), true);
        output.writeInt(mergedXDR.getXdr_number(), true);
        output.writeString(mergedXDR.getXDR_ID1());
        output.writeString(mergedXDR.getXDR_ID2());
        output.writeString(mergedXDR.getXDR_ID3());
        output.writeString(mergedXDR.getXDR_ID4());
        output.writeString(mergedXDR.getXDR_ID5());
        output.writeString(mergedXDR.getXDR_ID6());
        output.writeString(mergedXDR.getXDR_ID7());
        output.writeString(mergedXDR.getXDR_ID8());
        output.writeString(mergedXDR.getXDR_ID9());
        output.writeString(mergedXDR.getXDR_ID10());
        output.writeString(mergedXDR.getXDR_ID11());
        output.writeString(mergedXDR.getXDR_ID12());
        output.writeString(mergedXDR.getXDR_ID13());
        output.writeString(mergedXDR.getXDR_ID14());
        output.writeString(mergedXDR.getXDR_ID15());
        output.writeString(mergedXDR.getXDR_ID16());
        output.writeString(mergedXDR.getXDR_ID17());
        output.writeString(mergedXDR.getXDR_ID18());
        output.writeString(mergedXDR.getXDR_ID19());
        output.writeString(mergedXDR.getXDR_ID20());
        output.writeString(mergedXDR.getXDR_ID21());
        output.writeString(mergedXDR.getXDR_ID22());
        output.writeString(mergedXDR.getXDR_ID23());
        output.writeString(mergedXDR.getXDR_ID24());
        output.writeString(mergedXDR.getXDR_ID25());
        output.writeString(mergedXDR.getXDR_ID26());
        output.writeString(mergedXDR.getXDR_ID27());
        output.writeString(mergedXDR.getXDR_ID28());
        output.writeString(mergedXDR.getXDR_ID29());
        output.writeString(mergedXDR.getXDR_ID30());
        output.writeString(mergedXDR.getXDR_ID31());
        output.writeString(mergedXDR.getXDR_ID32());
        output.writeString(mergedXDR.getXDR_ID33());
        output.writeString(mergedXDR.getXDR_ID34());
        output.writeString(mergedXDR.getXDR_ID35());
        output.writeString(mergedXDR.getXDR_ID36());
        output.writeString(mergedXDR.getXDR_ID37());
        output.writeString(mergedXDR.getXDR_ID38());
        output.writeString(mergedXDR.getXDR_ID39());
        output.writeString(mergedXDR.getXDR_ID40());
        output.writeString(mergedXDR.getXDR_ID41());
        output.writeString(mergedXDR.getXDR_ID42());
        output.writeString(mergedXDR.getXDR_ID43());
        output.writeString(mergedXDR.getXDR_ID44());
        output.writeString(mergedXDR.getXDR_ID45());
        output.writeString(mergedXDR.getXDR_ID46());
        output.writeString(mergedXDR.getXDR_ID47());
        output.writeString(mergedXDR.getXDR_ID48());
        output.writeString(mergedXDR.getXDR_ID49());
        output.writeString(mergedXDR.getXDR_ID50());
        output.writeString(mergedXDR.getXDR_ID51());
        output.writeString(mergedXDR.getXDR_ID52());
        output.writeString(mergedXDR.getXDR_ID53());
        output.writeString(mergedXDR.getXDR_ID54());
        output.writeString(mergedXDR.getXDR_ID55());
        output.writeString(mergedXDR.getXDR_ID56());
        output.writeString(mergedXDR.getXDR_ID57());
        output.writeString(mergedXDR.getXDR_ID58());
        output.writeInt(mergedXDR.getScenario_id(), true);
        output.writeLong(mergedXDR.getTime_o_rx_aar(), true);
        output.writeLong(mergedXDR.getTime_o_rx_reserved(), true);
        output.writeLong(mergedXDR.getTime_t_rx_aar(), true);
        output.writeLong(mergedXDR.getTime_t_rx_reserved(), true);
        output.writeLong(mergedXDR.getTime_t_sh_udr(), true);
        output.writeLong(mergedXDR.getTime_t_sh_reserved(), true);

    }

    public MergedXDR read(Kryo kryo, Input input, Class<MergedXDR> type) {
        MergedXDR mergedXDR = new MergedXDR();
        mergedXDR.setLength(input.readInt(true));
        mergedXDR.setCity(input.readString());
        mergedXDR.setInterface(input.readInt(true));
        mergedXDR.setXdr_id(input.readString());
        mergedXDR.setRat(input.readInt(true));
        mergedXDR.setImsi_caller(input.readString());
        mergedXDR.setImei_caller(input.readString());
        mergedXDR.setMsisdn_caller(input.readString());
        mergedXDR.setCell_caller(input.readString());
        mergedXDR.setTac_caller(input.readString());
        mergedXDR.setImsi_callee(input.readString());
        mergedXDR.setImei_callee(input.readString());
        mergedXDR.setMsisdn_callee(input.readString());
        mergedXDR.setCell_callee(input.readString());
        mergedXDR.setTac_callee(input.readString());
        mergedXDR.setStart_time(input.readLong(true));
        mergedXDR.setEnd_time(input.readLong(true));
        mergedXDR.setXdr_number(input.readInt(true));
        mergedXDR.setXDR_ID1(input.readString());
        mergedXDR.setXDR_ID2(input.readString());
        mergedXDR.setXDR_ID3(input.readString());
        mergedXDR.setXDR_ID4(input.readString());
        mergedXDR.setXDR_ID5(input.readString());
        mergedXDR.setXDR_ID6(input.readString());
        mergedXDR.setXDR_ID7(input.readString());
        mergedXDR.setXDR_ID8(input.readString());
        mergedXDR.setXDR_ID9(input.readString());
        mergedXDR.setXDR_ID10(input.readString());
        mergedXDR.setXDR_ID11(input.readString());
        mergedXDR.setXDR_ID12(input.readString());
        mergedXDR.setXDR_ID13(input.readString());
        mergedXDR.setXDR_ID14(input.readString());
        mergedXDR.setXDR_ID15(input.readString());
        mergedXDR.setXDR_ID16(input.readString());
        mergedXDR.setXDR_ID17(input.readString());
        mergedXDR.setXDR_ID18(input.readString());
        mergedXDR.setXDR_ID19(input.readString());
        mergedXDR.setXDR_ID20(input.readString());
        mergedXDR.setXDR_ID21(input.readString());
        mergedXDR.setXDR_ID22(input.readString());
        mergedXDR.setXDR_ID23(input.readString());
        mergedXDR.setXDR_ID24(input.readString());
        mergedXDR.setXDR_ID25(input.readString());
        mergedXDR.setXDR_ID26(input.readString());
        mergedXDR.setXDR_ID27(input.readString());
        mergedXDR.setXDR_ID28(input.readString());
        mergedXDR.setXDR_ID29(input.readString());
        mergedXDR.setXDR_ID30(input.readString());
        mergedXDR.setXDR_ID31(input.readString());
        mergedXDR.setXDR_ID32(input.readString());
        mergedXDR.setXDR_ID33(input.readString());
        mergedXDR.setXDR_ID34(input.readString());
        mergedXDR.setXDR_ID35(input.readString());
        mergedXDR.setXDR_ID36(input.readString());
        mergedXDR.setXDR_ID37(input.readString());
        mergedXDR.setXDR_ID38(input.readString());
        mergedXDR.setXDR_ID39(input.readString());
        mergedXDR.setXDR_ID40(input.readString());
        mergedXDR.setXDR_ID41(input.readString());
        mergedXDR.setXDR_ID42(input.readString());
        mergedXDR.setXDR_ID43(input.readString());
        mergedXDR.setXDR_ID44(input.readString());
        mergedXDR.setXDR_ID45(input.readString());
        mergedXDR.setXDR_ID46(input.readString());
        mergedXDR.setXDR_ID47(input.readString());
        mergedXDR.setXDR_ID48(input.readString());
        mergedXDR.setXDR_ID49(input.readString());
        mergedXDR.setXDR_ID50(input.readString());
        mergedXDR.setXDR_ID51(input.readString());
        mergedXDR.setXDR_ID52(input.readString());
        mergedXDR.setXDR_ID53(input.readString());
        mergedXDR.setXDR_ID54(input.readString());
        mergedXDR.setXDR_ID55(input.readString());
        mergedXDR.setXDR_ID56(input.readString());
        mergedXDR.setXDR_ID57(input.readString());
        mergedXDR.setXDR_ID58(input.readString());
        mergedXDR.setScenario_id(input.readInt(true));
        mergedXDR.setTime_o_rx_aar(input.readLong(true));
        mergedXDR.setTime_o_rx_reserved(input.readLong(true));
        mergedXDR.setTime_t_rx_aar(input.readLong(true));
        mergedXDR.setTime_t_rx_reserved(input.readLong(true));
        mergedXDR.setTime_t_sh_udr(input.readLong(true));
        mergedXDR.setTime_t_sh_reserved(input.readLong(true));

        return mergedXDR;
    }
}
