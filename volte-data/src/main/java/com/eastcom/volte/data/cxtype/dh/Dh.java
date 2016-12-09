package com.eastcom.volte.data.cxtype.dh;

import com.eastcom.volte.data.DataCommon;

/**
 * Created by linghang.kong on 2016/8/11.
 * Included 65 params about Dx, Dx, Sh, Dh and Zh interfaces;
 */
public class Dh implements DataCommon {
//    private int length;
//
//    private String city;

    private int Interface;

    private String xdr_id;
//
//    private int rat;
//
//    private String imsi;
//
//    private String imei;
//
//    private String msisdn;

    private long start_time;

    private long end_time;

    //    private String transaction_type;
//
//    private int transaction_status;
//
//    private String source_ne_ip;
//
//    private String source_ne_port;
//
    private String dest_ne_ip;
//
//    private String destination_ne_port;
//
//    private int result_code;
//
//    private int experimental_result_code;
//
//    private String origin_realm;
//
//    private String destination_realm;
//
//    private String origin_host;
//
//    private String destination_host;
//
//    private int general_odb;
//
//    private int hplmn_odb;

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

    public String getDest_ne_ip() {
        return dest_ne_ip;
    }

    public void setDest_ne_ip(String dest_ne_ip) {
        this.dest_ne_ip = dest_ne_ip;
    }
}
