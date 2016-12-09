package com.eastcom.volte.data.svtype;

import com.eastcom.volte.data.DataCommon;

/**
 * Created by linghang.kong on 2016/8/11.
 * Included 38 params about Sv interfaces;
 */
public class Sv implements DataCommon {
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

    private String source_ne_ip;

    private String source_ne_port;

    private String dest_ne_ip;

    private String dest_ne_port;

    private int roam_direction;

    private int home_mcc;

    private int home_mnc;

    private int mcc;

    private int mnc;

    private String target_lac;

    private String source_tac;

    private String source_eci;

    private String apn;

    private int sv_flags;

    private String ul_c_msc_ip;

    private String dl_c_mme_ip;

    private String ul_c_msc_teid;

    private String dl_c_mme_teid;

    private String stn_sr;

    private String target_rnc_id;

    private String target_cell_id;

    private int arp;

    private String request_result;

    private int result;

    private int sv_cause;

    private int port_failure_cause;

    private int resp_delay;

    private int sv_delay;

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

    public String getSource_ne_ip() {
        return source_ne_ip;
    }

    public void setSource_ne_ip(String source_ne_ip) {
        this.source_ne_ip = source_ne_ip;
    }

    public String getSource_ne_port() {
        return source_ne_port;
    }

    public void setSource_ne_port(String source_ne_port) {
        this.source_ne_port = source_ne_port;
    }

    public String getDest_ne_ip() {
        return dest_ne_ip;
    }

    public void setDest_ne_ip(String dest_ne_ip) {
        this.dest_ne_ip = dest_ne_ip;
    }

    public String getDest_ne_port() {
        return dest_ne_port;
    }

    public void setDest_ne_port(String dest_ne_port) {
        this.dest_ne_port = dest_ne_port;
    }

    public int getRoam_direction() {
        return roam_direction;
    }

    public void setRoam_direction(int roam_direction) {
        this.roam_direction = roam_direction;
    }

    public int getHome_mcc() {
        return home_mcc;
    }

    public void setHome_mcc(int home_mcc) {
        this.home_mcc = home_mcc;
    }

    public int getHome_mnc() {
        return home_mnc;
    }

    public void setHome_mnc(int home_mnc) {
        this.home_mnc = home_mnc;
    }

    public int getMcc() {
        return mcc;
    }

    public void setMcc(int mcc) {
        this.mcc = mcc;
    }

    public int getMnc() {
        return mnc;
    }

    public void setMnc(int mnc) {
        this.mnc = mnc;
    }

    public String getTarget_lac() {
        return target_lac;
    }

    public void setTarget_lac(String target_lac) {
        this.target_lac = target_lac;
    }

    public String getSource_tac() {
        return source_tac;
    }

    public void setSource_tac(String source_tac) {
        this.source_tac = source_tac;
    }

    public String getSource_eci() {
        return source_eci;
    }

    public void setSource_eci(String source_eci) {
        this.source_eci = source_eci;
    }

    public String getApn() {
        return apn;
    }

    public void setApn(String apn) {
        this.apn = apn;
    }

    public int getSv_flags() {
        return sv_flags;
    }

    public void setSv_flags(int sv_flags) {
        this.sv_flags = sv_flags;
    }

    public String getUl_c_msc_ip() {
        return ul_c_msc_ip;
    }

    public void setUl_c_msc_ip(String ul_c_msc_ip) {
        this.ul_c_msc_ip = ul_c_msc_ip;
    }

    public String getDl_c_mme_ip() {
        return dl_c_mme_ip;
    }

    public void setDl_c_mme_ip(String dl_c_mme_ip) {
        this.dl_c_mme_ip = dl_c_mme_ip;
    }

    public String getUl_c_msc_teid() {
        return ul_c_msc_teid;
    }

    public void setUl_c_msc_teid(String ul_c_msc_teid) {
        this.ul_c_msc_teid = ul_c_msc_teid;
    }

    public String getDl_c_mme_teid() {
        return dl_c_mme_teid;
    }

    public void setDl_c_mme_teid(String dl_c_mme_teid) {
        this.dl_c_mme_teid = dl_c_mme_teid;
    }

    public String getStn_sr() {
        return stn_sr;
    }

    public void setStn_sr(String stn_sr) {
        this.stn_sr = stn_sr;
    }

    public String getTarget_rnc_id() {
        return target_rnc_id;
    }

    public void setTarget_rnc_id(String target_rnc_id) {
        this.target_rnc_id = target_rnc_id;
    }

    public String getTarget_cell_id() {
        return target_cell_id;
    }

    public void setTarget_cell_id(String target_cell_id) {
        this.target_cell_id = target_cell_id;
    }

    public int getArp() {
        return arp;
    }

    public void setArp(int arp) {
        this.arp = arp;
    }

    public String getRequest_result() {
        return request_result;
    }

    public void setRequest_result(String request_result) {
        this.request_result = request_result;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getSv_cause() {
        return sv_cause;
    }

    public void setSv_cause(int sv_cause) {
        this.sv_cause = sv_cause;
    }

    public int getPort_failure_cause() {
        return port_failure_cause;
    }

    public void setPort_failure_cause(int port_failure_cause) {
        this.port_failure_cause = port_failure_cause;
    }

    public int getResp_delay() {
        return resp_delay;
    }

    public void setResp_delay(int resp_delay) {
        this.resp_delay = resp_delay;
    }

    public int getSv_delay() {
        return sv_delay;
    }

    public void setSv_delay(int sv_delay) {
        this.sv_delay = sv_delay;
    }
}
