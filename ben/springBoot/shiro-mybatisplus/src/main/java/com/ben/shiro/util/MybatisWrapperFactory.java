package com.ben.shiro.util;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.wrapper.ObjectWrapper;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;

import java.util.Map;

/**
 * @author yangkun
 * @TIME 2018/8/21 10:41
 * @User yangkun
 * @DESCRIPTION mybatis 返回Map时key的驼峰命名
 * 配合mybatis 配置 objectWrapperFactory 并且要设置 mapUnderscoreToCamelCase 为true
 */
public class MybatisWrapperFactory implements ObjectWrapperFactory {
    @Override
    public boolean hasWrapperFor(Object o) {
        return o != null && o instanceof Map;
    }

    @Override
    public ObjectWrapper getWrapperFor(MetaObject metaObject, Object o) {
        return new MybatisMapWrapper(metaObject, (Map) o);
    }
}
