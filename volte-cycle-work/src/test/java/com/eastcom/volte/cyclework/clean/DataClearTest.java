package com.eastcom.volte.cyclework.clean;

import org.junit.Test;

/**
 * Created by linghang.kong on 2016/10/27.
 */
public class DataClearTest {
    @Test
    public void cleanScheduler() throws Exception {

        // 启动清除策略
        new DataClear(3, 1).cleanScheduler();

        Thread.currentThread().join();

    }

}