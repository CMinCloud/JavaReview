package com.cm.demo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author：CM
 * @Package：com.cm.demo
 * @Project：JavaReview
 * @name：count
 * @Date：2023/5/27 22:39
 * @Filename：count
 */
public class count {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    static Object lock = new Object();
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                    for (int j = 0; j < 200; j++) {
                        atomicInteger.getAndIncrement();
                    }
            }).start();
        }

        System.out.println(atomicInteger);
    }
}
