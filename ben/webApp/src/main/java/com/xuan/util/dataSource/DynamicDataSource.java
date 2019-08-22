package com.xuan.util.dataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

public class DynamicDataSource extends AbstractRoutingDataSource {
    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSource.class);

    @Override
    protected Object determineCurrentLookupKey() {
        logger.debug("determineCurrentLookupKey");
        return DataSourceHolder.getDataSource();
    }

    @Override
    public void afterPropertiesSet() {
        logger.debug("afterPropertiesSet");
        super.afterPropertiesSet();
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        logger.debug("getConnection");
        return super.getConnection(username, password);
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        logger.debug("getLoginTimeout");
        return super.getLoginTimeout();
    }

    @Override
    public PrintWriter getLogWriter() {
        logger.debug("getLogWriter");
        return super.getLogWriter();
    }

    @Override
    public java.util.logging.Logger getParentLogger() {
        logger.debug("getParentLogger");
        return super.getParentLogger();
    }
}
