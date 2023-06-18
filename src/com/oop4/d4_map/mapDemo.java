package com.oop4.d4_map;

import java.util.*;

public class mapDemo {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<Integer, String>();
//        LinkedHashMap 有序

        map.put(1, "aa");
        map.put(334, "bbbadadq");
        map.put(42, "adadaa");
        map.put(2,"aa");
//        先将字符串转化为Integer
        map.put(Integer.valueOf("45"), "888");
        System.out.println(map);
        System.out.println("values:"+map.values());


//2.根据键获得值：
        String s = map.get(45);
        System.out.println(s);
//        3.根据键删除整个元素
        System.out.println(map.remove(42));

        System.out.println("-----------------------------------");
//        4.判断是否包含某个键
        System.out.println(map.containsKey(42));
//5.判断是否包含某个值
        System.out.println(map.containsValue("888"));
//        6.获取全部的键集合
        Set<Integer> integers = map.keySet();
        System.out.println(integers);
//        7.获取全部值的集合
        Collection<String> values = map.values();
        System.out.println(values);
        System.out.println(map);


//        清空集合
        map.clear();
//
    }
}
