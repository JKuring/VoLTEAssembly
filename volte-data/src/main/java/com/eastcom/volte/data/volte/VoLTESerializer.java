package com.eastcom.volte.data.volte;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/**
 * Created by linghang.kong on 2016/8/29.
 */
public class VoLTESerializer extends Serializer<VoLTE> {
    @Override
    public void write(Kryo kryo, Output output, VoLTE voLTE) {
        output.writeInt(voLTE.getLength(), true);
        output.writeString(voLTE.getCity());
        output.writeInt(voLTE.getInterface(), true);
        output.writeString(voLTE.getXdr_id());
        output.writeInt(voLTE.getRat(), true);
        output.writeLong(voLTE.getStart_time(), true);
        output.writeLong(voLTE.getEnd_time(), true);
        output.writeString(voLTE.getImsi_caller());
        output.writeString(voLTE.getImei_caller());
        output.writeString(voLTE.getMsisdn_caller());
        output.writeString(voLTE.getCell_caller());
        output.writeString(voLTE.getTac_caller());
        output.writeString(voLTE.getImsi_callee());
        output.writeString(voLTE.getImei_callee());
        output.writeString(voLTE.getMsisdn_callee());
        output.writeString(voLTE.getCell_callee());
        output.writeString(voLTE.getTac_callee());
        output.writeInt(voLTE.getXdr_number(), true);
        output.writeInt(voLTE.getTime_O_Gm(), true);
        output.writeInt(voLTE.getTime_O_Mw_P2S(), true);
        output.writeInt(voLTE.getTime_O_ISC11(), true);
        output.writeInt(voLTE.getTime_O_ISC12(), true);
        output.writeInt(voLTE.getTime_O_ISC21(), true);
        output.writeInt(voLTE.getTime_O_ISC22(), true);
        output.writeInt(voLTE.getTime_O_ISC31(), true);
        output.writeInt(voLTE.getTime_O_ISC32(), true);
        output.writeInt(voLTE.getTime_O_ISC51(), true);
        output.writeInt(voLTE.getTime_O_ISC52(), true);
        output.writeInt(voLTE.getTime_O_ISC41(), true);
        output.writeInt(voLTE.getTime_O_ISC42(), true);
        output.writeInt(voLTE.getTime_O_ISC61(), true);
        output.writeInt(voLTE.getTime_O_ISC62(), true);
        output.writeInt(voLTE.getTime_O_ISC91(), true);
        output.writeInt(voLTE.getTime_O_ISC92(), true);
        output.writeInt(voLTE.getTime_O_ISC121(), true);
        output.writeInt(voLTE.getTime_O_ISC122(), true);
        output.writeInt(voLTE.getTime_OS2TI_Mw(), true);
        output.writeInt(voLTE.getTime_TI2TS_Mw(), true);
        output.writeInt(voLTE.getTime_T_ISC31(), true);
        output.writeInt(voLTE.getTime_T_ISC32(), true);
        output.writeInt(voLTE.getTime_T_ISC51(), true);
        output.writeInt(voLTE.getTime_T_ISC52(), true);
        output.writeInt(voLTE.getTime_T_ISC41(), true);
        output.writeInt(voLTE.getTime_T_ISC42(), true);
        output.writeInt(voLTE.getTime_T_ISC61(), true);
        output.writeInt(voLTE.getTime_T_ISC62(), true);
        output.writeInt(voLTE.getTime_T_ISC21(), true);
        output.writeInt(voLTE.getTime_T_ISC22(), true);
        output.writeInt(voLTE.getTime_T_ISC71(), true);
        output.writeInt(voLTE.getTime_T_ISC72(), true);
        output.writeInt(voLTE.getTime_T_ISC81(), true);
        output.writeInt(voLTE.getTime_T_ISC82(), true);
        output.writeInt(voLTE.getTime_T_ISC91(), true);
        output.writeInt(voLTE.getTime_T_ISC92(), true);
        output.writeInt(voLTE.getTime_T_ISC11(), true);
        output.writeInt(voLTE.getTime_T_ISC12(), true);
        output.writeInt(voLTE.getTime_T_ISC111(), true);
        output.writeInt(voLTE.getTime_T_ISC112(), true);
        output.writeInt(voLTE.getTime_T_ISC101(), true);
        output.writeInt(voLTE.getTime_T_ISC102(), true);
        output.writeInt(voLTE.getTime_T_ISC131(), true);
        output.writeInt(voLTE.getTime_T_ISC132(), true);
        output.writeInt(voLTE.getTime_T_Mw_S2P(), true);
        output.writeInt(voLTE.getTime_T_Gm(), true);
        output.writeInt(voLTE.getTime_T_Cx_LIR(), true);
        output.writeInt(voLTE.getTime_O_Rx_AAR(), true);
        output.writeInt(voLTE.getTime_O_Rx_Reserved(), true);
        output.writeInt(voLTE.getTime_T_Rx_AAR(), true);
        output.writeInt(voLTE.getTime_T_Rx_Reserved(), true);
        output.writeInt(voLTE.getTime_T_Sh_UDR(), true);
        output.writeInt(voLTE.getTime_T_Sh_Reserved(), true);
        output.writeInt(voLTE.getTime_O_Mj(), true);
        output.writeInt(voLTE.getTime_T_Mj(), true);
        output.writeLong(voLTE.getTime_Nc_In(), true);
        output.writeLong(voLTE.getTime_Nc_Out(), true);
        output.writeInt(voLTE.getTime_T_Mg(), true);
        output.writeString(voLTE.getSBC_O());
        output.writeString(voLTE.getS_CSCF_O());
        output.writeString(voLTE.getSCC_AS_O());
        output.writeString(voLTE.getTAS_O());
        output.writeString(voLTE.getSCP_AS_VPMN_O());
        output.writeString(voLTE.getSCP_AS_VPMN_QK_O());
        output.writeString(voLTE.getSCP_AS_QK_O());
        output.writeString(voLTE.getSCIM_AS_O());
        output.writeString(voLTE.getCY_AS_O());
        output.writeString(voLTE.getReserved_AS_O());
        output.writeString(voLTE.getI_CSCF_T());
        output.writeString(voLTE.getS_CSCF_T());
        output.writeString(voLTE.getSCP_AS_VPMN_T());
        output.writeString(voLTE.getSCP_AS_VPMN_QK_T());
        output.writeString(voLTE.getSCP_AS_QK_T());
        output.writeString(voLTE.getSCIM_AS_T());
        output.writeString(voLTE.getTAS_T());
        output.writeString(voLTE.getCAT_A_AS_T());
        output.writeString(voLTE.getCAT_V_AS_T());
        output.writeString(voLTE.getCY_AS_T());
        output.writeString(voLTE.getSCC_AS_T());
        output.writeString(voLTE.getGH_AS_T());
        output.writeString(voLTE.getIP_SM_GW());
        output.writeString(voLTE.getReserved_AS_T());
        output.writeString(voLTE.getSBC_T());
        output.writeString(voLTE.getHSS_CX());
        output.writeString(voLTE.getPCRF_O());
        output.writeString(voLTE.getPCRF_T());
        output.writeString(voLTE.getHSS_SH());
        output.writeString(voLTE.getMGCF_MJ_O());
        output.writeString(voLTE.getMGCF_MJ_T());
        output.writeString(voLTE.getNC_OUT());
        output.writeString(voLTE.getNC_IN());
        output.writeString(voLTE.getMGCF_MG());
        output.writeInt(voLTE.getScenario_id(), true);
        output.writeLong(voLTE.getCi(), true);
        output.writeLong(voLTE.getSEG_O_MW_O_ISC11(), true);
        output.writeLong(voLTE.getSEG_O_ISC11_O_ISC12(), true);
        output.writeLong(voLTE.getSEG_O_ISC21_O_ISC22(), true);
        output.writeLong(voLTE.getSEG_O_ISC31_O_ISC62(), true);
        output.writeLong(voLTE.getSEG_O_ISC91_O_ISC92(), true);
        output.writeLong(voLTE.getSEG_T_MW_T_ISC31(), true);
        output.writeLong(voLTE.getSEG_T_ISC31_T_ISC62(), true);
        output.writeLong(voLTE.getSEG_T_ISC21_T_ISC22(), true);
        output.writeLong(voLTE.getSEG_T_ISC71_T_ISC72(), true);
        output.writeLong(voLTE.getSEG_T_ISC81_T_ISC82(), true);
        output.writeLong(voLTE.getSEG_T_ISC91_T_ISC92(), true);
        output.writeLong(voLTE.getSEG_T_ISC11_T_ISC12(), true);
        output.writeLong(voLTE.getSEG_T_ISC111_T_ISC112(), true);
        output.writeLong(voLTE.getSEG_T_MW_T_GM(), true);
        output.writeLong(voLTE.getSEG_T_NC_T_MG(), true);
        output.writeLong(voLTE.getSEG_T_MG_T_ISC31(), true);
        output.writeLong(voLTE.getSEG_T_ISC12_T_MJ(), true);
        output.writeLong(voLTE.getSEG_O_MJ_O_NC(), true);
        output.writeLong(voLTE.getSEG_T_MJ_T_NC(), true);
        output.writeLong(voLTE.getSEG_O_GM_ALL(), true);
        output.writeLong(voLTE.getSEG_CX(), true);
        output.writeLong(voLTE.getSEG_SH(), true);
        output.writeLong(voLTE.getSEG_RX_O(), true);
        output.writeLong(voLTE.getSEG_RX_T(), true);
        output.writeLong(voLTE.getSEG_O_MW_T_MW(), true);


    }

    @Override
    public VoLTE read(Kryo kryo, Input input, Class<VoLTE> type) {
        return null;
    }
}
