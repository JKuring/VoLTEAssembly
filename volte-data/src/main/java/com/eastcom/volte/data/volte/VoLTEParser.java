package com.eastcom.volte.data.volte;

import com.eastcom.volte.data.DataParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by linghang.kong on 2016/8/29.
 */
public class VoLTEParser extends DataParser<VoLTE> {

    private static Logger logger = LoggerFactory.getLogger(VoLTEParser.class);

    @Override
    public VoLTE parse(List<String> dataList) throws Exception {
        try {
            VoLTE voLTE = new VoLTE();
            voLTE.setLength(Integer.parseInt(dataList.get(0)));
            voLTE.setCity(dataList.get(1));
            voLTE.setInterface(Integer.parseInt(dataList.get(2)));
            voLTE.setXdr_id(dataList.get(3));
            voLTE.setRat(Integer.parseInt(dataList.get(4)));
            voLTE.setStart_time(Long.parseLong(dataList.get(5)));
            voLTE.setEnd_time(Long.parseLong(dataList.get(6)));
            voLTE.setImsi_caller(dataList.get(7));
            voLTE.setImei_caller(dataList.get(8));
            voLTE.setMsisdn_caller(dataList.get(9));
            voLTE.setCell_caller(dataList.get(10));
            voLTE.setTac_caller(dataList.get(11));
            voLTE.setImsi_callee(dataList.get(12));
            voLTE.setImei_callee(dataList.get(13));
            voLTE.setMsisdn_callee(dataList.get(14));
            voLTE.setCell_callee(dataList.get(15));
            voLTE.setTac_callee(dataList.get(16));
            voLTE.setXdr_number(Integer.parseInt(dataList.get(17)));
            voLTE.setTime_O_Gm(Integer.parseInt(dataList.get(18)));
            voLTE.setTime_O_Mw_P2S(Integer.parseInt(dataList.get(19)));
            voLTE.setTime_O_ISC11(Integer.parseInt(dataList.get(20)));
            voLTE.setTime_O_ISC12(Integer.parseInt(dataList.get(21)));
            voLTE.setTime_O_ISC21(Integer.parseInt(dataList.get(22)));
            voLTE.setTime_O_ISC22(Integer.parseInt(dataList.get(23)));
            voLTE.setTime_O_ISC31(Integer.parseInt(dataList.get(24)));
            voLTE.setTime_O_ISC32(Integer.parseInt(dataList.get(25)));
            voLTE.setTime_O_ISC51(Integer.parseInt(dataList.get(26)));
            voLTE.setTime_O_ISC52(Integer.parseInt(dataList.get(27)));
            voLTE.setTime_O_ISC41(Integer.parseInt(dataList.get(28)));
            voLTE.setTime_O_ISC42(Integer.parseInt(dataList.get(29)));
            voLTE.setTime_O_ISC61(Integer.parseInt(dataList.get(30)));
            voLTE.setTime_O_ISC62(Integer.parseInt(dataList.get(31)));
            voLTE.setTime_O_ISC91(Integer.parseInt(dataList.get(32)));
            voLTE.setTime_O_ISC92(Integer.parseInt(dataList.get(33)));
            voLTE.setTime_O_ISC121(Integer.parseInt(dataList.get(34)));
            voLTE.setTime_O_ISC122(Integer.parseInt(dataList.get(35)));
            voLTE.setTime_OS2TI_Mw(Integer.parseInt(dataList.get(36)));
            voLTE.setTime_TI2TS_Mw(Integer.parseInt(dataList.get(37)));
            voLTE.setTime_T_ISC31(Integer.parseInt(dataList.get(38)));
            voLTE.setTime_T_ISC32(Integer.parseInt(dataList.get(39)));
            voLTE.setTime_T_ISC51(Integer.parseInt(dataList.get(40)));
            voLTE.setTime_T_ISC52(Integer.parseInt(dataList.get(41)));
            voLTE.setTime_T_ISC41(Integer.parseInt(dataList.get(42)));
            voLTE.setTime_T_ISC42(Integer.parseInt(dataList.get(43)));
            voLTE.setTime_T_ISC61(Integer.parseInt(dataList.get(44)));
            voLTE.setTime_T_ISC62(Integer.parseInt(dataList.get(45)));
            voLTE.setTime_T_ISC21(Integer.parseInt(dataList.get(46)));
            voLTE.setTime_T_ISC22(Integer.parseInt(dataList.get(47)));
            voLTE.setTime_T_ISC71(Integer.parseInt(dataList.get(48)));
            voLTE.setTime_T_ISC72(Integer.parseInt(dataList.get(49)));
            voLTE.setTime_T_ISC81(Integer.parseInt(dataList.get(50)));
            voLTE.setTime_T_ISC82(Integer.parseInt(dataList.get(51)));
            voLTE.setTime_T_ISC91(Integer.parseInt(dataList.get(52)));
            voLTE.setTime_T_ISC92(Integer.parseInt(dataList.get(53)));
            voLTE.setTime_T_ISC11(Integer.parseInt(dataList.get(54)));
            voLTE.setTime_T_ISC12(Integer.parseInt(dataList.get(55)));
            voLTE.setTime_T_ISC111(Integer.parseInt(dataList.get(56)));
            voLTE.setTime_T_ISC112(Integer.parseInt(dataList.get(57)));
            voLTE.setTime_T_ISC101(Integer.parseInt(dataList.get(58)));
            voLTE.setTime_T_ISC102(Integer.parseInt(dataList.get(59)));
            voLTE.setTime_T_ISC131(Integer.parseInt(dataList.get(60)));
            voLTE.setTime_T_ISC132(Integer.parseInt(dataList.get(61)));
            voLTE.setTime_T_Mw_S2P(Integer.parseInt(dataList.get(62)));
            voLTE.setTime_T_Gm(Integer.parseInt(dataList.get(63)));
            voLTE.setTime_T_Cx_LIR(Integer.parseInt(dataList.get(64)));
            voLTE.setTime_O_Rx_AAR(Integer.parseInt(dataList.get(65)));
            voLTE.setTime_O_Rx_Reserved(Integer.parseInt(dataList.get(66)));
            voLTE.setTime_T_Rx_AAR(Integer.parseInt(dataList.get(67)));
            voLTE.setTime_T_Rx_Reserved(Integer.parseInt(dataList.get(68)));
            voLTE.setTime_T_Sh_UDR(Integer.parseInt(dataList.get(69)));
            voLTE.setTime_T_Sh_Reserved(Integer.parseInt(dataList.get(70)));
            voLTE.setTime_O_Mj(Integer.parseInt(dataList.get(71)));
            voLTE.setTime_T_Mj(Integer.parseInt(dataList.get(72)));
            voLTE.setTime_Nc_In(Integer.parseInt(dataList.get(73)));
            voLTE.setTime_Nc_Out(Integer.parseInt(dataList.get(74)));
            voLTE.setTime_T_Mg(Integer.parseInt(dataList.get(75)));
            voLTE.setSBC_O(dataList.get(76));
            voLTE.setS_CSCF_O(dataList.get(77));
            voLTE.setSCC_AS_O(dataList.get(78));
            voLTE.setTAS_O(dataList.get(79));
            voLTE.setSCP_AS_VPMN_O(dataList.get(80));
            voLTE.setSCP_AS_VPMN_QK_O(dataList.get(81));
            voLTE.setSCP_AS_QK_O(dataList.get(82));
            voLTE.setSCIM_AS_O(dataList.get(83));
            voLTE.setCY_AS_O(dataList.get(84));
            voLTE.setReserved_AS_O(dataList.get(85));
            voLTE.setI_CSCF_T(dataList.get(86));
            voLTE.setS_CSCF_T(dataList.get(87));
            voLTE.setSCP_AS_VPMN_T(dataList.get(88));
            voLTE.setSCP_AS_VPMN_QK_T(dataList.get(89));
            voLTE.setSCP_AS_QK_T(dataList.get(90));
            voLTE.setSCIM_AS_T(dataList.get(91));
            voLTE.setTAS_T(dataList.get(92));
            voLTE.setCAT_A_AS_T(dataList.get(93));
            voLTE.setCAT_V_AS_T(dataList.get(94));
            voLTE.setCY_AS_T(dataList.get(95));
            voLTE.setSCC_AS_T(dataList.get(96));
            voLTE.setGH_AS_T(dataList.get(97));
            voLTE.setIP_SM_GW(dataList.get(98));
            voLTE.setReserved_AS_T(dataList.get(99));
            voLTE.setSBC_T(dataList.get(100));
            voLTE.setHSS_CX(dataList.get(101));
            voLTE.setPCRF_O(dataList.get(102));
            voLTE.setPCRF_T(dataList.get(103));
            voLTE.setHSS_SH(dataList.get(104));
            voLTE.setMGCF_MJ_O(dataList.get(105));
            voLTE.setMGCF_MJ_T(dataList.get(106));
            voLTE.setNC_OUT(dataList.get(107));
            voLTE.setNC_IN(dataList.get(108));
            voLTE.setMGCF_MG(dataList.get(109));
            voLTE.setScenario_id(Integer.parseInt(dataList.get(110)));
            voLTE.setCi(Integer.parseInt(dataList.get(111)));
            voLTE.setSEG_O_MW_O_ISC11(Integer.parseInt(dataList.get(112)));
            voLTE.setSEG_O_ISC11_O_ISC12(Integer.parseInt(dataList.get(113)));
            voLTE.setSEG_O_ISC21_O_ISC22(Integer.parseInt(dataList.get(114)));
            voLTE.setSEG_O_ISC31_O_ISC62(Integer.parseInt(dataList.get(115)));
            voLTE.setSEG_O_ISC91_O_ISC92(Integer.parseInt(dataList.get(116)));
            voLTE.setSEG_T_MW_T_ISC31(Integer.parseInt(dataList.get(117)));
            voLTE.setSEG_T_ISC31_T_ISC62(Integer.parseInt(dataList.get(118)));
            voLTE.setSEG_T_ISC21_T_ISC22(Integer.parseInt(dataList.get(119)));
            voLTE.setSEG_T_ISC71_T_ISC72(Integer.parseInt(dataList.get(120)));
            voLTE.setSEG_T_ISC81_T_ISC82(Integer.parseInt(dataList.get(121)));
            voLTE.setSEG_T_ISC91_T_ISC92(Integer.parseInt(dataList.get(122)));
            voLTE.setSEG_T_ISC11_T_ISC12(Integer.parseInt(dataList.get(123)));
            voLTE.setSEG_T_ISC111_T_ISC112(Integer.parseInt(dataList.get(124)));
            voLTE.setSEG_T_MW_T_GM(Integer.parseInt(dataList.get(125)));
            voLTE.setSEG_T_NC_T_MG(Integer.parseInt(dataList.get(126)));
            voLTE.setSEG_T_MG_T_ISC31(Integer.parseInt(dataList.get(127)));
            voLTE.setSEG_T_ISC12_T_MJ(Integer.parseInt(dataList.get(128)));
            voLTE.setSEG_O_MJ_O_NC(Integer.parseInt(dataList.get(129)));
            voLTE.setSEG_T_MJ_T_NC(Integer.parseInt(dataList.get(130)));
            voLTE.setSEG_O_GM_ALL(Integer.parseInt(dataList.get(131)));
            voLTE.setSEG_CX(Integer.parseInt(dataList.get(132)));
            voLTE.setSEG_SH(Integer.parseInt(dataList.get(133)));
            voLTE.setSEG_RX_O(Integer.parseInt(dataList.get(134)));
            voLTE.setSEG_RX_T(Integer.parseInt(dataList.get(135)));
            voLTE.setSEG_O_MW_T_MW(Integer.parseInt(dataList.get(136)));

            return voLTE;
        } catch (Exception e) {
            logger.debug("data size: {}, need the most length: 136.", dataList.size());
            throw e;
        }
    }
}
