package com.cm.lock;

import java.util.concurrent.TimeUnit;

public class MyLockDemo {

    public static void main(String[] args) {

        Mylock mylock = new Mylock();

        new Thread(() -> {
            mylock.lock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            mylock.unlcok();
        },"A").start();

//        线程B必须等待A释放锁才能够获取
        new Thread(() -> {
            mylock.lock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            mylock.unlcok();
        },"B").start();
    }
}
