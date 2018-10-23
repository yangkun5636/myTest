package com.xuan.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.xuan.dao.entity.User;
import com.xuan.dao.mapper.TestMapper;
import com.xuan.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestMapper testMapper;

    @Override
    public String test() {
        Map<String, Object> param = new HashMap<>();
        Map<String, Object> user = testMapper.test(param);
        List<User> users = testMapper.listAll(param);
        return JSONArray.toJSONString(user);
    }
}
