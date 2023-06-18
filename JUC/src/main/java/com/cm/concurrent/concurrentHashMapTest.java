package com.cm.concurrent;

import java.util.Hashtable;
import java.util.concurrent.atomic.AtomicBoolean;


/**
 * 测试hashtable的效率
 */
public class concurrentHashMapTest {

    public static void main(String[] args) {

        Hashtable<String, Integer> hashtable = new Hashtable<>();

        AtomicBoolean flag = new AtomicBoolean(false);
        long start = System.currentTimeMillis();
        System.out.println(start);

        new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
//                System.out.println("put=>" + i);
                hashtable.put(String.valueOf(i), i);
            }
        }, "T1").start();

        new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
//                System.out.println("take=>" + hashtable.get(String.valueOf(i)));
            }
            flag.set(true);
        }, "T2").start();

        while (flag.get() != true) {
//            等待
        }

        System.out.println(System.currentTimeMillis() - start);

    }
}
