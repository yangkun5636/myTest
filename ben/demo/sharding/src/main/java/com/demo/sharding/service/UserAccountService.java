package com.demo.sharding.service;

import com.demo.sharding.domain.UserAccount;
import java.util.List;

/**
 * @author yangkun
 * @see
 * @since
 */
public interface UserAccountService {

    List<UserAccount> selectAll();

}
