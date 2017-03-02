package com.eastcom.volte.cyclework.load;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by linghang.kong on 2016/9/28.
 */
public class DBCPConnectionPool {

    private static final Logger logger = LoggerFactory.getLogger(DBCPConnectionPool.class);

    private DataSource dataSource;

    public DBCPConnectionPool(String driverName, String connectURI, String username, String password) {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(driverName);
        ds.setUrl(connectURI);
        ds.setUsername(username);
        ds.setPassword(password);
        this.dataSource = ds;
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public ResultSet executeQuery(Connection connection, String sql) {
        try {
            return connection.createStatement().executeQuery(sql);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return null;
    }
}
