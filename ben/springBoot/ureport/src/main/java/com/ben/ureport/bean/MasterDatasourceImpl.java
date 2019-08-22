package com.ben.ureport.bean;

import com.bstek.ureport.definition.datasource.BuildinDatasource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
public class MasterDatasourceImpl implements BuildinDatasource {
    @Value("${db.master.driver-class-name}")
    private String driver;
    @Value("${db.master.url}")
    private String url;
    @Value("${db.master.username}")
    private String username;
    @Value("${db.master.password}")
    private String password;

    @Override
    public String name() {
        return "master";
    }

    @Override
    public Connection getConnection() {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
