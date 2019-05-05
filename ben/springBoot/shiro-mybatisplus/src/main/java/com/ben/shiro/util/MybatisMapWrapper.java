package com.ben.shiro.util;

import com.google.common.base.CaseFormat;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.wrapper.MapWrapper;

import java.util.Map;

/**
 * @author yangkun
 * @TIME 2018/8/21 10:03
 * @User yangkun
 * @DESCRIPTION
 */
public class MybatisMapWrapper extends MapWrapper {

    public MybatisMapWrapper(MetaObject metaObject, Map<String, Object> map) {
        super(metaObject, map);
    }

    @Override
    public String findProperty(String name, boolean useCamelCaseMapping) {
        if (useCamelCaseMapping) {
            return underlineToCamelhump(name);
        }
        return super.findProperty(name, useCamelCaseMapping);
    }

    private static String underlineToCamelhump(String name) {
        String key = name;
        if (Character.isUpperCase(name.charAt(0)) || name.indexOf('_') >= 0) {
            key = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, name);
        }
        return key;
    }
}
