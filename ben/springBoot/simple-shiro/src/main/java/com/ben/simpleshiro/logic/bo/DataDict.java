package com.ben.simpleshiro.logic.bo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yangkun
 */
@Data
public class DataDict implements Serializable {
    private static final long serialVersionUID = 2819523709529593629L;
    private Integer id;
    private Integer parent;
    private String code;
    private String name;
    private Integer status;
    private Integer createId;
    private Date createTime;
    private Integer updateId;
    private Date updateTime;
    private Integer deleteFlag;
}
