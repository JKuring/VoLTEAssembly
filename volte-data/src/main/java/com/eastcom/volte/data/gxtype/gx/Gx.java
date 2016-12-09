package com.eastcom.volte.data.gxtype.gx;

import com.eastcom.volte.data.DataCommon;

/**
 * Created by linghang.kong on 2016/8/11.
 * Included 32 params about Rx and Rx interfaces;
 */
public class Gx implements DataCommon {
    private int length;

    private String city;

    private int Interface;

    private String xdr_id;

    private int rat;

    private String imsi;

    private String imei;

    private String msisdn;

    private String procedure_type;

    private long start_time;

    private long end_time;

    private String icid;

    private String origin_realm;

    private String destination_realm;

    private String origin_host;

    private String dest_ne_ip;

    private String sgsn_sgw_sig_ip;

    private int af_app_id;

    private int cc_request_type;

    private int rx_request_type;

    private int media_type;

    private int abort_cause;

    private int result_code;

    private int experimental_result_code;

    private int session_release_cause;

    private int rule_failure_code;

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

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getProcedure_type() {
        return procedure_type;
    }

    public void setProcedure_type(String procedure_type) {
        this.procedure_type = procedure_type;
    }

    @Override
    public long getStart_time() {
        return start_time;
    }

    public void setStart_time(long start_time) {
        this.start_time = start_time;
    }

    public long getEnd_time() {
        return end_time;
    }

    public void setEnd_time(long end_time) {
        this.end_time = end_time;
    }

    public String getIcid() {
        return icid;
    }

    public void setIcid(String icid) {
        this.icid = icid;
    }

    public String getOrigin_realm() {
        return origin_realm;
    }

    public void setOrigin_realm(String origin_realm) {
        this.origin_realm = origin_realm;
    }

    public String getDestination_realm() {
        return destination_realm;
    }

    public void setDestination_realm(String destination_realm) {
        this.destination_realm = destination_realm;
    }

    public String getOrigin_host() {
        return origin_host;
    }

    public void setOrigin_host(String origin_host) {
        this.origin_host = origin_host;
    }

    @Override
    public String getDest_ne_ip() {
        return dest_ne_ip;
    }

    public void setDest_ne_ip(String dest_ne_ip) {
        this.dest_ne_ip = dest_ne_ip;
    }

    public String getSgsn_sgw_sig_ip() {
        return sgsn_sgw_sig_ip;
    }

    public void setSgsn_sgw_sig_ip(String sgsn_sgw_sig_ip) {
        this.sgsn_sgw_sig_ip = sgsn_sgw_sig_ip;
    }

    public int getAf_app_id() {
        return af_app_id;
    }

    public void setAf_app_id(int af_app_id) {
        this.af_app_id = af_app_id;
    }

    public int getCc_request_type() {
        return cc_request_type;
    }

    public void setCc_request_type(int cc_request_type) {
        this.cc_request_type = cc_request_type;
    }

    public int getRx_request_type() {
        return rx_request_type;
    }

    public void setRx_request_type(int rx_request_type) {
        this.rx_request_type = rx_request_type;
    }

    public int getMedia_type() {
        return media_type;
    }

    public void setMedia_type(int media_type) {
        this.media_type = media_type;
    }

    public int getAbort_cause() {
        return abort_cause;
    }

    public void setAbort_cause(int abort_cause) {
        this.abort_cause = abort_cause;
    }

    public int getResult_code() {
        return result_code;
    }

    public void setResult_code(int result_code) {
        this.result_code = result_code;
    }

    public int getExperimental_result_code() {
        return experimental_result_code;
    }

    public void setExperimental_result_code(int experimental_result_code) {
        this.experimental_result_code = experimental_result_code;
    }

    public int getSession_release_cause() {
        return session_release_cause;
    }

    public void setSession_release_cause(int session_release_cause) {
        this.session_release_cause = session_release_cause;
    }

    public int getRule_failure_code() {
        return rule_failure_code;
    }

    public void setRule_failure_code(int rule_failure_code) {
        this.rule_failure_code = rule_failure_code;
    }
}
