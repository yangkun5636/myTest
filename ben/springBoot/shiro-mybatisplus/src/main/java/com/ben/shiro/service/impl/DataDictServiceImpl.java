package com.ben.shiro.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ben.shiro.mapper.DataDictMapper;
import com.ben.shiro.pojo.bo.DataDict;
import com.ben.shiro.service.DataDictService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 数据字典 服务实现类
 * </p>
 *
 * @author yangkun
 * @since 2019-04-24
 */
@Service
public class DataDictServiceImpl extends ServiceImpl<DataDictMapper, DataDict> implements DataDictService {

    @Override
    public IPage<DataDict> listPage() {

        return null;
    }
}
