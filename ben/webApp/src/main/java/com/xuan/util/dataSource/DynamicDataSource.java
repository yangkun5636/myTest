package com.xuan.util.dataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DynamicDataSource extends AbstractRoutingDataSource {
    private static final Logger logger = Logger.getLogger(DynamicDataSource.class.getName());

    @Override
    protected Object determineCurrentLookupKey() {
        logger.log(Level.ALL, "determineCurrentLookupKey");
        return DataSourceHolder.getDataSource();
    }

    @Override
    public void afterPropertiesSet() {
        logger.log(Level.ALL, "afterPropertiesSet");
        super.afterPropertiesSet();
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        logger.log(Level.ALL, "getConnection");
        return super.getConnection(username, password);
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        logger.log(Level.ALL, "getLoginTimeout");
        return super.getLoginTimeout();
    }

    @Override
    public PrintWriter getLogWriter() {
        logger.log(Level.ALL, "getLogWriter");
        return super.getLogWriter();
    }

    @Override
    public Logger getParentLogger() {
        logger.log(Level.ALL, "getParentLogger");
        return super.getParentLogger();
    }
}
