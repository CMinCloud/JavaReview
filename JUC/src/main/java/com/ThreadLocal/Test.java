package com.ThreadLocal;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static ThreadLocal<Integer> local = new ThreadLocal<>();

    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
//                    lock.lock();
                    Double d = Math.random() * 10;
                    local.set(d.intValue());
                    new A().get();
                    new B().get();
//                    lock.unlock();
                }
            }).start();
        }
    }

    static class A {
        public void get() {
            System.out.println(Thread.currentThread().getName()+":"+local.get());
        }
    }

    static class B {
        public void get() {
            System.out.println(Thread.currentThread().getName()+":"+local.get());
        }
    }

}
