package com.xuan.util.dataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return null;
    }

    @Override
    public void afterPropertiesSet() {
        super.afterPropertiesSet();
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return super.getConnection(username, password);
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return super.getLoginTimeout();
    }

    @Override
    public PrintWriter getLogWriter() {
        return super.getLogWriter();
    }

    @Override
    public Logger getParentLogger() {
        return super.getParentLogger();
    }
}
