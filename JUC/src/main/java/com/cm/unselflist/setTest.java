package com.cm.unselflist;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class setTest {

    public static void main(String[] args) {
//        Set<String> set = new HashSet<>();
        /**
         * 解决方案1：Vector
         * 2: Collection.synchronized
         * 3: CopyOnWriteArrayList() 解决：多个线程执行时，list读取的是固定的写入时执行覆盖操作
         */




        Set<String > set = Collections.synchronizedSet(new HashSet<>());
//        Set<String> set = new CopyOnWriteArraySet();
         AtomicInteger count = new AtomicInteger(1);
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(count.getAndIncrement() +":"+set);
            }, String.valueOf(i)).start();
        }
    }
}
