package com.unsafe;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class hashmap_1 {


    public static void main(String[] args) {
        Map<String, Integer> map = new LinkedHashMap<>();

        map.put("giosd", 1);
        map.put("eioqd", 1);
        map.put("sjsiq", 1);
        map.put("djaid", 1);


        Set<String> set = map.keySet();
        for (String s : set) {
            System.out.println(s+":" + map.get(s));
        }
    }
}
