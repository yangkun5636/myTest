package com.ben.shiro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ben.shiro.mapper.PermissionMapper;
import com.ben.shiro.pojo.bo.SysPermission;
import com.ben.shiro.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author yangkun
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, SysPermission> implements PermissionService {

    @Autowired
    private PermissionMapper mapper;

    @Override
    public List<SysPermission> getPermissionList() {
        return mapper.selectByMap(new HashMap<>());
    }
}
