package com.eastcom.volte.data.xdr;

import com.eastcom.volte.data.DataCommon;

/**
 * Created by linghang.kong on 2016/8/18.
 */
public class MergedXDR implements DataCommon {

    private int length;

    private String city;

    private int Interface;

    private String xdr_id;

    private int rat;

    private String imsi_caller;

    private String imei_caller;

    private String msisdn_caller;

    private String cell_caller;

    private String tac_caller;

    private String imsi_callee;

    private String imei_callee;

    private String msisdn_callee;

    private String cell_callee;

    private String tac_callee;

    private long start_time;

    private long end_time;

    private int xdr_number;

    private String XDR_ID1;

    private String XDR_ID2;

    private String XDR_ID3;

    private String XDR_ID4;

    private String XDR_ID5;

    private String XDR_ID6;

    private String XDR_ID7;

    private String XDR_ID8;

    private String XDR_ID9;

    private String XDR_ID10;

    private String XDR_ID11;

    private String XDR_ID12;

    private String XDR_ID13;

    private String XDR_ID14;

    private String XDR_ID15;

    private String XDR_ID16;

    private String XDR_ID17;

    private String XDR_ID18;

    private String XDR_ID19;

    private String XDR_ID20;

    private String XDR_ID21;

    private String XDR_ID22;

    private String XDR_ID23;

    private String XDR_ID24;

    private String XDR_ID25;

    private String XDR_ID26;

    private String XDR_ID27;

    private String XDR_ID28;

    private String XDR_ID29;

    private String XDR_ID30;

    private String XDR_ID31;

    private String XDR_ID32;

    private String XDR_ID33;

    private String XDR_ID34;

    private String XDR_ID35;

    private String XDR_ID36;

    private String XDR_ID37;

    private String XDR_ID38;

    private String XDR_ID39;

    private String XDR_ID40;

    private String XDR_ID41;

    private String XDR_ID42;

    private String XDR_ID43;

    private String XDR_ID44;

    private String XDR_ID45;

    private String XDR_ID46;

    private String XDR_ID47;

    private String XDR_ID48;

    private String XDR_ID49;

    private String XDR_ID50;

    private String XDR_ID51;

    private String XDR_ID52;

    private String XDR_ID53;

    private String XDR_ID54;

    private String XDR_ID55;

    private String XDR_ID56;

    private String XDR_ID57;

    private String XDR_ID58;

    private int scenario_id;

    private long time_o_rx_aar;

    private long time_o_rx_reserved;

    private long time_t_rx_aar;

    private long time_t_rx_reserved;

    private long time_t_sh_udr;

    private long time_t_sh_reserved;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getInterface() {
        return Interface;
    }

    public void setInterface(int anInterface) {
        Interface = anInterface;
    }

    public String getXdr_id() {
        return xdr_id;
    }

    public void setXdr_id(String xdr_id) {
        this.xdr_id = xdr_id;
    }

    public int getRat() {
        return rat;
    }

    public void setRat(int rat) {
        this.rat = rat;
    }

    public String getImsi_caller() {
        return imsi_caller;
    }

    public void setImsi_caller(String imsi_caller) {
        this.imsi_caller = imsi_caller;
    }

    public String getImei_caller() {
        return imei_caller;
    }

    public void setImei_caller(String imei_caller) {
        this.imei_caller = imei_caller;
    }

    public String getMsisdn_caller() {
        return msisdn_caller;
    }

    public void setMsisdn_caller(String msisdn_caller) {
        this.msisdn_caller = msisdn_caller;
    }

    public String getCell_caller() {
        return cell_caller;
    }

    public void setCell_caller(String cell_caller) {
        this.cell_caller = cell_caller;
    }

    public String getTac_caller() {
        return tac_caller;
    }

    public void setTac_caller(String tac_caller) {
        this.tac_caller = tac_caller;
    }

    public String getImsi_callee() {
        return imsi_callee;
    }

    public void setImsi_callee(String imsi_callee) {
        this.imsi_callee = imsi_callee;
    }

    public String getImei_callee() {
        return imei_callee;
    }

    public void setImei_callee(String imei_callee) {
        this.imei_callee = imei_callee;
    }

    public String getMsisdn_callee() {
        return msisdn_callee;
    }

    public void setMsisdn_callee(String msisdn_callee) {
        this.msisdn_callee = msisdn_callee;
    }

    public String getCell_callee() {
        return cell_callee;
    }

    public void setCell_callee(String cell_callee) {
        this.cell_callee = cell_callee;
    }

    public String getTac_callee() {
        return tac_callee;
    }

    public void setTac_callee(String tac_callee) {
        this.tac_callee = tac_callee;
    }

    public long getStart_time() {
        return start_time;
    }

    public void setStart_time(long start_time) {
        this.start_time = start_time;
    }

    @Override
    public String getDest_ne_ip() {
        return null;
    }

    public long getEnd_time() {
        return end_time;
    }

    public void setEnd_time(long end_time) {
        this.end_time = end_time;
    }

    public int getXdr_number() {
        return xdr_number;
    }

    public void setXdr_number(int xdr_number) {
        this.xdr_number = xdr_number;
    }

    public String getXDR_ID1() {
        return XDR_ID1;
    }

    public void setXDR_ID1(String XDR_ID1) {
        this.XDR_ID1 = XDR_ID1;
    }

    public String getXDR_ID2() {
        return XDR_ID2;
    }

    public void setXDR_ID2(String XDR_ID2) {
        this.XDR_ID2 = XDR_ID2;
    }

    public String getXDR_ID3() {
        return XDR_ID3;
    }

    public void setXDR_ID3(String XDR_ID3) {
        this.XDR_ID3 = XDR_ID3;
    }

    public String getXDR_ID4() {
        return XDR_ID4;
    }

    public void setXDR_ID4(String XDR_ID4) {
        this.XDR_ID4 = XDR_ID4;
    }

    public String getXDR_ID5() {
        return XDR_ID5;
    }

    public void setXDR_ID5(String XDR_ID5) {
        this.XDR_ID5 = XDR_ID5;
    }

    public String getXDR_ID6() {
        return XDR_ID6;
    }

    public void setXDR_ID6(String XDR_ID6) {
        this.XDR_ID6 = XDR_ID6;
    }

    public String getXDR_ID7() {
        return XDR_ID7;
    }

    public void setXDR_ID7(String XDR_ID7) {
        this.XDR_ID7 = XDR_ID7;
    }

    public String getXDR_ID8() {
        return XDR_ID8;
    }

    public void setXDR_ID8(String XDR_ID8) {
        this.XDR_ID8 = XDR_ID8;
    }

    public String getXDR_ID9() {
        return XDR_ID9;
    }

    public void setXDR_ID9(String XDR_ID9) {
        this.XDR_ID9 = XDR_ID9;
    }

    public String getXDR_ID10() {
        return XDR_ID10;
    }

    public void setXDR_ID10(String XDR_ID10) {
        this.XDR_ID10 = XDR_ID10;
    }

    public String getXDR_ID11() {
        return XDR_ID11;
    }

    public void setXDR_ID11(String XDR_ID11) {
        this.XDR_ID11 = XDR_ID11;
    }

    public String getXDR_ID12() {
        return XDR_ID12;
    }

    public void setXDR_ID12(String XDR_ID12) {
        this.XDR_ID12 = XDR_ID12;
    }

    public String getXDR_ID13() {
        return XDR_ID13;
    }

    public void setXDR_ID13(String XDR_ID13) {
        this.XDR_ID13 = XDR_ID13;
    }

    public String getXDR_ID14() {
        return XDR_ID14;
    }

    public void setXDR_ID14(String XDR_ID14) {
        this.XDR_ID14 = XDR_ID14;
    }

    public String getXDR_ID15() {
        return XDR_ID15;
    }

    public void setXDR_ID15(String XDR_ID15) {
        this.XDR_ID15 = XDR_ID15;
    }

    public String getXDR_ID16() {
        return XDR_ID16;
    }

    public void setXDR_ID16(String XDR_ID16) {
        this.XDR_ID16 = XDR_ID16;
    }

    public String getXDR_ID17() {
        return XDR_ID17;
    }

    public void setXDR_ID17(String XDR_ID17) {
        this.XDR_ID17 = XDR_ID17;
    }

    public String getXDR_ID18() {
        return XDR_ID18;
    }

    public void setXDR_ID18(String XDR_ID18) {
        this.XDR_ID18 = XDR_ID18;
    }

    public String getXDR_ID19() {
        return XDR_ID19;
    }

    public void setXDR_ID19(String XDR_ID19) {
        this.XDR_ID19 = XDR_ID19;
    }

    public String getXDR_ID20() {
        return XDR_ID20;
    }

    public void setXDR_ID20(String XDR_ID20) {
        this.XDR_ID20 = XDR_ID20;
    }

    public String getXDR_ID21() {
        return XDR_ID21;
    }

    public void setXDR_ID21(String XDR_ID21) {
        this.XDR_ID21 = XDR_ID21;
    }

    public String getXDR_ID22() {
        return XDR_ID22;
    }

    public void setXDR_ID22(String XDR_ID22) {
        this.XDR_ID22 = XDR_ID22;
    }

    public String getXDR_ID23() {
        return XDR_ID23;
    }

    public void setXDR_ID23(String XDR_ID23) {
        this.XDR_ID23 = XDR_ID23;
    }

    public String getXDR_ID24() {
        return XDR_ID24;
    }

    public void setXDR_ID24(String XDR_ID24) {
        this.XDR_ID24 = XDR_ID24;
    }

    public String getXDR_ID25() {
        return XDR_ID25;
    }

    public void setXDR_ID25(String XDR_ID25) {
        this.XDR_ID25 = XDR_ID25;
    }

    public String getXDR_ID26() {
        return XDR_ID26;
    }

    public void setXDR_ID26(String XDR_ID26) {
        this.XDR_ID26 = XDR_ID26;
    }

    public String getXDR_ID27() {
        return XDR_ID27;
    }

    public void setXDR_ID27(String XDR_ID27) {
        this.XDR_ID27 = XDR_ID27;
    }

    public String getXDR_ID28() {
        return XDR_ID28;
    }

    public void setXDR_ID28(String XDR_ID28) {
        this.XDR_ID28 = XDR_ID28;
    }

    public String getXDR_ID29() {
        return XDR_ID29;
    }

    public void setXDR_ID29(String XDR_ID29) {
        this.XDR_ID29 = XDR_ID29;
    }

    public String getXDR_ID30() {
        return XDR_ID30;
    }

    public void setXDR_ID30(String XDR_ID30) {
        this.XDR_ID30 = XDR_ID30;
    }

    public String getXDR_ID31() {
        return XDR_ID31;
    }

    public void setXDR_ID31(String XDR_ID31) {
        this.XDR_ID31 = XDR_ID31;
    }

    public String getXDR_ID32() {
        return XDR_ID32;
    }

    public void setXDR_ID32(String XDR_ID32) {
        this.XDR_ID32 = XDR_ID32;
    }

    public String getXDR_ID33() {
        return XDR_ID33;
    }

    public void setXDR_ID33(String XDR_ID33) {
        this.XDR_ID33 = XDR_ID33;
    }

    public String getXDR_ID34() {
        return XDR_ID34;
    }

    public void setXDR_ID34(String XDR_ID34) {
        this.XDR_ID34 = XDR_ID34;
    }

    public String getXDR_ID35() {
        return XDR_ID35;
    }

    public void setXDR_ID35(String XDR_ID35) {
        this.XDR_ID35 = XDR_ID35;
    }

    public String getXDR_ID36() {
        return XDR_ID36;
    }

    public void setXDR_ID36(String XDR_ID36) {
        this.XDR_ID36 = XDR_ID36;
    }

    public String getXDR_ID37() {
        return XDR_ID37;
    }

    public void setXDR_ID37(String XDR_ID37) {
        this.XDR_ID37 = XDR_ID37;
    }

    public String getXDR_ID38() {
        return XDR_ID38;
    }

    public void setXDR_ID38(String XDR_ID38) {
        this.XDR_ID38 = XDR_ID38;
    }

    public String getXDR_ID39() {
        return XDR_ID39;
    }

    public void setXDR_ID39(String XDR_ID39) {
        this.XDR_ID39 = XDR_ID39;
    }

    public String getXDR_ID40() {
        return XDR_ID40;
    }

    public void setXDR_ID40(String XDR_ID40) {
        this.XDR_ID40 = XDR_ID40;
    }

    public String getXDR_ID41() {
        return XDR_ID41;
    }

    public void setXDR_ID41(String XDR_ID41) {
        this.XDR_ID41 = XDR_ID41;
    }

    public String getXDR_ID42() {
        return XDR_ID42;
    }

    public void setXDR_ID42(String XDR_ID42) {
        this.XDR_ID42 = XDR_ID42;
    }

    public String getXDR_ID43() {
        return XDR_ID43;
    }

    public void setXDR_ID43(String XDR_ID43) {
        this.XDR_ID43 = XDR_ID43;
    }

    public String getXDR_ID44() {
        return XDR_ID44;
    }

    public void setXDR_ID44(String XDR_ID44) {
        this.XDR_ID44 = XDR_ID44;
    }

    public String getXDR_ID45() {
        return XDR_ID45;
    }

    public void setXDR_ID45(String XDR_ID45) {
        this.XDR_ID45 = XDR_ID45;
    }

    public String getXDR_ID46() {
        return XDR_ID46;
    }

    public void setXDR_ID46(String XDR_ID46) {
        this.XDR_ID46 = XDR_ID46;
    }

    public String getXDR_ID47() {
        return XDR_ID47;
    }

    public void setXDR_ID47(String XDR_ID47) {
        this.XDR_ID47 = XDR_ID47;
    }

    public String getXDR_ID48() {
        return XDR_ID48;
    }

    public void setXDR_ID48(String XDR_ID48) {
        this.XDR_ID48 = XDR_ID48;
    }

    public String getXDR_ID49() {
        return XDR_ID49;
    }

    public void setXDR_ID49(String XDR_ID49) {
        this.XDR_ID49 = XDR_ID49;
    }

    public String getXDR_ID50() {
        return XDR_ID50;
    }

    public void setXDR_ID50(String XDR_ID50) {
        this.XDR_ID50 = XDR_ID50;
    }

    public String getXDR_ID51() {
        return XDR_ID51;
    }

    public void setXDR_ID51(String XDR_ID51) {
        this.XDR_ID51 = XDR_ID51;
    }

    public String getXDR_ID52() {
        return XDR_ID52;
    }

    public void setXDR_ID52(String XDR_ID52) {
        this.XDR_ID52 = XDR_ID52;
    }

    public String getXDR_ID53() {
        return XDR_ID53;
    }

    public void setXDR_ID53(String XDR_ID53) {
        this.XDR_ID53 = XDR_ID53;
    }

    public String getXDR_ID54() {
        return XDR_ID54;
    }

    public void setXDR_ID54(String XDR_ID54) {
        this.XDR_ID54 = XDR_ID54;
    }

    public String getXDR_ID55() {
        return XDR_ID55;
    }

    public void setXDR_ID55(String XDR_ID55) {
        this.XDR_ID55 = XDR_ID55;
    }

    public String getXDR_ID56() {
        return XDR_ID56;
    }

    public void setXDR_ID56(String XDR_ID56) {
        this.XDR_ID56 = XDR_ID56;
    }

    public String getXDR_ID57() {
        return XDR_ID57;
    }

    public void setXDR_ID57(String XDR_ID57) {
        this.XDR_ID57 = XDR_ID57;
    }

    public String getXDR_ID58() {
        return XDR_ID58;
    }

    public void setXDR_ID58(String XDR_ID58) {
        this.XDR_ID58 = XDR_ID58;
    }

    public int getScenario_id() {
        return scenario_id;
    }

    public void setScenario_id(int scenario_id) {
        this.scenario_id = scenario_id;
    }

    public long getTime_o_rx_aar() {
        return time_o_rx_aar;
    }

    public void setTime_o_rx_aar(long time_o_rx_aar) {
        this.time_o_rx_aar = time_o_rx_aar;
    }

    public long getTime_o_rx_reserved() {
        return time_o_rx_reserved;
    }

    public void setTime_o_rx_reserved(long time_o_rx_reserved) {
        this.time_o_rx_reserved = time_o_rx_reserved;
    }

    public long getTime_t_rx_aar() {
        return time_t_rx_aar;
    }

    public void setTime_t_rx_aar(long time_t_rx_aar) {
        this.time_t_rx_aar = time_t_rx_aar;
    }

    public long getTime_t_rx_reserved() {
        return time_t_rx_reserved;
    }

    public void setTime_t_rx_reserved(long time_t_rx_reserved) {
        this.time_t_rx_reserved = time_t_rx_reserved;
    }

    public long getTime_t_sh_udr() {
        return time_t_sh_udr;
    }

    public void setTime_t_sh_udr(long time_t_sh_udr) {
        this.time_t_sh_udr = time_t_sh_udr;
    }

    public long getTime_t_sh_reserved() {
        return time_t_sh_reserved;
    }

    public void setTime_t_sh_reserved(long time_t_sh_reserved) {
        this.time_t_sh_reserved = time_t_sh_reserved;
    }


}
