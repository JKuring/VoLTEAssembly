package com.eastcom.volte.cyclework.load;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

/**
 * Created by linghang.kong on 2017/3/1.
 */
public class DataBaseConnection {
    private static final Logger logger = LoggerFactory.getLogger(DataBaseConnection.class);

    private static SqlSessionFactory sqlSessionFactory;

    private static InputStream inputStream;

    private static SqlSession sqlSession;

    public static void init() {
        init(null);
    }

    public static void init(String resource) {
        try {
            if (resource == null) {
                resource = "mybatis-config.xml";
            }
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            // 如果出现找不到指针或者为null，则是mybatis的config文件没有配置好。
            // 在重复查询的情况下并使用ARM功能，请使用sqlSessionFactory，因为session关闭，就需要重新获取。
//            sqlSession = sqlSessionFactory.openSession();
        } catch (Exception e) {
            logger.error("init exception: {}.", e.getMessage());
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public static void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        DataBaseConnection.sqlSessionFactory = sqlSessionFactory;
    }
}
