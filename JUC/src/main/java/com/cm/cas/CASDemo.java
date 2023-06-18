package com.cm.cas;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class CASDemo {


    public static void main(String[] args) {



//        内存中是期望值则更新
/*        System.out.println(atomicInteger.compareAndSet(2022, 2023));
        System.out.println(atomicInteger.getAndIncrement());   // 得到内存中的值并+1   2023=>2024

        System.out.println(atomicInteger.compareAndSet(2024, 2023));
        System.out.println(atomicInteger.get());*/
        AtomicInteger atomicInteger = new AtomicInteger(1);

        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                atomicInteger.compareAndSet(1, 2);
                System.out.println(Thread.currentThread().getName() + "=>"+atomicInteger.get());
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                atomicInteger.compareAndSet(2, 1);
                System.out.println(Thread.currentThread().getName() + "=>"+atomicInteger.get());
            }
        }, "B").start();

    }
}
