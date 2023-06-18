package com.oop4.d1_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


// list反转
public class ListReverse {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7);
        System.out.println(list);
//        第一种方法是collect()把流放到一个列表中 - 然后在列表中使用Collections.reverse()方法，将其就地反转。
        Collections.reverse(list);
        System.out.println(list);

//        第二种方法，使用stream流包装方法
        list = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(list);
    }

}
