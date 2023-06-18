package com.oop4.collectionReview;

import java.util.*;

public class treemapTest {


    public static void main(String[] args) {


        TreeMap<Integer, String> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2 >= 0 ? 1 : -1;
            }
        });

        map.put(3, "3");
        map.put(2, "2");
        map.put(4, "4");
        map.put(1, "1");
        map.put(7, "7");


        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey()+","+entry.getValue());
        }

        System.out.println(map.get(1));

        System.out.println(map.get(7));

        Iterator<Integer> iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            Integer next = iterator.next();
            String s = map.get(next);
            System.out.println(s);
        }


        HashSet<Character> set = new HashSet<>();
        set.add(' ');
        set.add('a');
        set.add('2');
        set.add('o');
        System.out.println(set);
        set.clear();
        System.out.println(set);
    }
}
