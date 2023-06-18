package com.cm.jmm;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {

//    private static volatile int num = 0;        // volatile并不能保证原子性

    private static AtomicInteger num = new AtomicInteger(0);    // 原子包装类

    public static void add() {
//        num++;
        num.getAndAdd(1);
    }

    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {

            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }

//        不包含main线程和gc线程
        while (Thread.activeCount() > 2){
            Thread.yield();
        }


        System.out.println(Thread.currentThread().getName() + "  " + num);

    }
}
