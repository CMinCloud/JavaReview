package com.cm.lock;


import java.util.concurrent.atomic.AtomicReference;

/**
 * 自定义一个自旋锁
 */
public class Mylock {

    private AtomicReference atomicReference = new AtomicReference(true);


    public void lock() {
        System.out.println(Thread.currentThread().getName() + "获取锁");

        while (!atomicReference.compareAndSet(true, false)) {
//            自选等待 锁的释放
        }
    }

    public void unlcok() {
        System.out.println(Thread.currentThread().getName() + "释放锁");
        atomicReference.compareAndSet(false, true);
    }
}
