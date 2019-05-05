package com.ben.shiro.pojo.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yangkun
 */
@Data
public class DataItem implements Serializable {
    private static final long serialVersionUID = 6336537430033495096L;
    private Integer id;
    private String classCode;
    private String className;
    private String code;
    private String name;
    private String param;
    private String flag;
    private String createId;
    private String createTime;
    private String updateId;
    private String updateTime;
    private String deleteFlag;
}
