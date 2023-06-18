package com.oop4.collectionReview;

import java.util.*;

public class map {

    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap();
        map.put("ccc",3);
        map.put("aaa",1);
        map.put("bbb",2);
        map.put(null,2);

        String s = "We are happy".replaceAll(" ", "%20");
        System.out.println(s);
        /**
         * linkedHashMap中维护了一条双向链表，因此使用递归遍历是有序的
         */
        Map<String,Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("aaa",1);
        linkedHashMap.put("bbb",2);
        linkedHashMap.put("ccc",3);







        Set<String> set = linkedHashMap.keySet();
        Set<String> set1 = map.keySet();


        Iterator<String> iterator1 = set1.iterator();
        while(iterator1.hasNext()){
            String key = iterator1.next();
            System.out.println(key + "，"+map.get(key));
        }

        System.out.println("-------------");

        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            System.out.println(key + "，"+linkedHashMap.get(key));
        }


    }
}
