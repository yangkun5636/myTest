package com.xuan.dao.mapper;

import com.xuan.dao.entity.User;
import com.xuan.util.dataSource.DataSource;

import java.util.List;
import java.util.Map;

public interface TestMapper {

    @DataSource("master")
    User test(Map<String, Object> param);

    @DataSource("slave")
    List<User> listAll(Map<String, Object> param);
}
