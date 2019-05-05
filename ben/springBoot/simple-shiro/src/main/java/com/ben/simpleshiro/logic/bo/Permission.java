package com.ben.simpleshiro.logic.bo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yangkun
 */
@Data
public class Permission implements Serializable {
    private static final long serialVersionUID = -597446379310947518L;
    private Integer id;
    private Integer parent;
    private String name;
    private String permission;
    private Integer sort;
    private String href;
    private String target;
    private String icon;
    private Integer isShow;
    private String comment;
    private Integer status;
    private Integer createId;
    private Date createTime;
    private Integer updateId;
    private Date updateTime;
    private Integer deleteFlag;

}
