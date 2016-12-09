package com.eastcom.volte.data.nc;

import com.eastcom.volte.data.DataCommon;

/**
 * Created by linghang.kong on 2016/8/29.
 */
public class Nc implements DataCommon {

    private long start_time;
    private long acmoffset;
    private String xdr_id;


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

    public long getAcmoffset() {
        return acmoffset;
    }

    public void setAcmoffset(long acmoffset) {
        this.acmoffset = acmoffset;
    }

    @Override
    public int getInterface() {
        return 0;
    }

    @Override
    public String getXdr_id() {
        return xdr_id;
    }

    public void setXdr_id(String xdr_id) {
        this.xdr_id = xdr_id;
    }

}
