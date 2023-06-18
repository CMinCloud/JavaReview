package com.oop4.d1_collection;

import java.util.ArrayList;
import java.util.List;

public class listDemo {

    public static void main(String[] args) {
        /**
         * List有序、可重复，有索引
         */
        List<String> list = new ArrayList<>();      // 多态

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

//        索引操作(底层原理是数组，所以查找比较快，增删效率低)
//        2.插入索引
        list.add(2, "11111");

//        3.根据索引删除元素
        list.remove(2);

//        4.根据 索引获取元素
        System.out.println(list.get(1));

//        5.修改索引位置处的元素
        list.set(3, "22");

//        返回修改前的数据
        System.out.println(list.set(3, "44"));

//        list.clear（）清空
    }
}
