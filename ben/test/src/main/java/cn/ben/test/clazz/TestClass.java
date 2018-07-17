package cn.ben.test.clazz;

import java.lang.reflect.Field;

/**
 * @TIME 2018/6/25 9:54
 * @User yangkun
 * @DESCRIPTION
 */
public class TestClass {
    public static void main(String[] args) {
        AbstractClass clazz = new AbstractClass();
        Field[] fields = AbstractClass.class.getDeclaredFields();
    }
}
