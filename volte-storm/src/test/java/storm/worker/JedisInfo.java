package storm.worker;

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
        addresses.add("10.11.58.92:6301");
        addresses.add("10.11.58.92:6302");
        addresses.add("10.11.58.92:6303");
        addresses.add("10.11.58.92:6304");
        addresses.add("10.11.58.92:6305");
        addresses.add("10.11.58.92:6306");
        addresses.add("10.11.58.92:6307");
        addresses.add("10.11.58.92:6308");
        addresses.add("10.11.58.92:6309");
        addresses.add("10.11.58.92:6310");
        addresses.add("10.11.58.92:6311");
        addresses.add("10.11.58.92:6312");
        addresses.add("10.11.58.93:6301");
        addresses.add("10.11.58.93:6302");
        addresses.add("10.11.58.93:6303");
        addresses.add("10.11.58.93:6304");
        addresses.add("10.11.58.93:6305");
        addresses.add("10.11.58.93:6306");
        addresses.add("10.11.58.93:6307");
        addresses.add("10.11.58.93:6308");
        addresses.add("10.11.58.93:6309");
        addresses.add("10.11.58.93:6310");
        addresses.add("10.11.58.93:6311");
        addresses.add("10.11.58.93:6312");
        addresses.add("10.11.58.94:6301");
        addresses.add("10.11.58.94:6302");
        addresses.add("10.11.58.94:6303");
        addresses.add("10.11.58.94:6304");
        addresses.add("10.11.58.94:6305");
        addresses.add("10.11.58.94:6306");
        addresses.add("10.11.58.94:6307");
        addresses.add("10.11.58.94:6308");
        addresses.add("10.11.58.94:6309");
        addresses.add("10.11.58.94:6310");
        addresses.add("10.11.58.94:6311");
        addresses.add("10.11.58.94:6312");

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
