package com.ben.boot.service;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * @author yangkun
 */
public interface UserService {

    JSONObject userList(Map<String, Object> param);
}
