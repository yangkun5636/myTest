package com.xuan.dao.entity;

import com.alibaba.druid.support.monitor.annotation.MTable;
import lombok.Data;

import java.io.Serializable;


@Data
@MTable(name = "")
public class User implements Serializable {
    private int id;
    private String name;
    private int age;
    private String email;
}
