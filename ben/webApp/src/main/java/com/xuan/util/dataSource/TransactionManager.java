//package com.xuan.util.dataSource;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.SQLException;
//
//public class TransactionManager {
//    private static final Logger logger = LoggerFactory.getLogger(TransactionManager.class);
//    private DataSource dataSource;
//    public static final ThreadLocal<Connection> connections = new ThreadLocal<>();
//
//    public DataSource getDataSource() {
//        System.out.println("TransactionManager:getDataSource");
//        return dataSource;
//    }
//
//    public void setDataSource(DataSource dataSource) {
//        System.out.println("TransactionManager:setDataSource");
//        this.dataSource = dataSource;
//    }
//
//    public TransactionManager() {
//    }
//
//    public void commit() {
//        Connection connection = null;
//        try {
//            connection = connections.get();
//            connection.commit();
//        } catch (SQLException e) {
//            logger.error("提交事务异常:", e);
//        } finally {
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    logger.error("关闭连接异常");
//                }
//            }
//        }
//
//    }
//
//    public void rollback() {
//        Connection connection = null;
//        try {
//            connection = connections.get();
//            connection.rollback();
//        } catch (SQLException e) {
//            logger.error("提交回滚异常:", e);
//        } finally {
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    logger.error("关闭连接异常");
//                }
//            }
//        }
//
//    }
//}
