package com.eastcom.volte.storm.common.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.vibur.objectpool.ConcurrentLinkedPool;
import org.vibur.objectpool.PoolObjectFactory;
import redis.clients.jedis.Jedis;
import redis.clients.util.Pool;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Random;

/**
 * Created by linghang.kong on 2016/8/17.
 */
public class RedisProxyConnectionPool extends Pool<Jedis> implements PoolObjectFactory<Jedis> {

    private static Logger logger = LoggerFactory.getLogger(RedisProxyConnectionPool.class);

    private List<String> addresses;

    private String password;

    private int sizeMultiple;

    private int size;

    private ConcurrentLinkedPool<Jedis> internalPool;

    /**
     * @param addresses    这里地址中的端口全部为proxy的端口号
     * @param password     password
     * @param sizeMultiple Pool中对象相对于address的倍数，即size * sizeMultiple
     */
    public RedisProxyConnectionPool(List<String> addresses, String password, int sizeMultiple) {
        this.addresses = addresses;
        this.password = password;
        this.sizeMultiple = sizeMultiple;
        this.size = this.addresses.size();
        // 初始化对象为地址数，最大连接数为地址数乘以sizeMultiple
        this.internalPool = new ConcurrentLinkedPool<Jedis>(this, size, size * this.sizeMultiple, false);
    }

    /**
     * 获取Pool的对象，这里用vibur作为Pool
     *
     * @return Jedis handle
     */
    @Override
    public Jedis getResource() {
        return internalPool.take();
    }

    /**
     * 回放对象到Pool中
     *
     * @param resource Jedis handle
     */
    @Override
    public void returnResource(Jedis resource) {
        this.returnResourceObject(resource);
    }

    /**
     * 回放对象到Pool中,并destroy该对象
     *
     * @param resource Jedis handle
     */
    @Override
    public void returnBrokenResource(Jedis resource) {
        this.returnBrokenResourceObject(resource);
    }

    @Override
    public void returnResourceObject(Jedis resource) {
        this.internalPool.restore(resource);
    }

    @Override
    protected void returnBrokenResourceObject(Jedis resource) {
        this.internalPool.restore(resource, false);
    }

    /**
     * 创建Pool中对象的方法
     *
     * @return
     */
    public Jedis create() {
        Random random;
        Jedis jedis;
        for (int i = 0; i < this.size; i++) {
            random = new Random();
            int mod = random.nextInt(this.size);
            try {
                jedis = create(mod);
                return jedis;
            } catch (Exception e) {
                logger.error("Failed to create the Jedis handle.");
                StringBuffer out = new StringBuffer();
                StackTraceElement[] trace = e.getStackTrace();
                out.append(" processResult: " + e.toString());
                for (StackTraceElement s : trace) {
                    out.append("\tat " + s.toString() + "\r\n");
                }
                logger.error(out.toString());
            }
        }
        return null;
    }

    private Jedis create(int mod) throws MalformedURLException {
        String[] address = this.addresses.get(mod).split(":");
        Jedis jedis = new Jedis(address[0], Integer.parseInt(address[1]));

        jedis.auth(this.password);
        return jedis;
    }

    public boolean readyToTake(Jedis jedis) {
        return true;
    }

    public boolean readyToRestore(Jedis jedis) {
        return true;
    }

    public void destroy(Jedis jedis) {
        try {
            if (jedis != null) {
                if (jedis.isConnected()) {
                    jedis.quit();
                }
                jedis.disconnect();
            }
        } catch (Exception e) {

        }
    }
}
