package com.ben.boot.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ben.boot.entity.User;
import com.ben.boot.mapper.UserMapper;
import com.ben.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangkun
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public JSONObject userList(Map<String, Object> param) {
        List<User> userList = userMapper.userList(param);
        Map<String, Object> result = new HashMap<>();
        result.put("list", userList);
        return (JSONObject) JSONObject.toJSON(result);
    }
}
