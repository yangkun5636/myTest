package com.ben.shiro.pojo.bo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author yangkun
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 8354656554184895317L;

    private Integer id;
    private Integer orgId;
    private String deptNo;
    private String username;
    private String password;
    private String nickname;
    private String userNo;
    private String phone;
    private String email;
    private Integer userType;
    private String photo;
    private String wx;
    private String qq;
    private Integer status;
    private String loginIp;
    private Date loginDate;
    private Integer loginFlag;
    private Integer createId;
    private Date createTime;
    private Integer updateId;
    private Date updateTime;
    private Integer deleteFlag;

    private List<Role> roles;
    private List<Permission> permissions;
}
