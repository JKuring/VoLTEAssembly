package storm.worker;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.util.Set;

/**
 * Created by linghang.kong on 2016/9/6.
 * TwmpProxy-Redis 的清除方案
 */
public class DelRedisPartition {
    private static Long count = 0L;
    private String ip;
    private int port;
    private String[] ipPort;
    private Jedis jedis;
    private Pipeline pipieline;
    private Set<String> dataKeys;
    private Set<String> timeKeys;
    private Set<String> xdrKeys;
    private Set<String> csfbKeys;

    public static void main(String[] args) {
        int function = 1;
        JedisInfo jedisInfo = new JedisInfo();
        DelRedisPartition delRedisPartition = new DelRedisPartition();

        if (function == 0) {
            System.out.println("开始清除");
            delRedisPartition.clean(jedisInfo);
            System.out.println("清除完成");
        } else if (function == 1) {
            System.out.println("开始查找xdr分区");
            delRedisPartition.getDataPrtition(jedisInfo);
            System.out.println("查找分区完毕");
        } else if (function == 2) {
            System.out.println("开始统计查找成功率");
            delRedisPartition.getCount(jedisInfo);
        }
    }

    public void clean(JedisInfo jedisInfo) {
        for (String tmp : jedisInfo.getAddresses()
                ) {
            System.out.println("清除：" + tmp);
            doClean(tmp, jedisInfo);
        }
    }

    private void doClean(String tmp, JedisInfo jedisInfo) {
        try {
            ipPort = tmp.split(":");
            jedis = new Jedis(ipPort[0], Integer.parseInt(ipPort[1]));
            jedis.auth(jedisInfo.getPassword());
            jedis.connect();
//            dataKeys = jedis.keys("DataPartition-*");
//            timeKeys = jedis.keys("2016-*");
//            xdrKeys = jedis.keys("MergedXDR-*");
//            jedis.del("NetworkElement");
            csfbKeys = jedis.keys("data:sort:");

//            if (dataKeys.size() > 0) {
//                jedis.del(dataKeys.toArray(new String[dataKeys.size()]));
//            }
//            if (timeKeys.size() > 0) {
//                jedis.del(timeKeys.toArray(new String[timeKeys.size()]));
//            }
//            if (xdrKeys.size() > 0) {
//                jedis.del(xdrKeys.toArray(new String[xdrKeys.size()]));
//            }
            if (csfbKeys.size() > 0) {
                jedis.del(csfbKeys.toArray(new String[csfbKeys.size()]));
            }
//            jedis.disconnect();
            jedis.close();
        } catch (Exception e) {
            jedis.close();
            System.out.println("exception: " + e.getMessage());
            System.out.println("redo: " + tmp);
            doClean(tmp, jedisInfo);
        }
    }

    public Set getDataPrtition(JedisInfo jedisInfo) {
        for (String tmp : jedisInfo.getAddresses()
                ) {
            System.out.println("查找：" + tmp);
            String result = partition(tmp, jedisInfo);
            if (result != null) {
                System.out.println("Yes");
                System.out.println(result);
            }
        }
        System.out.println("数据总数：" + count);
        return null;
    }

    private String partition(String tmp, JedisInfo jedisInfo) {
        ipPort = tmp.split(":");
        jedis = new Jedis(ipPort[0], Integer.parseInt(ipPort[1]));
        jedis.auth(jedisInfo.getPassword());
        jedis.connect();

        //查找网元
//        if (jedis.keys("NetworkElement").size()>0){
//            Set<String> set= jedis.hgetAll("NetworkElement").keySet();
//            for (String name: set
//                 ) {
//                System.out.println(name);
//            }
//        }

//        jedis.configSet("maxmemory", "12000000000");

        // 统计时间分区
        xdrKeys = jedis.keys("MD5*");
        if (xdrKeys.size() > 0) {
            for (String xdrKey : xdrKeys
                    ) {
                System.out.println(xdrKey);
//                count += jedis.hlen(xdrKey);
//                count += jedis.scard(xdrKey);
//                System.out.println(jedis.get("successfulNUM"));
//                System.out.println(Arrays.toString(jedis.hkeys(xdrKey).toArray()));
            }
//            return "" + count;
//            return Arrays.toString(xdrKeys.toArray());
        }

        jedis.close();
        return null;
    }

    public void getCount(JedisInfo jedisInfo) {
        for (String tmp : jedisInfo.getAddresses()
                ) {
            System.out.println("统计：" + tmp);
            count(tmp, jedisInfo);
        }
    }

    private void count(String addr, JedisInfo jedisInfo) {
        ipPort = addr.split(":");
        jedis = new Jedis(ipPort[0], Integer.parseInt(ipPort[1]));
        jedis.auth(jedisInfo.getPassword());
        jedis.connect();
        System.out.println("succount" + jedis.get("succount"));
        System.out.println("count" + jedis.get("count"));

    }
}
