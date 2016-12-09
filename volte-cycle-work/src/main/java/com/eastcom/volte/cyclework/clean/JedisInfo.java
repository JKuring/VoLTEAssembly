package com.eastcom.volte.cyclework.clean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linghang.kong on 2016/9/2.
 */
public class JedisInfo {

    private int minIdle;
    private String password;
    private List<String> addresses;

    public JedisInfo() {
        this.minIdle = 4;
        this.password = "stream!23$";
        this.addresses = new ArrayList<>();
        addresses.add("10.11.58.92:6401");
        addresses.add("10.11.58.92:6402");
        addresses.add("10.11.58.92:6403");
        addresses.add("10.11.58.92:6404");
        addresses.add("10.11.58.92:6405");
        addresses.add("10.11.58.92:6406");
        addresses.add("10.11.58.92:6407");
        addresses.add("10.11.58.92:6408");
        addresses.add("10.11.58.92:6409");
        addresses.add("10.11.58.92:6410");
        addresses.add("10.11.58.92:6411");
        addresses.add("10.11.58.92:6412");
        addresses.add("10.11.58.93:6401");
        addresses.add("10.11.58.93:6402");
        addresses.add("10.11.58.93:6403");
        addresses.add("10.11.58.93:6404");
        addresses.add("10.11.58.93:6405");
        addresses.add("10.11.58.93:6406");
        addresses.add("10.11.58.93:6407");
        addresses.add("10.11.58.93:6408");
        addresses.add("10.11.58.93:6409");
        addresses.add("10.11.58.93:6410");
        addresses.add("10.11.58.93:6411");
        addresses.add("10.11.58.93:6412");
        addresses.add("10.11.58.94:6401");
        addresses.add("10.11.58.94:6402");
        addresses.add("10.11.58.94:6403");
        addresses.add("10.11.58.94:6404");
        addresses.add("10.11.58.94:6405");
        addresses.add("10.11.58.94:6406");
        addresses.add("10.11.58.94:6407");
        addresses.add("10.11.58.94:6408");
        addresses.add("10.11.58.94:6409");
        addresses.add("10.11.58.94:6410");
        addresses.add("10.11.58.94:6411");
        addresses.add("10.11.58.94:6412");

    }

    public int getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }
}
