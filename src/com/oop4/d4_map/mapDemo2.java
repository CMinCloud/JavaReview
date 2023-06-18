package com.oop4.d4_map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class mapDemo2 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>();

        map.put(1, "aa");
        map.put(334, "bbbadadq");
        map.put(42, "adadaa");
        map.put(Integer.valueOf("45"), "888");
//        直接输出map
        System.out.println(map);

        /**
         * 1、根据键找值：
         * 首先获取所有键的集合
         */
        Set<Integer> integers = map.keySet();
        for (Integer i : integers
        ) {
            System.out.print(i + ":");
            System.out.println(map.get(i));
        }


        /**
         * 2、直接获取键值对集合：
         * 	调用entrySet获得键值对对象的集合：
         * 再使用getKey()  和  getValue()方法获得对应属性
         */
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println("key:" + entry.getKey() + ",value:" + entry.getValue());
        }

        /**
         * 3.Lambda格式遍历
         */
        map.forEach(new BiConsumer<Integer, String>() {
            @Override
            public void accept(Integer integer, String s) {
                System.out.println("keys:"+integer+",value:"+s);
            }
        });
//        lambada写法
        map.forEach((K, V) -> {
                    System.out.println("Key:" + K + ",Value:" + V);
                }
        );
    }
}
