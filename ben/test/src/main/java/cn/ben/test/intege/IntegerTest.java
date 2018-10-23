package cn.ben.test.intege;

import cn.hutool.core.bean.BeanUtil;

import java.lang.reflect.Field;

public class IntegerTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class cache = Integer.class.getDeclaredClasses()[0];
        Field field = cache.getDeclaredField("cache");
        field.setAccessible(true);
        Integer[] caches = (Integer[]) field.get("cache");
        caches[132] = caches[134];
        int a = 2;
        int b = a + a;
        System.out.printf("%d + %d = %d", a, a, b);
    }
}
