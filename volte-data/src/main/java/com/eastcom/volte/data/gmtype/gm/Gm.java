package com.eastcom.volte.data.gmtype.gm;

import com.eastcom.volte.data.DataCommon;

/**
 * Created by linghang.kong on 2016/8/11.
 * Included 65 params about Mw, Mw, Mg, Mi, Mj and ISC interfaces;
 */
public class Gm implements DataCommon {

//    private int length;
//
//    private String city;

    private int Interface;

    private String xdr_id;

    //    private int rat;
//
//    private String imsi;
//
//    private String imei;
//
//    private String msisdn;
//
//    private String procedure_type;
//
    private long start_time;
    //
//    private long end_time;
//
//    private String service_type;
//
//    private int procedure_status;
//
//    private String calling_number;
//
//    private String called_number;
//
//    private String calling_party_url;
//
//    private String request_url;
//
//    private String user_ip;
//
//    private String callid;
//
//    private String icid;
//
//    private String source_ne_ip;
//
//    private String source_ne_port;
//
    private String dest_ne_ip;
//
//    private String dest_ne_port;
//
//    private int call_side;
//
//    private String source_access_type;
//
//    private String source_eci;
//
//    private String source_tac;
//
//    private String source_imsi;
//
//    private String source_imei;
//
//    private String dest_access_type;
//
//    private String dest_eci;
//
//    private String dest_tac;
//
//    private String dest_imsi;
//
//    private String dest_imei;
//
//    private String auth_type;
//
//    private int expires_time_req;
//
//    private int expires_time_rsp;
//
//    private String calling_sdp_ip_addr;
//
//    private String calling_audio_sdp_port;
//
//    private String calling_video_sdp_port;
//
//    private String called_sdp_ip_addr;
//
//    private String called_audio_sdp_port;
//
//    private String called_video_port;
//
//    private int audio_codec;
//
//    private int video_codec;
//
//    private String redirecting_party_address;
//
//    private String original_party_address;
//
//    private int redirect_reason;
//
//    private int response_code;
//
//    private String finish_warning_code;
//
//    private String finish_reason_protocol;
//
//    private String finish_reason_cause;
//
//    private int firfailtime;
//
//    private String first_fail_ne_ip;

    private int alerting_time;
//
//    private int answer_time;
//
//    private int release_time;
//
//    private int call_duration;
//
//    private int auth_req_time;
//
//    private int auth_rsp_time;
//
//    private String stn_sr;
//
//    private String atcf_mgmt;
//
//    private String atu_sti;
//
//    private String c_msisdn;
//
//    private String ssi;


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

    public long getStart_time() {
        return start_time;
    }

    public void setStart_time(long start_time) {
        this.start_time = start_time;
    }

    public String getDest_ne_ip() {
        return dest_ne_ip;
    }

    public void setDest_ne_ip(String dest_ne_ip) {
        this.dest_ne_ip = dest_ne_ip;
    }

    public int getAlerting_time() {
        return alerting_time;
    }

    public void setAlerting_time(int alerting_time) {
        this.alerting_time = alerting_time;
    }
}
