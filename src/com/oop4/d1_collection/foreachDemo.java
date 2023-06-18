package com.oop4.d1_collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

public class foreachDemo {
    public static void main(String[] args) {
        Integer[] items = new Integer[]{1, 5, 8};
        Collection<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(items);
        System.out.println(list);
//        lambda类型遍历1
  /*      list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });*/
        list.forEach(integer -> System.out.println(integer));   //integer是方法参数
        /*list.forEach(System.out::println);*/
 /*       for (Integer integer : list) {
            System.out.println(integer);
        }*/

    }

}

