package com.ben.boot.mapper;

import com.ben.boot.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author yangkun
 */
@Repository
public interface UserMapper {

    List<User> userList(Map<String, Object> param);
}
