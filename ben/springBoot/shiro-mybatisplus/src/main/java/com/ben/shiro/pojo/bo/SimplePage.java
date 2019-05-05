package com.ben.shiro.pojo.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yangkun
 */
@Data
public class SimplePage implements Serializable {
    private static final long serialVersionUID = -3611281051845089828L;
    private int pageNum = 1;
    private int pageSize = 10;
}
