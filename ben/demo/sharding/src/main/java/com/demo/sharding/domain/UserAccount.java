package com.demo.sharding.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yangkun
 * @see
 * @since
 */
@Getter
@Setter
public class UserAccount implements Serializable {

    private static final long serialVersionUID = 4632470161934334081L;

    private int id;
    private String account;
    private String password;
    private Date createAt;
    private int createBy;
}
