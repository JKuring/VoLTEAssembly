package com.eastcom.volte.storm.storm.arithmetic;

import com.eastcom.volte.data.DataCommon;
import com.eastcom.volte.data.cxtype.cx.Cx;
import com.eastcom.volte.data.gmtype.gm.Gm;
import com.eastcom.volte.data.gmtype.isc.ISC;
import com.eastcom.volte.data.gmtype.mg.Mg;
import com.eastcom.volte.data.gmtype.mw.Mw;
import com.eastcom.volte.data.nc.Nc;
import com.eastcom.volte.data.volte.VoLTE;
import com.eastcom.volte.data.xdr.MergedXDR;
import com.eastcom.volte.storm.common.utilities.IPv6Standardization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * Created by linghang.kong on 2016/8/29.
 */
public class Merger {

    private static final Logger logger = LoggerFactory.getLogger(Merger.class);
    private static final int FALSE_CODE = -1;

    private MergedXDR mergedXDR;
    private List<DataCommon> dataCommonList;
    private Map<String, String> networkElementMap;
    private VoLTE voLTE;

    /**
     * XDR merged algorithm.
     *
     * @param mergedXDR         MergedXDR.
     * @param dataCommonList    The 58 xdr data was created by xdr_ids of MergedXDR table.
     * @param networkElementMap Network element map from a NB table.
     */
    public Merger create(MergedXDR mergedXDR, List<DataCommon> dataCommonList, Map<String, String> networkElementMap) {
        this.mergedXDR = mergedXDR;
        this.dataCommonList = dataCommonList;
        this.networkElementMap = networkElementMap;
        this.voLTE = new VoLTE();
        return this;
    }

    private void logProcessing(String expression, String log) {
        logger.debug(expression, log);
    }

    public VoLTE doMerge() {
        voLTE.setLength(this.getLength());
        voLTE.setCity(this.getCity());
        voLTE.setInterface(this.getInterface());
        voLTE.setXdr_id(this.getXdr_id());
        voLTE.setRat(this.getRat());
        voLTE.setStart_time(this.getStart_time());
        voLTE.setEnd_time(this.getEnd_time());
        voLTE.setImsi_caller(this.getImsi_caller());
        voLTE.setImei_caller(this.getImei_caller());
        voLTE.setMsisdn_caller(this.getMsisdn_caller());
        voLTE.setCell_caller(this.getCell_caller());
        voLTE.setTac_caller(this.getTac_caller());
        voLTE.setImsi_callee(this.getImsi_callee());
        voLTE.setImei_callee(this.getImei_callee());
        voLTE.setMsisdn_callee(this.getMsisdn_callee());
        voLTE.setCell_callee(this.getCell_callee());
        voLTE.setTac_callee(this.getTac_callee());
        voLTE.setXdr_number(this.getXdr_number());
        voLTE.setTime_O_Gm(this.getTime_O_Gm());
        voLTE.setTime_O_Mw_P2S(this.getTime_O_Mw_P2S());
        voLTE.setTime_O_ISC11(this.getTime_O_ISC11());
        voLTE.setTime_O_ISC12(this.getTime_O_ISC12());
        voLTE.setTime_O_ISC21(this.getTime_O_ISC21());
        voLTE.setTime_O_ISC22(this.getTime_O_ISC22());
        voLTE.setTime_O_ISC31(this.getTime_O_ISC31());
        voLTE.setTime_O_ISC32(this.getTime_O_ISC32());
        voLTE.setTime_O_ISC51(this.getTime_O_ISC51());
        voLTE.setTime_O_ISC52(this.getTime_O_ISC52());
        voLTE.setTime_O_ISC41(this.getTime_O_ISC41());
        voLTE.setTime_O_ISC42(this.getTime_O_ISC42());
        voLTE.setTime_O_ISC61(this.getTime_O_ISC61());
        voLTE.setTime_O_ISC62(this.getTime_O_ISC62());
        voLTE.setTime_O_ISC91(this.getTime_O_ISC91());
        voLTE.setTime_O_ISC92(this.getTime_O_ISC92());
        voLTE.setTime_O_ISC121(this.getTime_O_ISC121());
        voLTE.setTime_O_ISC122(this.getTime_O_ISC122());
        voLTE.setTime_OS2TI_Mw(this.getTime_OS2TI_Mw());
        voLTE.setTime_TI2TS_Mw(this.getTime_TI2TS_Mw());
        voLTE.setTime_T_ISC31(this.getTime_T_ISC31());
        voLTE.setTime_T_ISC32(this.getTime_T_ISC32());
        voLTE.setTime_T_ISC51(this.getTime_T_ISC51());
        voLTE.setTime_T_ISC52(this.getTime_T_ISC52());
        voLTE.setTime_T_ISC41(this.getTime_T_ISC41());
        voLTE.setTime_T_ISC42(this.getTime_T_ISC42());
        voLTE.setTime_T_ISC61(this.getTime_T_ISC61());
        voLTE.setTime_T_ISC62(this.getTime_T_ISC62());
        voLTE.setTime_T_ISC21(this.getTime_T_ISC21());
        voLTE.setTime_T_ISC22(this.getTime_T_ISC22());
        voLTE.setTime_T_ISC71(this.getTime_T_ISC71());
        voLTE.setTime_T_ISC72(this.getTime_T_ISC72());
        voLTE.setTime_T_ISC81(this.getTime_T_ISC81());
        voLTE.setTime_T_ISC82(this.getTime_T_ISC82());
        voLTE.setTime_T_ISC91(this.getTime_T_ISC91());
        voLTE.setTime_T_ISC92(this.getTime_T_ISC92());
        voLTE.setTime_T_ISC11(this.getTime_T_ISC11());
        voLTE.setTime_T_ISC12(this.getTime_T_ISC12());
        voLTE.setTime_T_ISC111(this.getTime_T_ISC111());
        voLTE.setTime_T_ISC112(this.getTime_T_ISC112());
        voLTE.setTime_T_ISC101(this.getTime_T_ISC101());
        voLTE.setTime_T_ISC102(this.getTime_T_ISC102());
        voLTE.setTime_T_ISC131(this.getTime_T_ISC131());
        voLTE.setTime_T_ISC132(this.getTime_T_ISC132());
        voLTE.setTime_T_Mw_S2P(this.getTime_T_Mw_S2P());
        voLTE.setTime_T_Gm(this.getTime_T_Gm());
        voLTE.setTime_T_Cx_LIR(this.getTime_T_Cx_LIR());
        voLTE.setTime_O_Rx_AAR(this.getTime_O_Rx_AAR());
        voLTE.setTime_O_Rx_Reserved(this.getTime_O_Rx_Reserved());
        voLTE.setTime_T_Rx_AAR(this.getTime_T_Rx_AAR());
        voLTE.setTime_T_Rx_Reserved(this.getTime_T_Rx_Reserved());
        voLTE.setTime_T_Sh_UDR(this.getTime_T_Sh_UDR());
        voLTE.setTime_T_Sh_Reserved(this.getTime_T_Sh_Reserved());
        voLTE.setTime_O_Mj(this.getTime_O_Mj());
        voLTE.setTime_T_Mj(this.getTime_T_Mj());
        voLTE.setTime_Nc_In(this.getTime_Nc_In());
        voLTE.setTime_Nc_Out(this.getTime_Nc_Out());
        voLTE.setTime_T_Mg(this.getTime_T_Mg());
        voLTE.setSBC_O(this.getSBC_O());
        voLTE.setS_CSCF_O(this.getS_CSCF_O());
        voLTE.setSCC_AS_O(this.getSCC_AS_O());
        voLTE.setTAS_O(this.getTAS_O());
        voLTE.setSCP_AS_VPMN_O(this.getSCP_AS_VPMN_O());
        voLTE.setSCP_AS_VPMN_QK_O(this.getSCP_AS_VPMN_QK_O());
        voLTE.setSCP_AS_QK_O(this.getSCP_AS_QK_O());
        voLTE.setSCIM_AS_O(this.getSCIM_AS_O());
        voLTE.setCY_AS_O(this.getCY_AS_O());
        voLTE.setReserved_AS_O(this.getReserved_AS_O());
        voLTE.setI_CSCF_T(this.getI_CSCF_T());
        voLTE.setS_CSCF_T(this.getS_CSCF_T());
        voLTE.setSCP_AS_VPMN_T(this.getSCP_AS_VPMN_T());
        voLTE.setSCP_AS_VPMN_QK_T(this.getSCP_AS_VPMN_QK_T());
        voLTE.setSCP_AS_QK_T(this.getSCP_AS_QK_T());
        voLTE.setSCIM_AS_T(this.getSCIM_AS_T());
        voLTE.setTAS_T(this.getTAS_T());
        voLTE.setCAT_A_AS_T(this.getCAT_A_AS_T());
        voLTE.setCAT_V_AS_T(this.getCAT_V_AS_T());
        voLTE.setCY_AS_T(this.getCY_AS_T());
        voLTE.setSCC_AS_T(this.getSCC_AS_T());
        voLTE.setGH_AS_T(this.getGH_AS_T());
        voLTE.setIP_SM_GW(this.getIP_SM_GW());
        voLTE.setReserved_AS_T(this.getReserved_AS_T());
        voLTE.setSBC_T(this.getSBC_T());
        voLTE.setHSS_CX(this.getHSS_CX());
        voLTE.setPCRF_O(this.getPCRF_O());
        voLTE.setPCRF_T(this.getPCRF_T());
        voLTE.setHSS_SH(this.getHSS_SH());
        voLTE.setMGCF_MJ_O(this.getMGCF_MJ_O());
        voLTE.setMGCF_MJ_T(this.getMGCF_MJ_T());
        voLTE.setNC_OUT(this.getNC_OUT());
        voLTE.setNC_IN(this.getNC_IN());
        voLTE.setMGCF_MG(this.getMGCF_MG());
        voLTE.setScenario_id(this.getScenario_id());
        voLTE.setCi(this.getCi());
        voLTE.setSEG_O_MW_O_ISC11(this.getSEG_O_MW_O_ISC11());
        voLTE.setSEG_O_ISC11_O_ISC12(this.getSEG_O_ISC11_O_ISC12());
        voLTE.setSEG_O_ISC21_O_ISC22(this.getSEG_O_ISC21_O_ISC22());
        voLTE.setSEG_O_ISC31_O_ISC62(this.getSEG_O_ISC31_O_ISC62());
        voLTE.setSEG_O_ISC91_O_ISC92(this.getSEG_O_ISC91_O_ISC92());
        voLTE.setSEG_T_MW_T_ISC31(this.getSEG_T_MW_T_ISC31());
        voLTE.setSEG_T_ISC31_T_ISC62(this.getSEG_T_ISC31_T_ISC62());
        voLTE.setSEG_T_ISC21_T_ISC22(this.getSEG_T_ISC21_T_ISC22());
        voLTE.setSEG_T_ISC71_T_ISC72(this.getSEG_T_ISC71_T_ISC72());
        voLTE.setSEG_T_ISC81_T_ISC82(this.getSEG_T_ISC81_T_ISC82());
        voLTE.setSEG_T_ISC91_T_ISC92(this.getSEG_T_ISC91_T_ISC92());
        voLTE.setSEG_T_ISC11_T_ISC12(this.getSEG_T_ISC11_T_ISC12());
        voLTE.setSEG_T_ISC111_T_ISC112(this.getSEG_T_ISC111_T_ISC112());
        voLTE.setSEG_T_MW_T_GM(this.getSEG_T_MW_T_GM());
        voLTE.setSEG_T_NC_T_MG(this.getSEG_T_NC_T_MG());
        voLTE.setSEG_T_MG_T_ISC31(this.getSEG_T_MG_T_ISC31());
        voLTE.setSEG_T_ISC12_T_MJ(this.getSEG_T_ISC12_T_MJ());
        voLTE.setSEG_O_MJ_O_NC(this.getSEG_O_MJ_O_NC());
        voLTE.setSEG_T_MJ_T_NC(this.getSEG_T_MJ_T_NC());
        voLTE.setSEG_O_GM_ALL(this.getSEG_O_GM_ALL());
        voLTE.setSEG_CX(this.getSEG_CX());
        voLTE.setSEG_SH(this.getSEG_SH());
        voLTE.setSEG_RX_O(this.getSEG_RX_O());
        voLTE.setSEG_RX_T(this.getSEG_RX_T());
        voLTE.setSEG_O_MW_T_MW(this.getSEG_O_MW_T_MW());

        return voLTE;
    }


    public int getLength() {
        return mergedXDR.getLength();
    }

    public String getCity() {
        return mergedXDR.getCity();
    }

    public int getInterface() {
        return mergedXDR.getInterface();
    }

    public String getXdr_id() {
        return mergedXDR.getXdr_id();
    }

    public int getRat() {
        return mergedXDR.getRat();
    }

    public long getStart_time() {
        return mergedXDR.getStart_time();
    }

    public long getEnd_time() {
        return mergedXDR.getEnd_time();
    }

    public String getImsi_caller() {
        return mergedXDR.getImsi_caller();
    }

    public String getImei_caller() {
        return mergedXDR.getImei_caller();
    }

    public String getMsisdn_caller() {
        return mergedXDR.getMsisdn_caller();
    }

    public String getCell_caller() {
        return mergedXDR.getCell_caller();
    }

    public String getTac_caller() {
        return mergedXDR.getTac_caller();
    }

    public String getImsi_callee() {
        return mergedXDR.getImsi_callee();
    }

    public String getImei_callee() {
        return mergedXDR.getImei_callee();
    }

    public String getMsisdn_callee() {
        return mergedXDR.getMsisdn_callee();
    }

    public String getCell_callee() {
        return mergedXDR.getCell_callee();
    }

    public String getTac_callee() {
        return mergedXDR.getTac_callee();
    }

    public int getXdr_number() {
        return mergedXDR.getXdr_number();
    }

    public int getTime_O_Gm() {
        try {
            return ((Gm) dataCommonList.get(0)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_O_Gm exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_O_Mw_P2S() {
        try {
            return ((Mw) dataCommonList.get(1)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_O_Mw_P2S exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_O_ISC11() {
        try {
            return ((ISC) dataCommonList.get(2)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_O_ISC11 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_O_ISC12() {
        try {
            return ((ISC) dataCommonList.get(3)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_O_ISC12 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_O_ISC21() {
        try {
            return ((ISC) dataCommonList.get(4)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_O_ISC21 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_O_ISC22() {
        try {
            return ((ISC) dataCommonList.get(5)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_O_ISC22 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_O_ISC31() {
        try {
            return ((ISC) dataCommonList.get(6)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_O_ISC31 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_O_ISC32() {
        try {
            return ((ISC) dataCommonList.get(7)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_O_ISC32 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_O_ISC51() {
        try {
            return ((ISC) dataCommonList.get(8)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_O_ISC51 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_O_ISC52() {
        try {
            return ((ISC) dataCommonList.get(9)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_O_ISC52 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_O_ISC41() {
        try {
            return ((ISC) dataCommonList.get(10)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_O_ISC41 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_O_ISC42() {
        try {
            return ((ISC) dataCommonList.get(11)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_O_ISC42 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_O_ISC61() {
        try {
            return ((ISC) dataCommonList.get(12)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_O_ISC61 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_O_ISC62() {
        try {
            return ((ISC) dataCommonList.get(13)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_O_ISC62 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_O_ISC91() {
        try {
            return ((ISC) dataCommonList.get(14)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_O_ISC91 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_O_ISC92() {
        try {
            return ((ISC) dataCommonList.get(15)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_O_ISC92 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_O_ISC121() {
        try {
            return ((ISC) dataCommonList.get(16)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_O_ISC121 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_O_ISC122() {
        try {
            return ((ISC) dataCommonList.get(17)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_O_ISC122 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_OS2TI_Mw() {
        try {
            return ((Mw) dataCommonList.get(18)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_OS2TI_Mw exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_TI2TS_Mw() {
        try {
            return ((Mw) dataCommonList.get(19)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_TI2TS_Mw exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_T_ISC31() {
        try {
            return ((ISC) dataCommonList.get(20)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_T_ISC31 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_T_ISC32() {
        try {
            return ((ISC) dataCommonList.get(21)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_T_ISC32 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_T_ISC51() {
        try {
            return ((ISC) dataCommonList.get(22)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_T_ISC51 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_T_ISC52() {
        try {
            return ((ISC) dataCommonList.get(23)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_T_ISC52 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_T_ISC41() {
        try {
            return ((ISC) dataCommonList.get(24)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_T_ISC41 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_T_ISC42() {
        try {
            return ((ISC) dataCommonList.get(25)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_T_ISC42 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_T_ISC61() {
        try {
            return ((ISC) dataCommonList.get(26)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_T_ISC61 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_T_ISC62() {
        try {
            return ((ISC) dataCommonList.get(27)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_T_ISC62 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_T_ISC21() {
        try {
            return ((ISC) dataCommonList.get(28)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_T_ISC21 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_T_ISC22() {
        try {
            return ((ISC) dataCommonList.get(29)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_T_ISC22 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_T_ISC71() {
        try {
            return ((ISC) dataCommonList.get(30)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_T_ISC71 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_T_ISC72() {
        try {
            return ((ISC) dataCommonList.get(31)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_T_ISC72 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_T_ISC81() {
        try {
            return ((ISC) dataCommonList.get(32)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_T_ISC81 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_T_ISC82() {
        try {
            return ((ISC) dataCommonList.get(33)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_T_ISC82 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_T_ISC91() {
        try {
            return ((ISC) dataCommonList.get(34)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_T_ISC91 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_T_ISC92() {
        try {
            return ((ISC) dataCommonList.get(35)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_T_ISC92 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_T_ISC11() {
        try {
            return ((ISC) dataCommonList.get(36)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_T_ISC11 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_T_ISC12() {
        try {
            return ((ISC) dataCommonList.get(37)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_T_ISC12 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_T_ISC111() {
        try {
            return ((ISC) dataCommonList.get(38)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_T_ISC111 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_T_ISC112() {
        try {
            return ((ISC) dataCommonList.get(39)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_T_ISC112 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_T_ISC101() {
        try {
            return ((ISC) dataCommonList.get(40)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_T_ISC101 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_T_ISC102() {
        try {
            return ((ISC) dataCommonList.get(41)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_T_ISC102 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_T_ISC131() {
        try {
            return ((ISC) dataCommonList.get(42)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_T_ISC131 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_T_ISC132() {
        try {
            return ((ISC) dataCommonList.get(43)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_T_ISC132 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_T_Mw_S2P() {
        try {
            return ((Mw) dataCommonList.get(44)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_T_Mw_S2P exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_T_Gm() {
        try {
            return ((Gm) dataCommonList.get(45)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_T_Gm exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_T_Cx_LIR() {
        try {
            Cx cx = (Cx) dataCommonList.get(46);
            return (int) (cx.getEnd_time() - cx.getStart_time());
        } catch (Exception e) {
            logProcessing("getTime_T_Cx_LIR exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_O_Rx_AAR() {
        try {
            return (int) mergedXDR.getTime_o_rx_aar();
        } catch (Exception e) {
            logProcessing("getTime_O_Rx_AAR exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_O_Rx_Reserved() {
        try {
            return (int) mergedXDR.getTime_o_rx_reserved();
        } catch (Exception e) {
            logProcessing("getTime_O_Rx_Reserved exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_T_Rx_AAR() {
        try {
            return (int) mergedXDR.getTime_t_rx_aar();
        } catch (Exception e) {
            logProcessing("getTime_T_Rx_AAR exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_T_Rx_Reserved() {
        try {
            return (int) mergedXDR.getTime_t_rx_reserved();
        } catch (Exception e) {
            logProcessing("getTime_T_Rx_Reserved exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_T_Sh_UDR() {
        try {
            return (int) mergedXDR.getTime_t_sh_udr();
        } catch (Exception e) {
            logProcessing("getTime_T_Sh_UDR exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_T_Sh_Reserved() {
        try {
            return (int) mergedXDR.getTime_t_sh_reserved();
        } catch (Exception e) {
            logProcessing("getTime_T_Sh_Reserved exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_O_Mj() {
        try {
            return ((Mg) dataCommonList.get(53)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_O_Mj exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_T_Mj() {
        try {
            return ((Mg) dataCommonList.get(54)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_T_Mj exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public long getTime_Nc_In() {
        try {
            return ((Nc) dataCommonList.get(55)).getAcmoffset();
        } catch (Exception e) {
            logProcessing("getTime_Nc_In exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public long getTime_Nc_Out() {
        try {
            return ((Nc) dataCommonList.get(56)).getAcmoffset();
        } catch (Exception e) {
            logProcessing("getTime_Nc_Out exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getTime_T_Mg() {
        try {
            return ((Mg) dataCommonList.get(57)).getAlerting_time();
        } catch (Exception e) {
            logProcessing("getTime_T_Mg exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public String getSBC_O() {
        String ip = null;
        String net = null;
        try {
            ip = dataCommonList.get(0).getDest_ne_ip();
            net = networkElementMap.get(IPv6Standardization.standard(ip));
            if (net.length() > 0) {
                return net;
            }
        } catch (Exception e) {
            logProcessing("getSBC_O exception: {}.", e.getMessage());
        }
        return ip;
    }

    public String getS_CSCF_O() {
        String tmp;
        String ip = null;
        try {
            if ((tmp = networkElementMap.get(IPv6Standardization.standard(ip = dataCommonList.get(1).getDest_ne_ip()))) != null) {
                return tmp;
            } else if ((tmp = networkElementMap.get(IPv6Standardization.standard(ip = dataCommonList.get(3).getDest_ne_ip()))) != null) {
                return tmp;
            } else if ((tmp = networkElementMap.get(IPv6Standardization.standard(ip = dataCommonList.get(5).getDest_ne_ip()))) != null) {
                return tmp;
            } else if ((tmp = networkElementMap.get(IPv6Standardization.standard(ip = dataCommonList.get(7).getDest_ne_ip()))) != null) {
                return tmp;
            } else if ((tmp = networkElementMap.get(IPv6Standardization.standard(ip = dataCommonList.get(9).getDest_ne_ip()))) != null) {
                return tmp;
            } else if ((tmp = networkElementMap.get(IPv6Standardization.standard(ip = dataCommonList.get(11).getDest_ne_ip()))) != null) {
                return tmp;
            } else if ((tmp = networkElementMap.get(IPv6Standardization.standard(ip = dataCommonList.get(13).getDest_ne_ip()))) != null) {
                return tmp;
            } else if ((tmp = networkElementMap.get(IPv6Standardization.standard(ip = dataCommonList.get(15).getDest_ne_ip()))) != null) {
                return tmp;
            } else if ((tmp = networkElementMap.get(IPv6Standardization.standard(ip = dataCommonList.get(17).getDest_ne_ip()))) != null) {
                return tmp;
            }
        } catch (Exception e) {
            logProcessing("getS_CSCF_O exception: {}.", e.getMessage());
        }
        return ip;
    }

    public String getSCC_AS_O() {
        String ip = null;
        String net;
        try {
            ip = dataCommonList.get(2).getDest_ne_ip();
            net = networkElementMap.get(IPv6Standardization.standard(ip));
            if (net.length() > 0) {
                return net;
            }
        } catch (Exception e) {
            logProcessing("getSCC_AS_O exception: {}.", e.getMessage());
        }
        return ip;
    }

    public String getTAS_O() {
        String ip = null;
        String net;
        try {
            ip = dataCommonList.get(4).getDest_ne_ip();
            net = networkElementMap.get(IPv6Standardization.standard(ip));
            if (net.length() > 0) {
                return net;
            }
        } catch (Exception e) {
            logProcessing("getTAS_O exception: {}.", e.getMessage());
        }
        return ip;
    }

    public String getSCP_AS_VPMN_O() {
        String ip = null;
        String net;
        try {
            ip = dataCommonList.get(6).getDest_ne_ip();
            net = networkElementMap.get(IPv6Standardization.standard(ip));
            if (net.length() > 0) {
                return net;
            }
        } catch (Exception e) {
            logProcessing("getSCP_AS_VPMN_O exception: {}.", e.getMessage());
        }
        return ip;
    }

    public String getSCP_AS_VPMN_QK_O() {
        String ip = null;
        String net;
        try {
            ip = dataCommonList.get(8).getDest_ne_ip();
            net = networkElementMap.get(IPv6Standardization.standard(ip));
            if (net.length() > 0) {
                return net;
            }
        } catch (Exception e) {
            logProcessing("getSCP_AS_VPMN_QK_O exception: {}.", e.getMessage());
        }
        return ip;
    }

    public String getSCP_AS_QK_O() {
        String ip = null;
        String net;
        try {
            ip = dataCommonList.get(10).getDest_ne_ip();
            net = networkElementMap.get(IPv6Standardization.standard(ip));
            if (net.length() > 0) {
                return net;
            }
        } catch (Exception e) {
            logProcessing("getSCP_AS_QK_O exception: {}.", e.getMessage());
        }
        return ip;
    }

    public String getSCIM_AS_O() {
        String ip = null;
        String net;
        try {
            ip = dataCommonList.get(12).getDest_ne_ip();
            net = networkElementMap.get(IPv6Standardization.standard(ip));
            if (net.length() > 0) {
                return net;
            }
        } catch (Exception e) {
            logProcessing("getSCIM_AS_O exception: {}.", e.getMessage());
        }
        return ip;
    }

    public String getCY_AS_O() {
        String ip = null;
        String net;
        try {
            ip = dataCommonList.get(14).getDest_ne_ip();
            net = networkElementMap.get(IPv6Standardization.standard(ip));
            if (net.length() > 0) {
                return net;
            }
        } catch (Exception e) {
            logProcessing("getCY_AS_O exception: {}.", e.getMessage());
        }
        return ip;
    }

    public String getReserved_AS_O() {
        String ip = null;
        String net;
        try {
            ip = dataCommonList.get(16).getDest_ne_ip();
            net = networkElementMap.get(IPv6Standardization.standard(ip));
            if (net.length() > 0) {
                return net;
            }
        } catch (Exception e) {
            logProcessing("getReserved_AS_O exception: {}.", e.getMessage());
        }
        return ip;
    }

    public String getI_CSCF_T() {
        String ip = null;
        String net;
        try {
            ip = dataCommonList.get(18).getDest_ne_ip();
            net = networkElementMap.get(IPv6Standardization.standard(ip));
            if (net.length() > 0) {
                return net;
            }
        } catch (Exception e) {
            logProcessing("getI_CSCF_T exception: {}.", e.getMessage());
        }
        return ip;
    }

    public String getS_CSCF_T() {
        String tmp = null;
        String ip = null;
        try {
            if ((tmp = networkElementMap.get(IPv6Standardization.standard(ip = dataCommonList.get(19).getDest_ne_ip()))) != null) {
                return tmp;
            } else if ((tmp = networkElementMap.get(IPv6Standardization.standard(ip = dataCommonList.get(21).getDest_ne_ip()))) != null) {
                return tmp;
            } else if ((tmp = networkElementMap.get(IPv6Standardization.standard(ip = dataCommonList.get(23).getDest_ne_ip()))) != null) {
                return tmp;
            } else if ((tmp = networkElementMap.get(IPv6Standardization.standard(ip = dataCommonList.get(25).getDest_ne_ip()))) != null) {
                return tmp;
            } else if ((tmp = networkElementMap.get(IPv6Standardization.standard(ip = dataCommonList.get(27).getDest_ne_ip()))) != null) {
                return tmp;
            } else if ((tmp = networkElementMap.get(IPv6Standardization.standard(ip = dataCommonList.get(29).getDest_ne_ip()))) != null) {
                return tmp;
            } else if ((tmp = networkElementMap.get(IPv6Standardization.standard(ip = dataCommonList.get(31).getDest_ne_ip()))) != null) {
                return tmp;
            } else if ((tmp = networkElementMap.get(IPv6Standardization.standard(ip = dataCommonList.get(33).getDest_ne_ip()))) != null) {
                return tmp;
            } else if ((tmp = networkElementMap.get(IPv6Standardization.standard(ip = dataCommonList.get(35).getDest_ne_ip()))) != null) {
                return tmp;
            } else if ((tmp = networkElementMap.get(IPv6Standardization.standard(ip = dataCommonList.get(37).getDest_ne_ip()))) != null) {
                return tmp;
            } else if ((tmp = networkElementMap.get(IPv6Standardization.standard(ip = dataCommonList.get(39).getDest_ne_ip()))) != null) {
                return tmp;
            } else if ((tmp = networkElementMap.get(IPv6Standardization.standard(ip = dataCommonList.get(41).getDest_ne_ip()))) != null) {
                return tmp;
            } else if ((tmp = networkElementMap.get(IPv6Standardization.standard(ip = dataCommonList.get(43).getDest_ne_ip()))) != null) {
                return tmp;
            }
        } catch (Exception e) {
            logProcessing("getS_CSCF_T exception: {}.", e.getMessage());
        }
        return ip;
    }

    public String getSCP_AS_VPMN_T() {
        String ip = null;
        String net;
        try {
            ip = dataCommonList.get(20).getDest_ne_ip();
            net = networkElementMap.get(IPv6Standardization.standard(ip));
            if (net.length() > 0) {
                return net;
            }
        } catch (Exception e) {
            logProcessing("getSCP_AS_VPMN_T exception: {}.", e.getMessage());
        }
        return ip;
    }

    public String getSCP_AS_VPMN_QK_T() {
        String ip = null;
        String net;
        try {
            ip = dataCommonList.get(22).getDest_ne_ip();
            net = networkElementMap.get(IPv6Standardization.standard(ip));
            if (net.length() > 0) {
                return net;
            }
        } catch (Exception e) {
            logProcessing("getSCP_AS_VPMN_QK_T exception: {}.", e.getMessage());
        }
        return ip;
    }

    public String getSCP_AS_QK_T() {
        String ip = null;
        String net;
        try {
            ip = dataCommonList.get(24).getDest_ne_ip();
            net = networkElementMap.get(IPv6Standardization.standard(ip));
            if (net.length() > 0) {
                return net;
            }
        } catch (Exception e) {
            logProcessing("getSCP_AS_QK_T exception: {}.", e.getMessage());
        }
        return ip;
    }

    public String getSCIM_AS_T() {
        String ip = null;
        String net;
        try {
            ip = dataCommonList.get(26).getDest_ne_ip();
            net = networkElementMap.get(IPv6Standardization.standard(ip));
            if (net.length() > 0) {
                return net;
            }
        } catch (Exception e) {
            logProcessing("getSCIM_AS_T exception: {}.", e.getMessage());
        }
        return ip;
    }

    public String getTAS_T() {
        String ip = null;
        String net;
        try {
            ip = dataCommonList.get(28).getDest_ne_ip();
            net = networkElementMap.get(IPv6Standardization.standard(ip));
            if (net.length() > 0) {
                return net;
            }
        } catch (Exception e) {
            logProcessing("getTAS_T exception: {}.", e.getMessage());
        }
        return ip;
    }

    public String getCAT_A_AS_T() {
        String ip = null;
        String net;
        try {
            ip = dataCommonList.get(30).getDest_ne_ip();
            net = networkElementMap.get(IPv6Standardization.standard(ip));
            if (net.length() > 0) {
                return net;
            }
        } catch (Exception e) {
            logProcessing("getCAT_A_AS_T exception: {}.", e.getMessage());
        }
        return ip;
    }

    public String getCAT_V_AS_T() {
        String ip = null;
        String net;
        try {
            ip = dataCommonList.get(32).getDest_ne_ip();
            net = networkElementMap.get(IPv6Standardization.standard(ip));
            if (net.length() > 0) {
                return net;
            }
        } catch (Exception e) {
            logProcessing("getCAT_V_AS_T exception: {}.", e.getMessage());
        }
        return ip;
    }

    public String getCY_AS_T() {
        String ip = null;
        String net;
        try {
            ip = dataCommonList.get(34).getDest_ne_ip();
            net = networkElementMap.get(IPv6Standardization.standard(ip));
            if (net.length() > 0) {
                return net;
            }
        } catch (Exception e) {
            logProcessing("getCY_AS_T exception: {}.", e.getMessage());
        }
        return ip;
    }

    public String getSCC_AS_T() {
        String ip = null;
        String net;
        try {
            ip = dataCommonList.get(36).getDest_ne_ip();
            net = networkElementMap.get(IPv6Standardization.standard(ip));
            if (net.length() > 0) {
                return net;
            }
        } catch (Exception e) {
            logProcessing("getSCC_AS_T exception: {}.", e.getMessage());
        }
        return ip;
    }

    public String getGH_AS_T() {
        String ip = null;
        String net;
        try {
            ip = dataCommonList.get(38).getDest_ne_ip();
            net = networkElementMap.get(IPv6Standardization.standard(ip));
            if (net.length() > 0) {
                return net;
            }
        } catch (Exception e) {
            logProcessing("getGH_AS_T exception: {}.", e.getMessage());
        }
        return ip;
    }

    public String getIP_SM_GW() {
        String ip = null;
        String net;
        try {
            ip = dataCommonList.get(40).getDest_ne_ip();
            net = networkElementMap.get(IPv6Standardization.standard(ip));
            if (net.length() > 0) {
                return net;
            }
        } catch (Exception e) {
            logProcessing("getIP_SM_GW exception: {}.", e.getMessage());
        }
        return ip;
    }

    public String getReserved_AS_T() {
        String ip = null;
        String net;
        try {
            ip = dataCommonList.get(42).getDest_ne_ip();
            net = networkElementMap.get(IPv6Standardization.standard(ip));
            if (net.length() > 0) {
                return net;
            }
        } catch (Exception e) {
            logProcessing("getReserved_AS_T exception: {}.", e.getMessage());
        }
        return ip;
    }

    public String getSBC_T() {
        String ip = null;
        String net;
        try {
            ip = dataCommonList.get(44).getDest_ne_ip();
            net = networkElementMap.get(IPv6Standardization.standard(ip));
            if (net.length() > 0) {
                return net;
            }
        } catch (Exception e) {
            logProcessing("getSBC_T exception: {}.", e.getMessage());
        }
        return ip;
    }

    public String getHSS_CX() {
        String ip = null;
        String net;
        try {
            ip = dataCommonList.get(46).getDest_ne_ip();
            if ((net = networkElementMap.get(IPv6Standardization.standard(ip))) != null) {
                return net;
            }
        } catch (Exception e) {
            logProcessing("getHSS_CX exception: {}.", e.getMessage());
        }
        return ip;
    }

    public String getPCRF_O() {
        String tmp;
        String ip = null;
        try {
            if ((tmp = (dataCommonList.get(47).getDest_ne_ip()).split("\\.")[0]) != null) {
                return tmp;
            } else if ((tmp = (dataCommonList.get(48).getDest_ne_ip()).split("\\.")[0]) != null) {
                return tmp;
            }
        } catch (Exception e) {
            logProcessing("getPCRF_O exception: {}.", e.getMessage());
        }
        return ip;
    }

    public String getPCRF_T() {
        String tmp;
        String ip = null;
        try {
            if ((tmp = (dataCommonList.get(49).getDest_ne_ip()).split("\\.")[0]) != null) {
                return tmp;
            } else if ((tmp = (dataCommonList.get(50).getDest_ne_ip()).split("\\.")[0]) != null) {
                return tmp;
            }
        } catch (Exception e) {
            logProcessing("getPCRF_T exception: {}.", e.getMessage());
        }
        return ip;
    }

    public String getHSS_SH() {
        String tmp = null;
        String ip = null;
        try {
            if ((tmp = networkElementMap.get(IPv6Standardization.standard(ip = dataCommonList.get(51).getDest_ne_ip()))) != null) {
                return tmp;
            } else if ((tmp = networkElementMap.get(IPv6Standardization.standard(ip = dataCommonList.get(52).getDest_ne_ip()))) != null) {
                return tmp;
            }
        } catch (Exception e) {
            logProcessing("getHSS_SH exception: {}.", e.getMessage());
        }
        return ip;
    }

    public String getMGCF_MJ_O() {
        String ip = null;
        String net;
        try {
            ip = dataCommonList.get(53).getDest_ne_ip();
            if ((net = networkElementMap.get(IPv6Standardization.standard(ip))) != null) {
                return net;
            }
        } catch (Exception e) {
            logProcessing("getMGCF_MJ_O exception: {}.", e.getMessage());
        }
        return ip;
    }

    public String getMGCF_MJ_T() {
        String ip = null;
        String net;
        try {
            ip = dataCommonList.get(54).getDest_ne_ip();
            if ((net = networkElementMap.get(IPv6Standardization.standard(ip))) != null) {
                return net;
            }
        } catch (Exception e) {
            logProcessing("getMGCF_MJ_T exception: {}.", e.getMessage());
        }
        return ip;
    }

    public String getNC_OUT() {
        String ip = null;
        String net;
        try {
            ip = dataCommonList.get(56).getDest_ne_ip();
            if ((net = networkElementMap.get(IPv6Standardization.standard(ip))) != null) {
                return net;
            }
        } catch (Exception e) {
            logProcessing("getNC_OUT exception: {}.", e.getMessage());
        }
        return ip;
    }

    public String getNC_IN() {
        String ip = null;
        String net;
        try {
            ip = dataCommonList.get(55).getDest_ne_ip();
            if ((net = networkElementMap.get(IPv6Standardization.standard(ip))) != null) {
                return net;
            }
        } catch (Exception e) {
            logProcessing("getNC_IN exception: {}.", e.getMessage());
        }
        return ip;
    }

    public String getMGCF_MG() {
        String ip = null;
        String net;
        try {
            ip = dataCommonList.get(57).getDest_ne_ip();
            if ((net = networkElementMap.get(IPv6Standardization.standard(ip))) != null) {
                return net;
            }
        } catch (Exception e) {
            logProcessing("getMGCF_MG exception: {}.", e.getMessage());
        }
        return ip;
    }

    public int getScenario_id() {
        try {
            return mergedXDR.getScenario_id();
        } catch (Exception e) {
            logProcessing("getScenario_id exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getCi() {
        try {
            int Time_O_Gm = this.voLTE.getTime_O_Gm();
            int Time_O_Mw_P2S = this.voLTE.getTime_O_Mw_P2S();
            if (Time_O_Gm <= 0 || Time_O_Mw_P2S <= 0)
                throw new Exception("data content exception");
            return Time_O_Gm - Time_O_Mw_P2S;
        } catch (Exception e) {
            logProcessing("getCi exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getSEG_O_MW_O_ISC11() {
        try {
            int Time_O_Mw_P2S = this.voLTE.getTime_O_Mw_P2S();
            int Time_O_ISC11 = this.voLTE.getTime_O_ISC11();
            if (Time_O_Mw_P2S <= 0 || Time_O_ISC11 <= 0)
                throw new Exception("data content exception");
            return Time_O_Mw_P2S - Time_O_ISC11;
        } catch (Exception e) {
            logProcessing("getSEG_O_MW_O_ISC11 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getSEG_O_ISC11_O_ISC12() {
        try {
            int Time_O_ISC11 = this.voLTE.getTime_O_ISC11();
            int Time_O_ISC12 = this.voLTE.getTime_O_ISC12();
            if (Time_O_ISC11 <= 0 || Time_O_ISC12 <= 0)
                throw new Exception("data content exception");
            return Time_O_ISC11 - Time_O_ISC12;
        } catch (Exception e) {
            logProcessing("getSEG_O_ISC11_O_ISC12 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getSEG_O_ISC21_O_ISC22() {
        try {
            int Time_O_ISC21 = this.voLTE.getTime_O_ISC21();
            int Time_O_ISC22 = this.voLTE.getTime_O_ISC22();
            if (Time_O_ISC21 <= 0 || Time_O_ISC22 <= 0)
                throw new Exception("data content exception");
            return Time_O_ISC21 - Time_O_ISC22;
        } catch (Exception e) {
            logProcessing("getSEG_O_ISC21_O_ISC22 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getSEG_O_ISC31_O_ISC62() {
        int result = 0;
        try {
            if (this.voLTE.getTime_O_ISC62() > 0 && this.voLTE.getTime_O_ISC61() > 0) {
                result = this.voLTE.getTime_O_ISC61() - this.voLTE.getTime_O_ISC62();
            } else {
                if (this.voLTE.getTime_O_ISC31() > 0) {
                    if (this.voLTE.getTime_O_ISC42() > 0) {
                        result = this.voLTE.getTime_O_ISC31() - this.voLTE.getTime_O_ISC42();
                    } else if (this.voLTE.getTime_O_ISC32() > 0) {
                        result = this.voLTE.getTime_O_ISC31() - this.voLTE.getTime_O_ISC32();
                    }
                } else if (this.voLTE.getTime_O_ISC51() > 0) {
                    if (this.voLTE.getTime_O_ISC42() > 0) {
                        result = this.voLTE.getTime_O_ISC51() - this.voLTE.getTime_O_ISC42();
                    } else if (this.voLTE.getTime_O_ISC52() > 0) {
                        result = this.voLTE.getTime_O_ISC51() - this.voLTE.getTime_O_ISC52();
                    }
                }
            }
            return result;
        } catch (Exception e) {
            logProcessing("getSEG_O_ISC31_O_ISC62 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }

    }

    public int getSEG_O_ISC91_O_ISC92() {
        try {
            int Time_O_ISC91 = this.voLTE.getTime_O_ISC91();
            int Time_O_ISC92 = this.voLTE.getTime_O_ISC92();
            if (Time_O_ISC91 <= 0 || Time_O_ISC92 <= 0)
                throw new Exception("data content exception");
            return Time_O_ISC91 - Time_O_ISC92;
        } catch (Exception e) {
            logProcessing("getSEG_O_ISC91_O_ISC92 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getSEG_T_MW_T_ISC31() {
        try {
            int Time_TI2TS_Mw = this.voLTE.getTime_TI2TS_Mw();
            int Time_T_ISC31 = this.voLTE.getTime_T_ISC31();
            if (Time_TI2TS_Mw <= 0 || Time_T_ISC31 <= 0)
                throw new Exception("data content exception");
            return Time_TI2TS_Mw - Time_T_ISC31;
        } catch (Exception e) {
            logProcessing("getSEG_T_MW_T_ISC31 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getSEG_T_ISC31_T_ISC62() {
        int result = 0;
        try {
            if (this.voLTE.getTime_T_ISC62() > 0 && this.voLTE.getTime_T_ISC61() > 0) {
                result = this.voLTE.getTime_T_ISC61() - this.voLTE.getTime_T_ISC62();
            } else {
                if (this.voLTE.getTime_T_ISC31() > 0) {
                    if (this.voLTE.getTime_T_ISC42() > 0) {
                        result = this.voLTE.getTime_T_ISC31() - this.voLTE.getTime_T_ISC42();
                    } else if (this.voLTE.getTime_T_ISC32() > 0) {
                        result = this.voLTE.getTime_T_ISC31() - this.voLTE.getTime_T_ISC32();
                    }
                } else if (this.voLTE.getTime_T_ISC51() > 0) {
                    if (this.voLTE.getTime_T_ISC42() > 0) {
                        result = this.voLTE.getTime_T_ISC51() - this.voLTE.getTime_T_ISC42();
                    } else if (this.voLTE.getTime_T_ISC52() > 0) {
                        result = this.voLTE.getTime_T_ISC51() - this.voLTE.getTime_T_ISC52();
                    }
                }
            }
            return result;
        } catch (Exception e) {
            logProcessing("getSEG_T_ISC31_T_ISC62 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getSEG_T_ISC21_T_ISC22() {
        try {
            int Time_T_ISC21 = this.voLTE.getTime_T_ISC21();
            int Time_T_ISC22 = this.voLTE.getTime_T_ISC22();
            if (Time_T_ISC21 <= 0 || Time_T_ISC22 <= 0)
                throw new Exception("data content exception");
            return Time_T_ISC21 - Time_T_ISC22;
        } catch (Exception e) {
            logProcessing("getSEG_T_ISC21_T_ISC22 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getSEG_T_ISC71_T_ISC72() {
        try {
            int Time_T_ISC71 = this.voLTE.getTime_T_ISC71();
            int Time_T_ISC72 = this.getTime_T_ISC72();
            if (Time_T_ISC71 <= 0 || Time_T_ISC72 <= 0)
                throw new Exception("data content exception");
            return Time_T_ISC71 - Time_T_ISC72;
        } catch (Exception e) {
            logProcessing("getSEG_T_ISC71_T_ISC72 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getSEG_T_ISC81_T_ISC82() {
        try {
            int Time_T_ISC81 = this.voLTE.getTime_T_ISC81();
            int Time_T_ISC82 = this.voLTE.getTime_T_ISC82();
            if (Time_T_ISC81 <= 0 || Time_T_ISC82 <= 0)
                throw new Exception("data content exception");
            return Time_T_ISC81 - Time_T_ISC82;
        } catch (Exception e) {
            logProcessing("getSEG_T_ISC81_T_ISC82 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getSEG_T_ISC91_T_ISC92() {
        try {
            int Time_T_ISC91 = this.voLTE.getTime_T_ISC91();
            int Time_T_ISC92 = this.voLTE.getTime_T_ISC92();
            if (Time_T_ISC91 <= 0 || Time_T_ISC92 <= 0)
                throw new Exception("data content exception");
            return Time_T_ISC91 - Time_T_ISC92;
        } catch (Exception e) {
            logProcessing("getSEG_T_ISC91_T_ISC92 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getSEG_T_ISC11_T_ISC12() {
        try {
            int Time_T_ISC11 = this.voLTE.getTime_T_ISC11();
            int Time_T_ISC12 = this.voLTE.getTime_T_ISC12();
            if (Time_T_ISC11 <= 0 || Time_T_ISC12 <= 0)
                throw new Exception("data content exception");
            return Time_T_ISC11 - Time_T_ISC12;
        } catch (Exception e) {
            logProcessing("getSEG_T_ISC11_T_ISC12 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getSEG_T_ISC111_T_ISC112() {
        try {
            int Time_T_ISC111 = this.voLTE.getTime_T_ISC111();
            int Time_T_ISC112 = this.voLTE.getTime_T_ISC112();
            if (Time_T_ISC111 <= 0 || Time_T_ISC112 <= 0)
                throw new Exception("data content exception");
            return Time_T_ISC111 - Time_T_ISC112;
        } catch (Exception e) {
            logProcessing("getSEG_T_ISC111_T_ISC112 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getSEG_T_MW_T_GM() {
        try {
            int Time_T_Mw_S2P = this.voLTE.getTime_T_Mw_S2P();
            int Time_T_Gm = this.voLTE.getTime_T_Gm();
            if (Time_T_Mw_S2P <= 0 || Time_T_Gm <= 0)
                throw new Exception("data content exception");
            return Time_T_Mw_S2P - Time_T_Gm;
        } catch (Exception e) {
            logProcessing("getSEG_T_MW_T_GM exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public long getSEG_T_NC_T_MG() {
        try {
            long Time_Nc_In = this.voLTE.getTime_Nc_In();
            long Time_T_Mg = this.voLTE.getTime_T_Mg();
            if (Time_Nc_In <= 0 || Time_T_Mg <= 0)
                throw new Exception("data content exception");
            return Time_Nc_In - Time_T_Mg;
        } catch (Exception e) {
            logProcessing("getSEG_T_NC_T_MG exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getSEG_T_MG_T_ISC31() {
        int result = 0;
        try {
            if (this.voLTE.getTime_T_Mg() > 0) {
                if (this.voLTE.getTime_T_ISC31() > 0) {
                    result = this.voLTE.getTime_T_Mg() - this.voLTE.getTime_T_ISC31();
                } else if (this.voLTE.getTime_T_ISC51() > 0) {
                    result = this.voLTE.getTime_T_Mg() - this.voLTE.getTime_T_ISC51();
                }
            }
            return result;
        } catch (Exception e) {
            logProcessing("getSEG_T_MG_T_ISC31 exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getSEG_T_ISC12_T_MJ() {
        try {
            int Time_T_ISC12 = this.voLTE.getTime_T_ISC12();
            int Time_T_Mj = this.voLTE.getTime_T_Mj();
            if (Time_T_ISC12 <= 0 || Time_T_Mj <= 0)
                throw new Exception("data content exception");
            return Time_T_ISC12 - Time_T_Mj;
        } catch (Exception e) {
            logProcessing("getSEG_T_ISC12_T_MJ exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public long getSEG_O_MJ_O_NC() {
        try {
            long Time_O_Mj = this.voLTE.getTime_O_Mj();
            long Time_Nc_Out = this.getTime_Nc_Out();
            if (Time_O_Mj <= 0 || Time_Nc_Out <= 0)
                throw new Exception("data content exception");
            return Time_O_Mj - Time_Nc_Out;
        } catch (Exception e) {
            logProcessing("getSEG_O_MJ_O_NC exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public long getSEG_T_MJ_T_NC() {
        try {
            long Time_T_Mj = this.voLTE.getTime_T_Mj();
            long Time_Nc_Out = this.voLTE.getTime_Nc_Out();
            if (Time_T_Mj <= 0 || Time_Nc_Out <= 0)
                throw new Exception("data content exception");
            return Time_T_Mj - Time_Nc_Out;
        } catch (Exception e) {
            logProcessing("getSEG_T_MJ_T_NC exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getSEG_O_GM_ALL() {
        try {
            return this.voLTE.getTime_O_Gm();
        } catch (Exception e) {
            logProcessing("getSEG_O_GM_ALL exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getSEG_CX() {
        try {
            return this.voLTE.getTime_T_Cx_LIR();
        } catch (Exception e) {
            logProcessing("getSEG_CX exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getSEG_SH() {
        try {
            return this.voLTE.getTime_T_Sh_UDR();
        } catch (Exception e) {
            logProcessing("getSEG_SH exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getSEG_RX_O() {
        try {
            return this.voLTE.getTime_O_Rx_AAR();
        } catch (Exception e) {
            logProcessing("getSEG_RX_O exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getSEG_RX_T() {
        try {
            return this.voLTE.getTime_T_Rx_AAR();
        } catch (Exception e) {
            logProcessing("getSEG_RX_T exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

    public int getSEG_O_MW_T_MW() {
        try {
            int Time_OS2TI_Mw = this.voLTE.getTime_OS2TI_Mw();
            int Time_TI2TS_Mw = this.voLTE.getTime_TI2TS_Mw();
            if (Time_OS2TI_Mw <= 0 || Time_TI2TS_Mw <= 0)
                throw new Exception("data content exception");
            return Time_OS2TI_Mw - Time_TI2TS_Mw;
        } catch (Exception e) {
            logProcessing("getSEG_O_MW_T_MW exception: {}.", e.getMessage());
            return FALSE_CODE;
        }
    }

}
