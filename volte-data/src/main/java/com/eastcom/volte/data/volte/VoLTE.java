package com.eastcom.volte.data.volte;

import com.eastcom.volte.data.DataCommon;

/**
 * Created by linghang.kong on 2016/8/29.
 */
public class VoLTE implements DataCommon {

    private int length;

    private String city;

    private int Interface;

    private String xdr_id;

    private int rat;

    private long start_time;

    private long end_time;

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

    private int xdr_number;

    private int Time_O_Gm;
    private int Time_O_Mw_P2S;
    private int Time_O_ISC11;
    private int Time_O_ISC12;
    private int Time_O_ISC21;
    private int Time_O_ISC22;
    private int Time_O_ISC31;
    private int Time_O_ISC32;
    private int Time_O_ISC51;
    private int Time_O_ISC52;
    private int Time_O_ISC41;
    private int Time_O_ISC42;
    private int Time_O_ISC61;
    private int Time_O_ISC62;
    private int Time_O_ISC91;
    private int Time_O_ISC92;
    private int Time_O_ISC121;
    private int Time_O_ISC122;
    private int Time_OS2TI_Mw;
    private int Time_TI2TS_Mw;
    private int Time_T_ISC31;
    private int Time_T_ISC32;
    private int Time_T_ISC51;
    private int Time_T_ISC52;
    private int Time_T_ISC41;
    private int Time_T_ISC42;
    private int Time_T_ISC61;
    private int Time_T_ISC62;
    private int Time_T_ISC21;
    private int Time_T_ISC22;
    private int Time_T_ISC71;
    private int Time_T_ISC72;
    private int Time_T_ISC81;
    private int Time_T_ISC82;
    private int Time_T_ISC91;
    private int Time_T_ISC92;
    private int Time_T_ISC11;
    private int Time_T_ISC12;
    private int Time_T_ISC111;
    private int Time_T_ISC112;
    private int Time_T_ISC101;
    private int Time_T_ISC102;
    private int Time_T_ISC131;
    private int Time_T_ISC132;
    private int Time_T_Mw_S2P;
    private int Time_T_Gm;
    private int Time_T_Cx_LIR;
    private int Time_O_Rx_AAR;
    private int Time_O_Rx_Reserved;
    private int Time_T_Rx_AAR;
    private int Time_T_Rx_Reserved;
    private int Time_T_Sh_UDR;
    private int Time_T_Sh_Reserved;
    private int Time_O_Mj;
    private int Time_T_Mj;
    private long Time_Nc_In;
    private long Time_Nc_Out;
    private int Time_T_Mg;

    private String SBC_O;
    private String S_CSCF_O;
    private String SCC_AS_O;
    private String TAS_O;
    private String SCP_AS_VPMN_O;
    private String SCP_AS_VPMN_QK_O;
    private String SCP_AS_QK_O;
    private String SCIM_AS_O;
    private String CY_AS_O;
    private String Reserved_AS_O;
    private String I_CSCF_T;
    private String S_CSCF_T;
    private String SCP_AS_VPMN_T;
    private String SCP_AS_VPMN_QK_T;
    private String SCP_AS_QK_T;
    private String SCIM_AS_T;
    private String TAS_T;
    private String CAT_A_AS_T;
    private String CAT_V_AS_T;
    private String CY_AS_T;
    private String SCC_AS_T;
    private String GH_AS_T;
    private String IP_SM_GW;
    private String Reserved_AS_T;
    private String SBC_T;
    private String HSS_CX;
    private String PCRF_O;
    private String PCRF_T;
    private String HSS_SH;
    private String MGCF_MJ_O;
    private String MGCF_MJ_T;
    private String NC_OUT;
    private String NC_IN;
    private String MGCF_MG;

    private int Scenario_id;

    private int ci;
    private int SEG_O_MW_O_ISC11;
    private int SEG_O_ISC11_O_ISC12;
    private int SEG_O_ISC21_O_ISC22;
    private int SEG_O_ISC31_O_ISC62;
    private int SEG_O_ISC91_O_ISC92;
    private int SEG_T_MW_T_ISC31;
    private int SEG_T_ISC31_T_ISC62;
    private int SEG_T_ISC21_T_ISC22;
    private int SEG_T_ISC71_T_ISC72;
    private int SEG_T_ISC81_T_ISC82;
    private int SEG_T_ISC91_T_ISC92;
    private int SEG_T_ISC11_T_ISC12;
    private int SEG_T_ISC111_T_ISC112;
    private int SEG_T_MW_T_GM;
    private long SEG_T_NC_T_MG;
    private int SEG_T_MG_T_ISC31;
    private int SEG_T_ISC12_T_MJ;
    private long SEG_O_MJ_O_NC;
    private long SEG_T_MJ_T_NC;
    private int SEG_O_GM_ALL;
    private int SEG_CX;
    private int SEG_SH;
    private int SEG_RX_O;
    private int SEG_RX_T;
    private int SEG_O_MW_T_MW;

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

    @Override
    public int getInterface() {
        return Interface;
    }

    public void setInterface(int anInterface) {
        Interface = anInterface;
    }

    @Override
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

    @Override
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

    public int getTime_O_Gm() {
        return Time_O_Gm;
    }

    public void setTime_O_Gm(int time_O_Gm) {
        Time_O_Gm = time_O_Gm;
    }

    public int getTime_O_Mw_P2S() {
        return Time_O_Mw_P2S;
    }

    public void setTime_O_Mw_P2S(int time_O_Mw_P2S) {
        Time_O_Mw_P2S = time_O_Mw_P2S;
    }

    public int getTime_O_ISC11() {
        return Time_O_ISC11;
    }

    public void setTime_O_ISC11(int time_O_ISC11) {
        Time_O_ISC11 = time_O_ISC11;
    }

    public int getTime_O_ISC12() {
        return Time_O_ISC12;
    }

    public void setTime_O_ISC12(int time_O_ISC12) {
        Time_O_ISC12 = time_O_ISC12;
    }

    public int getTime_O_ISC21() {
        return Time_O_ISC21;
    }

    public void setTime_O_ISC21(int time_O_ISC21) {
        Time_O_ISC21 = time_O_ISC21;
    }

    public int getTime_O_ISC22() {
        return Time_O_ISC22;
    }

    public void setTime_O_ISC22(int time_O_ISC22) {
        Time_O_ISC22 = time_O_ISC22;
    }

    public int getTime_O_ISC31() {
        return Time_O_ISC31;
    }

    public void setTime_O_ISC31(int time_O_ISC31) {
        Time_O_ISC31 = time_O_ISC31;
    }

    public int getTime_O_ISC32() {
        return Time_O_ISC32;
    }

    public void setTime_O_ISC32(int time_O_ISC32) {
        Time_O_ISC32 = time_O_ISC32;
    }

    public int getTime_O_ISC51() {
        return Time_O_ISC51;
    }

    public void setTime_O_ISC51(int time_O_ISC51) {
        Time_O_ISC51 = time_O_ISC51;
    }

    public int getTime_O_ISC52() {
        return Time_O_ISC52;
    }

    public void setTime_O_ISC52(int time_O_ISC52) {
        Time_O_ISC52 = time_O_ISC52;
    }

    public int getTime_O_ISC41() {
        return Time_O_ISC41;
    }

    public void setTime_O_ISC41(int time_O_ISC41) {
        Time_O_ISC41 = time_O_ISC41;
    }

    public int getTime_O_ISC42() {
        return Time_O_ISC42;
    }

    public void setTime_O_ISC42(int time_O_ISC42) {
        Time_O_ISC42 = time_O_ISC42;
    }

    public int getTime_O_ISC61() {
        return Time_O_ISC61;
    }

    public void setTime_O_ISC61(int time_O_ISC61) {
        Time_O_ISC61 = time_O_ISC61;
    }

    public int getTime_O_ISC62() {
        return Time_O_ISC62;
    }

    public void setTime_O_ISC62(int time_O_ISC62) {
        Time_O_ISC62 = time_O_ISC62;
    }

    public int getTime_O_ISC91() {
        return Time_O_ISC91;
    }

    public void setTime_O_ISC91(int time_O_ISC91) {
        Time_O_ISC91 = time_O_ISC91;
    }

    public int getTime_O_ISC92() {
        return Time_O_ISC92;
    }

    public void setTime_O_ISC92(int time_O_ISC92) {
        Time_O_ISC92 = time_O_ISC92;
    }

    public int getTime_O_ISC121() {
        return Time_O_ISC121;
    }

    public void setTime_O_ISC121(int time_O_ISC121) {
        Time_O_ISC121 = time_O_ISC121;
    }

    public int getTime_O_ISC122() {
        return Time_O_ISC122;
    }

    public void setTime_O_ISC122(int time_O_ISC122) {
        Time_O_ISC122 = time_O_ISC122;
    }

    public int getTime_OS2TI_Mw() {
        return Time_OS2TI_Mw;
    }

    public void setTime_OS2TI_Mw(int time_OS2TI_Mw) {
        Time_OS2TI_Mw = time_OS2TI_Mw;
    }

    public int getTime_TI2TS_Mw() {
        return Time_TI2TS_Mw;
    }

    public void setTime_TI2TS_Mw(int time_TI2TS_Mw) {
        Time_TI2TS_Mw = time_TI2TS_Mw;
    }

    public int getTime_T_ISC31() {
        return Time_T_ISC31;
    }

    public void setTime_T_ISC31(int time_T_ISC31) {
        Time_T_ISC31 = time_T_ISC31;
    }

    public int getTime_T_ISC32() {
        return Time_T_ISC32;
    }

    public void setTime_T_ISC32(int time_T_ISC32) {
        Time_T_ISC32 = time_T_ISC32;
    }

    public int getTime_T_ISC51() {
        return Time_T_ISC51;
    }

    public void setTime_T_ISC51(int time_T_ISC51) {
        Time_T_ISC51 = time_T_ISC51;
    }

    public int getTime_T_ISC52() {
        return Time_T_ISC52;
    }

    public void setTime_T_ISC52(int time_T_ISC52) {
        Time_T_ISC52 = time_T_ISC52;
    }

    public int getTime_T_ISC41() {
        return Time_T_ISC41;
    }

    public void setTime_T_ISC41(int time_T_ISC41) {
        Time_T_ISC41 = time_T_ISC41;
    }

    public int getTime_T_ISC42() {
        return Time_T_ISC42;
    }

    public void setTime_T_ISC42(int time_T_ISC42) {
        Time_T_ISC42 = time_T_ISC42;
    }

    public int getTime_T_ISC61() {
        return Time_T_ISC61;
    }

    public void setTime_T_ISC61(int time_T_ISC61) {
        Time_T_ISC61 = time_T_ISC61;
    }

    public int getTime_T_ISC62() {
        return Time_T_ISC62;
    }

    public void setTime_T_ISC62(int time_T_ISC62) {
        Time_T_ISC62 = time_T_ISC62;
    }

    public int getTime_T_ISC21() {
        return Time_T_ISC21;
    }

    public void setTime_T_ISC21(int time_T_ISC21) {
        Time_T_ISC21 = time_T_ISC21;
    }

    public int getTime_T_ISC22() {
        return Time_T_ISC22;
    }

    public void setTime_T_ISC22(int time_T_ISC22) {
        Time_T_ISC22 = time_T_ISC22;
    }

    public int getTime_T_ISC71() {
        return Time_T_ISC71;
    }

    public void setTime_T_ISC71(int time_T_ISC71) {
        Time_T_ISC71 = time_T_ISC71;
    }

    public int getTime_T_ISC72() {
        return Time_T_ISC72;
    }

    public void setTime_T_ISC72(int time_T_ISC72) {
        Time_T_ISC72 = time_T_ISC72;
    }

    public int getTime_T_ISC81() {
        return Time_T_ISC81;
    }

    public void setTime_T_ISC81(int time_T_ISC81) {
        Time_T_ISC81 = time_T_ISC81;
    }

    public int getTime_T_ISC82() {
        return Time_T_ISC82;
    }

    public void setTime_T_ISC82(int time_T_ISC82) {
        Time_T_ISC82 = time_T_ISC82;
    }

    public int getTime_T_ISC91() {
        return Time_T_ISC91;
    }

    public void setTime_T_ISC91(int time_T_ISC91) {
        Time_T_ISC91 = time_T_ISC91;
    }

    public int getTime_T_ISC92() {
        return Time_T_ISC92;
    }

    public void setTime_T_ISC92(int time_T_ISC92) {
        Time_T_ISC92 = time_T_ISC92;
    }

    public int getTime_T_ISC11() {
        return Time_T_ISC11;
    }

    public void setTime_T_ISC11(int time_T_ISC11) {
        Time_T_ISC11 = time_T_ISC11;
    }

    public int getTime_T_ISC12() {
        return Time_T_ISC12;
    }

    public void setTime_T_ISC12(int time_T_ISC12) {
        Time_T_ISC12 = time_T_ISC12;
    }

    public int getTime_T_ISC111() {
        return Time_T_ISC111;
    }

    public void setTime_T_ISC111(int time_T_ISC111) {
        Time_T_ISC111 = time_T_ISC111;
    }

    public int getTime_T_ISC112() {
        return Time_T_ISC112;
    }

    public void setTime_T_ISC112(int time_T_ISC112) {
        Time_T_ISC112 = time_T_ISC112;
    }

    public int getTime_T_ISC101() {
        return Time_T_ISC101;
    }

    public void setTime_T_ISC101(int time_T_ISC101) {
        Time_T_ISC101 = time_T_ISC101;
    }

    public int getTime_T_ISC102() {
        return Time_T_ISC102;
    }

    public void setTime_T_ISC102(int time_T_ISC102) {
        Time_T_ISC102 = time_T_ISC102;
    }

    public int getTime_T_ISC131() {
        return Time_T_ISC131;
    }

    public void setTime_T_ISC131(int time_T_ISC131) {
        Time_T_ISC131 = time_T_ISC131;
    }

    public int getTime_T_ISC132() {
        return Time_T_ISC132;
    }

    public void setTime_T_ISC132(int time_T_ISC132) {
        Time_T_ISC132 = time_T_ISC132;
    }

    public int getTime_T_Mw_S2P() {
        return Time_T_Mw_S2P;
    }

    public void setTime_T_Mw_S2P(int time_T_Mw_S2P) {
        Time_T_Mw_S2P = time_T_Mw_S2P;
    }

    public int getTime_T_Gm() {
        return Time_T_Gm;
    }

    public void setTime_T_Gm(int time_T_Gm) {
        Time_T_Gm = time_T_Gm;
    }

    public int getTime_T_Cx_LIR() {
        return Time_T_Cx_LIR;
    }

    public void setTime_T_Cx_LIR(int time_T_Cx_LIR) {
        Time_T_Cx_LIR = time_T_Cx_LIR;
    }

    public int getTime_O_Rx_AAR() {
        return Time_O_Rx_AAR;
    }

    public void setTime_O_Rx_AAR(int time_O_Rx_AAR) {
        Time_O_Rx_AAR = time_O_Rx_AAR;
    }

    public int getTime_O_Rx_Reserved() {
        return Time_O_Rx_Reserved;
    }

    public void setTime_O_Rx_Reserved(int time_O_Rx_Reserved) {
        Time_O_Rx_Reserved = time_O_Rx_Reserved;
    }

    public int getTime_T_Rx_AAR() {
        return Time_T_Rx_AAR;
    }

    public void setTime_T_Rx_AAR(int time_T_Rx_AAR) {
        Time_T_Rx_AAR = time_T_Rx_AAR;
    }

    public int getTime_T_Rx_Reserved() {
        return Time_T_Rx_Reserved;
    }

    public void setTime_T_Rx_Reserved(int time_T_Rx_Reserved) {
        Time_T_Rx_Reserved = time_T_Rx_Reserved;
    }

    public int getTime_T_Sh_UDR() {
        return Time_T_Sh_UDR;
    }

    public void setTime_T_Sh_UDR(int time_T_Sh_UDR) {
        Time_T_Sh_UDR = time_T_Sh_UDR;
    }

    public int getTime_T_Sh_Reserved() {
        return Time_T_Sh_Reserved;
    }

    public void setTime_T_Sh_Reserved(int time_T_Sh_Reserved) {
        Time_T_Sh_Reserved = time_T_Sh_Reserved;
    }

    public int getTime_O_Mj() {
        return Time_O_Mj;
    }

    public void setTime_O_Mj(int time_O_Mj) {
        Time_O_Mj = time_O_Mj;
    }

    public int getTime_T_Mj() {
        return Time_T_Mj;
    }

    public void setTime_T_Mj(int time_T_Mj) {
        Time_T_Mj = time_T_Mj;
    }

    public long getTime_Nc_In() {
        return Time_Nc_In;
    }

    public void setTime_Nc_In(long time_Nc_In) {
        Time_Nc_In = time_Nc_In;
    }

    public long getTime_Nc_Out() {
        return Time_Nc_Out;
    }

    public void setTime_Nc_Out(long time_Nc_Out) {
        Time_Nc_Out = time_Nc_Out;
    }

    public int getTime_T_Mg() {
        return Time_T_Mg;
    }

    public void setTime_T_Mg(int time_T_Mg) {
        Time_T_Mg = time_T_Mg;
    }

    public String getSBC_O() {
        return SBC_O;
    }

    public void setSBC_O(String SBC_O) {
        this.SBC_O = SBC_O;
    }

    public String getS_CSCF_O() {
        return S_CSCF_O;
    }

    public void setS_CSCF_O(String s_CSCF_O) {
        S_CSCF_O = s_CSCF_O;
    }

    public String getSCC_AS_O() {
        return SCC_AS_O;
    }

    public void setSCC_AS_O(String SCC_AS_O) {
        this.SCC_AS_O = SCC_AS_O;
    }

    public String getTAS_O() {
        return TAS_O;
    }

    public void setTAS_O(String TAS_O) {
        this.TAS_O = TAS_O;
    }

    public String getSCP_AS_VPMN_O() {
        return SCP_AS_VPMN_O;
    }

    public void setSCP_AS_VPMN_O(String SCP_AS_VPMN_O) {
        this.SCP_AS_VPMN_O = SCP_AS_VPMN_O;
    }

    public String getSCP_AS_VPMN_QK_O() {
        return SCP_AS_VPMN_QK_O;
    }

    public void setSCP_AS_VPMN_QK_O(String SCP_AS_VPMN_QK_O) {
        this.SCP_AS_VPMN_QK_O = SCP_AS_VPMN_QK_O;
    }

    public String getSCP_AS_QK_O() {
        return SCP_AS_QK_O;
    }

    public void setSCP_AS_QK_O(String SCP_AS_QK_O) {
        this.SCP_AS_QK_O = SCP_AS_QK_O;
    }

    public String getSCIM_AS_O() {
        return SCIM_AS_O;
    }

    public void setSCIM_AS_O(String SCIM_AS_O) {
        this.SCIM_AS_O = SCIM_AS_O;
    }

    public String getCY_AS_O() {
        return CY_AS_O;
    }

    public void setCY_AS_O(String CY_AS_O) {
        this.CY_AS_O = CY_AS_O;
    }

    public String getReserved_AS_O() {
        return Reserved_AS_O;
    }

    public void setReserved_AS_O(String reserved_AS_O) {
        Reserved_AS_O = reserved_AS_O;
    }

    public String getI_CSCF_T() {
        return I_CSCF_T;
    }

    public void setI_CSCF_T(String i_CSCF_T) {
        I_CSCF_T = i_CSCF_T;
    }

    public String getS_CSCF_T() {
        return S_CSCF_T;
    }

    public void setS_CSCF_T(String s_CSCF_T) {
        S_CSCF_T = s_CSCF_T;
    }

    public String getSCP_AS_VPMN_T() {
        return SCP_AS_VPMN_T;
    }

    public void setSCP_AS_VPMN_T(String SCP_AS_VPMN_T) {
        this.SCP_AS_VPMN_T = SCP_AS_VPMN_T;
    }

    public String getSCP_AS_VPMN_QK_T() {
        return SCP_AS_VPMN_QK_T;
    }

    public void setSCP_AS_VPMN_QK_T(String SCP_AS_VPMN_QK_T) {
        this.SCP_AS_VPMN_QK_T = SCP_AS_VPMN_QK_T;
    }

    public String getSCP_AS_QK_T() {
        return SCP_AS_QK_T;
    }

    public void setSCP_AS_QK_T(String SCP_AS_QK_T) {
        this.SCP_AS_QK_T = SCP_AS_QK_T;
    }

    public String getSCIM_AS_T() {
        return SCIM_AS_T;
    }

    public void setSCIM_AS_T(String SCIM_AS_T) {
        this.SCIM_AS_T = SCIM_AS_T;
    }

    public String getTAS_T() {
        return TAS_T;
    }

    public void setTAS_T(String TAS_T) {
        this.TAS_T = TAS_T;
    }

    public String getCAT_A_AS_T() {
        return CAT_A_AS_T;
    }

    public void setCAT_A_AS_T(String CAT_A_AS_T) {
        this.CAT_A_AS_T = CAT_A_AS_T;
    }

    public String getCAT_V_AS_T() {
        return CAT_V_AS_T;
    }

    public void setCAT_V_AS_T(String CAT_V_AS_T) {
        this.CAT_V_AS_T = CAT_V_AS_T;
    }

    public String getCY_AS_T() {
        return CY_AS_T;
    }

    public void setCY_AS_T(String CY_AS_T) {
        this.CY_AS_T = CY_AS_T;
    }

    public String getSCC_AS_T() {
        return SCC_AS_T;
    }

    public void setSCC_AS_T(String SCC_AS_T) {
        this.SCC_AS_T = SCC_AS_T;
    }

    public String getGH_AS_T() {
        return GH_AS_T;
    }

    public void setGH_AS_T(String GH_AS_T) {
        this.GH_AS_T = GH_AS_T;
    }

    public String getIP_SM_GW() {
        return IP_SM_GW;
    }

    public void setIP_SM_GW(String IP_SM_GW) {
        this.IP_SM_GW = IP_SM_GW;
    }

    public String getReserved_AS_T() {
        return Reserved_AS_T;
    }

    public void setReserved_AS_T(String reserved_AS_T) {
        Reserved_AS_T = reserved_AS_T;
    }

    public String getSBC_T() {
        return SBC_T;
    }

    public void setSBC_T(String SBC_T) {
        this.SBC_T = SBC_T;
    }

    public String getHSS_CX() {
        return HSS_CX;
    }

    public void setHSS_CX(String HSS_CX) {
        this.HSS_CX = HSS_CX;
    }

    public String getPCRF_O() {
        return PCRF_O;
    }

    public void setPCRF_O(String PCRF_O) {
        this.PCRF_O = PCRF_O;
    }

    public String getPCRF_T() {
        return PCRF_T;
    }

    public void setPCRF_T(String PCRF_T) {
        this.PCRF_T = PCRF_T;
    }

    public String getHSS_SH() {
        return HSS_SH;
    }

    public void setHSS_SH(String HSS_SH) {
        this.HSS_SH = HSS_SH;
    }

    public String getMGCF_MJ_O() {
        return MGCF_MJ_O;
    }

    public void setMGCF_MJ_O(String MGCF_MJ_O) {
        this.MGCF_MJ_O = MGCF_MJ_O;
    }

    public String getMGCF_MJ_T() {
        return MGCF_MJ_T;
    }

    public void setMGCF_MJ_T(String MGCF_MJ_T) {
        this.MGCF_MJ_T = MGCF_MJ_T;
    }

    public String getNC_OUT() {
        return NC_OUT;
    }

    public void setNC_OUT(String NC_OUT) {
        this.NC_OUT = NC_OUT;
    }

    public String getNC_IN() {
        return NC_IN;
    }

    public void setNC_IN(String NC_IN) {
        this.NC_IN = NC_IN;
    }

    public String getMGCF_MG() {
        return MGCF_MG;
    }

    public void setMGCF_MG(String MGCF_MG) {
        this.MGCF_MG = MGCF_MG;
    }

    public int getScenario_id() {
        return Scenario_id;
    }

    public void setScenario_id(int scenario_id) {
        Scenario_id = scenario_id;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public int getSEG_O_MW_O_ISC11() {
        return SEG_O_MW_O_ISC11;
    }

    public void setSEG_O_MW_O_ISC11(int SEG_O_MW_O_ISC11) {
        this.SEG_O_MW_O_ISC11 = SEG_O_MW_O_ISC11;
    }

    public int getSEG_O_ISC11_O_ISC12() {
        return SEG_O_ISC11_O_ISC12;
    }

    public void setSEG_O_ISC11_O_ISC12(int SEG_O_ISC11_O_ISC12) {
        this.SEG_O_ISC11_O_ISC12 = SEG_O_ISC11_O_ISC12;
    }

    public int getSEG_O_ISC21_O_ISC22() {
        return SEG_O_ISC21_O_ISC22;
    }

    public void setSEG_O_ISC21_O_ISC22(int SEG_O_ISC21_O_ISC22) {
        this.SEG_O_ISC21_O_ISC22 = SEG_O_ISC21_O_ISC22;
    }

    public int getSEG_O_ISC31_O_ISC62() {
        return SEG_O_ISC31_O_ISC62;
    }

    public void setSEG_O_ISC31_O_ISC62(int SEG_O_ISC31_O_ISC62) {
        this.SEG_O_ISC31_O_ISC62 = SEG_O_ISC31_O_ISC62;
    }

    public int getSEG_O_ISC91_O_ISC92() {
        return SEG_O_ISC91_O_ISC92;
    }

    public void setSEG_O_ISC91_O_ISC92(int SEG_O_ISC91_O_ISC92) {
        this.SEG_O_ISC91_O_ISC92 = SEG_O_ISC91_O_ISC92;
    }

    public int getSEG_T_MW_T_ISC31() {
        return SEG_T_MW_T_ISC31;
    }

    public void setSEG_T_MW_T_ISC31(int SEG_T_MW_T_ISC31) {
        this.SEG_T_MW_T_ISC31 = SEG_T_MW_T_ISC31;
    }

    public int getSEG_T_ISC31_T_ISC62() {
        return SEG_T_ISC31_T_ISC62;
    }

    public void setSEG_T_ISC31_T_ISC62(int SEG_T_ISC31_T_ISC62) {
        this.SEG_T_ISC31_T_ISC62 = SEG_T_ISC31_T_ISC62;
    }

    public int getSEG_T_ISC21_T_ISC22() {
        return SEG_T_ISC21_T_ISC22;
    }

    public void setSEG_T_ISC21_T_ISC22(int SEG_T_ISC21_T_ISC22) {
        this.SEG_T_ISC21_T_ISC22 = SEG_T_ISC21_T_ISC22;
    }

    public int getSEG_T_ISC71_T_ISC72() {
        return SEG_T_ISC71_T_ISC72;
    }

    public void setSEG_T_ISC71_T_ISC72(int SEG_T_ISC71_T_ISC72) {
        this.SEG_T_ISC71_T_ISC72 = SEG_T_ISC71_T_ISC72;
    }

    public int getSEG_T_ISC81_T_ISC82() {
        return SEG_T_ISC81_T_ISC82;
    }

    public void setSEG_T_ISC81_T_ISC82(int SEG_T_ISC81_T_ISC82) {
        this.SEG_T_ISC81_T_ISC82 = SEG_T_ISC81_T_ISC82;
    }

    public int getSEG_T_ISC91_T_ISC92() {
        return SEG_T_ISC91_T_ISC92;
    }

    public void setSEG_T_ISC91_T_ISC92(int SEG_T_ISC91_T_ISC92) {
        this.SEG_T_ISC91_T_ISC92 = SEG_T_ISC91_T_ISC92;
    }

    public int getSEG_T_ISC11_T_ISC12() {
        return SEG_T_ISC11_T_ISC12;
    }

    public void setSEG_T_ISC11_T_ISC12(int SEG_T_ISC11_T_ISC12) {
        this.SEG_T_ISC11_T_ISC12 = SEG_T_ISC11_T_ISC12;
    }

    public int getSEG_T_ISC111_T_ISC112() {
        return SEG_T_ISC111_T_ISC112;
    }

    public void setSEG_T_ISC111_T_ISC112(int SEG_T_ISC111_T_ISC112) {
        this.SEG_T_ISC111_T_ISC112 = SEG_T_ISC111_T_ISC112;
    }

    public int getSEG_T_MW_T_GM() {
        return SEG_T_MW_T_GM;
    }

    public void setSEG_T_MW_T_GM(int SEG_T_MW_T_GM) {
        this.SEG_T_MW_T_GM = SEG_T_MW_T_GM;
    }

    public long getSEG_T_NC_T_MG() {
        return SEG_T_NC_T_MG;
    }

    public void setSEG_T_NC_T_MG(long SEG_T_NC_T_MG) {
        this.SEG_T_NC_T_MG = SEG_T_NC_T_MG;
    }

    public int getSEG_T_MG_T_ISC31() {
        return SEG_T_MG_T_ISC31;
    }

    public void setSEG_T_MG_T_ISC31(int SEG_T_MG_T_ISC31) {
        this.SEG_T_MG_T_ISC31 = SEG_T_MG_T_ISC31;
    }

    public int getSEG_T_ISC12_T_MJ() {
        return SEG_T_ISC12_T_MJ;
    }

    public void setSEG_T_ISC12_T_MJ(int SEG_T_ISC12_T_MJ) {
        this.SEG_T_ISC12_T_MJ = SEG_T_ISC12_T_MJ;
    }

    public long getSEG_O_MJ_O_NC() {
        return SEG_O_MJ_O_NC;
    }

    public void setSEG_O_MJ_O_NC(long SEG_O_MJ_O_NC) {
        this.SEG_O_MJ_O_NC = SEG_O_MJ_O_NC;
    }

    public long getSEG_T_MJ_T_NC() {
        return SEG_T_MJ_T_NC;
    }

    public void setSEG_T_MJ_T_NC(long SEG_T_MJ_T_NC) {
        this.SEG_T_MJ_T_NC = SEG_T_MJ_T_NC;
    }

    public int getSEG_O_GM_ALL() {
        return SEG_O_GM_ALL;
    }

    public void setSEG_O_GM_ALL(int SEG_O_GM_ALL) {
        this.SEG_O_GM_ALL = SEG_O_GM_ALL;
    }

    public int getSEG_CX() {
        return SEG_CX;
    }

    public void setSEG_CX(int SEG_CX) {
        this.SEG_CX = SEG_CX;
    }

    public int getSEG_SH() {
        return SEG_SH;
    }

    public void setSEG_SH(int SEG_SH) {
        this.SEG_SH = SEG_SH;
    }

    public int getSEG_RX_O() {
        return SEG_RX_O;
    }

    public void setSEG_RX_O(int SEG_RX_O) {
        this.SEG_RX_O = SEG_RX_O;
    }

    public int getSEG_RX_T() {
        return SEG_RX_T;
    }

    public void setSEG_RX_T(int SEG_RX_T) {
        this.SEG_RX_T = SEG_RX_T;
    }

    public int getSEG_O_MW_T_MW() {
        return SEG_O_MW_T_MW;
    }

    public void setSEG_O_MW_T_MW(int SEG_O_MW_T_MW) {
        this.SEG_O_MW_T_MW = SEG_O_MW_T_MW;
    }


    private String filter(long data) {
        if (data == -1 || data == 0) {
            return "";
        }
        return String.valueOf(data);
    }

    private String filter(String data) {
        if (data == null) {
            return "";
        }
        return data;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(filter(length));
        stringBuffer.append("|").append(filter(city));
        stringBuffer.append("|").append(filter(Interface));
        stringBuffer.append("|").append(filter(xdr_id));
        stringBuffer.append("|").append(filter(rat));
        stringBuffer.append("|").append(filter(start_time));
        stringBuffer.append("|").append(filter(end_time));
        stringBuffer.append("|").append(filter(imsi_caller));
        stringBuffer.append("|").append(filter(imei_caller));
        stringBuffer.append("|").append(filter(msisdn_caller));
        stringBuffer.append("|").append(filter(cell_caller));
        stringBuffer.append("|").append(filter(tac_caller));
        stringBuffer.append("|").append(filter(imsi_callee));
        stringBuffer.append("|").append(filter(imei_callee));
        stringBuffer.append("|").append(filter(msisdn_callee));
        stringBuffer.append("|").append(filter(cell_callee));
        stringBuffer.append("|").append(filter(tac_callee));

        stringBuffer.append("|").append(filter(xdr_number));

        stringBuffer.append("|").append(filter(Time_O_Gm));
        stringBuffer.append("|").append(filter(Time_O_Mw_P2S));
        stringBuffer.append("|").append(filter(Time_O_ISC11));
        stringBuffer.append("|").append(filter(Time_O_ISC12));
        stringBuffer.append("|").append(filter(Time_O_ISC21));
        stringBuffer.append("|").append(filter(Time_O_ISC22));
        stringBuffer.append("|").append(filter(Time_O_ISC31));
        stringBuffer.append("|").append(filter(Time_O_ISC32));
        stringBuffer.append("|").append(filter(Time_O_ISC51));
        stringBuffer.append("|").append(filter(Time_O_ISC52));
        stringBuffer.append("|").append(filter(Time_O_ISC41));
        stringBuffer.append("|").append(filter(Time_O_ISC42));
        stringBuffer.append("|").append(filter(Time_O_ISC61));
        stringBuffer.append("|").append(filter(Time_O_ISC62));
        stringBuffer.append("|").append(filter(Time_O_ISC91));
        stringBuffer.append("|").append(filter(Time_O_ISC92));
        stringBuffer.append("|").append(filter(Time_O_ISC121));
        stringBuffer.append("|").append(filter(Time_O_ISC122));
        stringBuffer.append("|").append(filter(Time_OS2TI_Mw));
        stringBuffer.append("|").append(filter(Time_TI2TS_Mw));
        stringBuffer.append("|").append(filter(Time_T_ISC31));
        stringBuffer.append("|").append(filter(Time_T_ISC32));
        stringBuffer.append("|").append(filter(Time_T_ISC51));
        stringBuffer.append("|").append(filter(Time_T_ISC52));
        stringBuffer.append("|").append(filter(Time_T_ISC41));
        stringBuffer.append("|").append(filter(Time_T_ISC42));
        stringBuffer.append("|").append(filter(Time_T_ISC61));
        stringBuffer.append("|").append(filter(Time_T_ISC62));
        stringBuffer.append("|").append(filter(Time_T_ISC21));
        stringBuffer.append("|").append(filter(Time_T_ISC22));
        stringBuffer.append("|").append(filter(Time_T_ISC71));
        stringBuffer.append("|").append(filter(Time_T_ISC72));
        stringBuffer.append("|").append(filter(Time_T_ISC81));
        stringBuffer.append("|").append(filter(Time_T_ISC82));
        stringBuffer.append("|").append(filter(Time_T_ISC91));
        stringBuffer.append("|").append(filter(Time_T_ISC92));
        stringBuffer.append("|").append(filter(Time_T_ISC11));
        stringBuffer.append("|").append(filter(Time_T_ISC12));
        stringBuffer.append("|").append(filter(Time_T_ISC111));
        stringBuffer.append("|").append(filter(Time_T_ISC112));
        stringBuffer.append("|").append(filter(Time_T_ISC101));
        stringBuffer.append("|").append(filter(Time_T_ISC102));
        stringBuffer.append("|").append(filter(Time_T_ISC131));
        stringBuffer.append("|").append(filter(Time_T_ISC132));
        stringBuffer.append("|").append(filter(Time_T_Mw_S2P));
        stringBuffer.append("|").append(filter(Time_T_Gm));
        stringBuffer.append("|").append(filter(Time_T_Cx_LIR));
        stringBuffer.append("|").append(filter(Time_O_Rx_AAR));
        stringBuffer.append("|").append(filter(Time_O_Rx_Reserved));
        stringBuffer.append("|").append(filter(Time_T_Rx_AAR));
        stringBuffer.append("|").append(filter(Time_T_Rx_Reserved));
        stringBuffer.append("|").append(filter(Time_T_Sh_UDR));
        stringBuffer.append("|").append(filter(Time_T_Sh_Reserved));
        stringBuffer.append("|").append(filter(Time_O_Mj));
        stringBuffer.append("|").append(filter(Time_T_Mj));
        stringBuffer.append("|").append(filter(Time_Nc_In));
        stringBuffer.append("|").append(filter(Time_Nc_Out));
        stringBuffer.append("|").append(filter(Time_T_Mg));
        stringBuffer.append("|").append(filter(SBC_O));
        stringBuffer.append("|").append(filter(S_CSCF_O));
        stringBuffer.append("|").append(filter(SCC_AS_O));
        stringBuffer.append("|").append(filter(TAS_O));
        stringBuffer.append("|").append(filter(SCP_AS_VPMN_O));
        stringBuffer.append("|").append(filter(SCP_AS_VPMN_QK_O));
        stringBuffer.append("|").append(filter(SCP_AS_QK_O));
        stringBuffer.append("|").append(filter(SCIM_AS_O));
        stringBuffer.append("|").append(filter(CY_AS_O));
        stringBuffer.append("|").append(filter(Reserved_AS_O));
        stringBuffer.append("|").append(filter(I_CSCF_T));
        stringBuffer.append("|").append(filter(S_CSCF_T));
        stringBuffer.append("|").append(filter(SCP_AS_VPMN_T));
        stringBuffer.append("|").append(filter(SCP_AS_VPMN_QK_T));
        stringBuffer.append("|").append(filter(SCP_AS_QK_T));
        stringBuffer.append("|").append(filter(SCIM_AS_T));
        stringBuffer.append("|").append(filter(TAS_T));
        stringBuffer.append("|").append(filter(CAT_A_AS_T));
        stringBuffer.append("|").append(filter(CAT_V_AS_T));
        stringBuffer.append("|").append(filter(CY_AS_T));
        stringBuffer.append("|").append(filter(SCC_AS_T));
        stringBuffer.append("|").append(filter(GH_AS_T));
        stringBuffer.append("|").append(filter(IP_SM_GW));
        stringBuffer.append("|").append(filter(Reserved_AS_T));
        stringBuffer.append("|").append(filter(SBC_T));
        stringBuffer.append("|").append(filter(HSS_CX));
        stringBuffer.append("|").append(filter(PCRF_O));
        stringBuffer.append("|").append(filter(PCRF_T));
        stringBuffer.append("|").append(filter(HSS_SH));
        stringBuffer.append("|").append(filter(MGCF_MJ_O));
        stringBuffer.append("|").append(filter(MGCF_MJ_T));
        stringBuffer.append("|").append(filter(NC_OUT));
        stringBuffer.append("|").append(filter(NC_IN));
        stringBuffer.append("|").append(filter(MGCF_MG));
        stringBuffer.append("|").append(filter(Scenario_id));
        stringBuffer.append("|").append(filter(ci));
        stringBuffer.append("|").append(filter(SEG_O_MW_O_ISC11));
        stringBuffer.append("|").append(filter(SEG_O_ISC11_O_ISC12));
        stringBuffer.append("|").append(filter(SEG_O_ISC21_O_ISC22));
        stringBuffer.append("|").append(filter(SEG_O_ISC31_O_ISC62));
        stringBuffer.append("|").append(filter(SEG_O_ISC91_O_ISC92));
        stringBuffer.append("|").append(filter(SEG_T_MW_T_ISC31));
        stringBuffer.append("|").append(filter(SEG_T_ISC31_T_ISC62));
        stringBuffer.append("|").append(filter(SEG_T_ISC21_T_ISC22));
        stringBuffer.append("|").append(filter(SEG_T_ISC71_T_ISC72));
        stringBuffer.append("|").append(filter(SEG_T_ISC81_T_ISC82));
        stringBuffer.append("|").append(filter(SEG_T_ISC91_T_ISC92));
        stringBuffer.append("|").append(filter(SEG_T_ISC11_T_ISC12));
        stringBuffer.append("|").append(filter(SEG_T_ISC111_T_ISC112));
        stringBuffer.append("|").append(filter(SEG_T_MW_T_GM));
        stringBuffer.append("|").append(filter(SEG_T_NC_T_MG));
        stringBuffer.append("|").append(filter(SEG_T_MG_T_ISC31));
        stringBuffer.append("|").append(filter(SEG_T_ISC12_T_MJ));
        stringBuffer.append("|").append(filter(SEG_O_MJ_O_NC));
        stringBuffer.append("|").append(filter(SEG_T_MJ_T_NC));
        stringBuffer.append("|").append(filter(SEG_O_GM_ALL));
        stringBuffer.append("|").append(filter(SEG_CX));
        stringBuffer.append("|").append(filter(SEG_SH));
        stringBuffer.append("|").append(filter(SEG_RX_O));
        stringBuffer.append("|").append(filter(SEG_RX_T));
        stringBuffer.append("|").append(filter(SEG_O_MW_T_MW));

        return stringBuffer.toString();
    }
}
