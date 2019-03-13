package com.ben.ureport.bean;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TestBean {
    private static final String character = "abcdefghijklmnopqrstuvwxyz";
    private static final Random random = new Random();

    /**
     * @param dataSourceName 数据源名称
     * @param dataSetName    数据集名称
     * @param param          参数
     * @return
     */
    public List<Map<String, Object>> getListMap(String dataSourceName, String dataSetName, Map<String, Object> param) {
        int size = random.nextInt(20);
        return getList(size);
    }

    private List<Map<String, Object>> getList(int size) {
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("user", getStr());
            map.put("name", getStr());
            map.put("class", getStr());
            map.put("desc", getStr());
            list.add(map);
        }
        return list;
    }

    private static String getStr() {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < 5; i++) {
            int r = random.nextInt(10);
            sb.append(character.charAt(r));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getStr());
    }
}
