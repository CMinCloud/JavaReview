package com.oop4.d3_collection_set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetDemo1 {



    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();   //多态  ，也可以直接修改右边为LinkedList

        set.add("c");
        set.add("b");
        set.add("d");
        set.add("a");
        set.add("a");
        set.add("b");
        System.out.println(set);
    }
}
