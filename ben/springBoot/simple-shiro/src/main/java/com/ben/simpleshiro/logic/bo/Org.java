package com.ben.simpleshiro.logic.bo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yangkun
 */
@Data
public class Org implements Serializable {
    private static final long serialVersionUID = 3325257816704112543L;

    private Integer id;
    private Integer parent;
    private String orgName;
    private String orgCode;
    private Integer type;
    private Integer sort;
    private String area;
    private Integer grade;
    private Integer status;
    private String address;
    private String securityKey;
    private Integer createId;
    private Date createTime;
    private Integer updateId;
    private Date updateTime;
    private Integer deleteFlag;
}
