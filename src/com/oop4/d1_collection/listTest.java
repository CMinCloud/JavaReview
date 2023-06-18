package com.oop4.d1_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class listTest {
    public static void main(String[] args) {
        Collection<String > list = new ArrayList<>();

        list.add("aaa");
        list.add("bbb");


        Object[] objects = list.toArray();  //多态
        String s = Arrays.toString(objects);
        System.out.println(s);
    }

}
