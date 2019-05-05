package cn.ben.test.intege;

import java.lang.reflect.Field;

public class IntegerTest {
    public static void main(String[] args) throws Exception {
        swapTest();
        integerCache();
    }

    public static void integerCache() throws Exception {
        Class cache = Integer.class.getDeclaredClasses()[0];
        Field field = cache.getDeclaredField("cache");
        field.setAccessible(true);
        Integer[] caches = (Integer[]) field.get("cache");
        caches[132] = caches[134];
        int a = 2;
        int b = a + a;
        System.out.printf("%d + %d = %d", a, a, b);
    }

    public static void swapTest() throws Exception {
        Integer a = 99;
        Integer b = 88;
        System.out.println("swap之前:[a=" + a + ",b=" + b + "]");
        swap(a, b);
        System.out.println("swap之后:[a=" + a + ",b=" + b + "]");
    }

    public static void swap(Integer a, Integer b) throws Exception {
        int temp = a;
        Field valuea = a.getClass().getDeclaredField("value");
        Field valueb = a.getClass().getDeclaredField("value");
        valuea.setAccessible(true);
        valuea.set(a, b);
        valueb.setAccessible(true);
        valueb.set(b, temp);
    }
}
