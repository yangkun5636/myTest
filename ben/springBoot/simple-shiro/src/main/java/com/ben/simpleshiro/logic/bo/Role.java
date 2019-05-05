package com.ben.simpleshiro.logic.bo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yangkun
 */
@Data
public class Role implements Serializable {
    private static final long serialVersionUID = -4030645843104949643L;

    private Integer id;
    private Integer orgId;
    private String roleName;
    private String roleCode;
    private Integer roleType;
    private Integer dataScope;
    private Integer status;
    private Integer createId;
    private Date createTime;
    private Integer updateId;
    private Date updateTime;
    private Integer deleteFlag;
}
