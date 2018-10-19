package com.xuan.service.impl;

import com.xuan.dao.entity.User;
import com.xuan.dao.mapper.TestMapper;
import com.xuan.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestMapper testMapper;

    @Override
    public String test() {
        Map<String,Object> param = new HashMap<>();
        User user = testMapper.test(param);
        return null;
    }
}
