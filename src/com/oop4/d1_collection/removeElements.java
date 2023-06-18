package com.oop4.d1_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 遍历的几种方式：
 * 1、fori循环：可能会漏判
 * 2、foreach循环：会ConcurrentModification错误，因为它还是封装了iterator，会进行检查修改
 * 3、iterator 中的remove方法，可以安全地删除元素
 * 4、通过stream流地过滤方式
 */
public class removeElements {


    public static void main(String[] args) {


        List<Integer> list = new ArrayList<>();

        Collections.addAll(list, 1, 1, 1, 4, 5, 6);

//        fori遍历删除
/*        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) == 1){
                list.remove(i);
                i--;
            }
            System.out.println("数组长度："+list.size());
        }*/


   /*     for (Integer integer : list) {
            if(integer == 6){
                list.remove(integer);
            }
        }*/

/*        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            if(iterator.next() == 1){
                iterator.remove();
            }
        }*/


        List<Integer> collect = list.stream().filter((i -> i != 1)).collect(Collectors.toList());

        System.out.println(list);
        System.out.println(collect);
    }
}
