package com.ben.shiro.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ben.shiro.pojo.bo.DataDict;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 数据字典 服务类
 * </p>
 *
 * @author yangkun
 * @since 2019-04-24
 */
public interface DataDictService extends IService<DataDict> {

    IPage<DataDict> listPage();
}
