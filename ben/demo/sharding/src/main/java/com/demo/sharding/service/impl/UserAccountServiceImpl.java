package com.demo.sharding.service.impl;

import com.demo.sharding.domain.UserAccount;
import com.demo.sharding.mapper.UserAccountMapper;
import com.demo.sharding.service.UserAccountService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yangkun
 * @see
 * @since
 */
@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountMapper mapper;

    @Override
    public List<UserAccount> selectAll() {
        return mapper.selectAll();
    }
}
