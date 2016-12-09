package com.eastcom.volte.cyclework.load;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by linghang.kong on 2016/9/28.
 */
public class DBCPConnectionPool {

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

    public ResultSet executeQuery(Connection connection, String sql) throws SQLException {
        return connection.createStatement().executeQuery(sql);
    }
}
