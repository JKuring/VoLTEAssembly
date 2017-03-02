package com.eastcom.volte.cyclework.beans;

/**
 * Created by linghang.kong on 2017/3/1.
 */
public class NetworkElement {
    private String id;
    private String network_element_name;
    private String ip;
    private String type;
    private String note;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNetwork_element_name() {
        return network_element_name;
    }

    public void setNetwork_element_name(String network_element_name) {
        this.network_element_name = network_element_name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
