package common.pool;

import com.eastcom.volte.storm.common.pool.RedisProxyConnectionPool;
import common.JUnit4ClassRunner;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linghang.kong on 2016/8/22.
 */
public class RedisProxyConnectionPoolTest {
    @Test
    public void getResource() throws Exception {
        JUnit4ClassRunner.initLog4j();
        List<String> poolList = new ArrayList<String>();
        poolList.add("10.11.58.92:6401");
        poolList.add("10.11.58.92:6402");
        poolList.add("10.11.58.92:6403");
        RedisProxyConnectionPool redisPool = new RedisProxyConnectionPool(poolList, "stream!23$", 2);
        Jedis jedis = redisPool.getResource();
        if (jedis.isConnected()) {
            System.out.println(jedis.zrange("data:sort:{4063}", 0, 1000000));
        } else System.out.println("disconnects");
        redisPool.destroy(jedis);
    }

}