package com.oop4.d1_collection;

import java.util.*;

/**
 * 集合的专用遍历方式：迭代器
 */
public class iteratorDemo {

    public static void main(String[] args) {

        Collection<Integer> list = new ArrayList<>();
        list.add(1);
/*        list.add(1);
        list.add(1);*/
        list.add(2);
        list.add(3);


//        list.removeIf(i -> i.equals(1));
        Iterator<Integer> iterator = list.iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

        /*       *
         * 使用迭代器删除，防止for循环索引后移   比如["1","1","1"]
         *                              会错过临近的一个
         * 不要使用foreach  循环遍历删除元素，删除后长度变更索引后移会溢出！！！！
         *  不要使用fori循环遍历删除，会漏删
         *  fori循环遍历删除解决办法：倒叙遍历删除，或者每次remove删除后 将索引-1*/

    /*    while(iterator.hasNext()){
            Integer integer = iterator.next();
            if(integer.equals(1)){
                iterator.remove();
            }
        }*/



//
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
        System.out.println(list);
    }
}
