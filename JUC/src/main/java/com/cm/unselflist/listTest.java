package com.cm.unselflist;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class listTest {

    public static void main(String[] args) {

//        并发下ArraList是不安全的
//        原因：多个线程执行时，list读取的是固定的写入时执行覆盖操作
        /**
         * 解决方案1：Vector
         * 2: Collection.synchronized
         * 3: CopyOnWriteArrayList()
         *
         */
//        List<String> list = new ArrayList<>();
//        List<String > list = new Vector<>();
        List<String> list = Collections.synchronizedList(new ArrayList<>());
//        List<String> list = new CopyOnWriteArrayList();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
