package com.ben.boot.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yangkun
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -6468000886893567821L;
    int id;
    String userName;
    String password;
    String phone;
    String wx;
    String qq;
    int status;
    int createId;
    Date createTime;
    int updateId;
    Date updateTime;
    int deleteFlag;
}
