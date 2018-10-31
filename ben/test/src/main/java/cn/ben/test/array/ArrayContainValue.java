package cn.ben.test.array;

import java.lang.reflect.Field;
import java.util.*;

public class ArrayContainValue {

    public static void createArray() {
        System.out.println("开始创建数组1：" + System.currentTimeMillis());
        int[] array1 = new int[100000];
        for (int i = 0; i < 99999; i++) {
            array1[i] = new Random().nextInt();
        }
        System.out.println("开始创建数组2：" + System.currentTimeMillis());
        int[] array2 = new int[100000];
        Random random = new Random();
        for (int i = 0; i < 99999; i++) {
            array2[i] = random.nextInt();
        }
        System.out.println("数组创建完成" + System.currentTimeMillis());
    }

    public static void contains() {
        int value = 5646;
        long l1 = System.nanoTime();
        System.out.println("开始创建数组：" + l1);
        Integer[] array = new Integer[100000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();
        }
        long l2 = System.nanoTime();
        System.out.println("数组创建完成：" + (l2 - l1));

        long l3 = System.nanoTime();
        List list = Arrays.asList(array);
        boolean listContain = list.contains(value);
        long l4 = System.nanoTime();
        System.out.println("LIST包含value：" + (l4 - l3));

        long l5 = System.nanoTime();
        Set<Integer> set = new HashSet<>(Arrays.asList(array));
        boolean setContain = set.contains(value);
        long l6 = System.nanoTime();
        System.out.println("SET包含value：" + (l6 - l5));

        long l7 = System.nanoTime();
        for (Integer integer : array) {
            if (value == integer) {
                break;
            }
        }
        long l8 = System.nanoTime();
        System.out.println("for循环判断结束：" + (l8 - l7));
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
//        createArray();
        contains();
        Map<String, Object> map = new HashMap<>();
        map.put("name", "name");
        map.put("age", 123);
    }
}
