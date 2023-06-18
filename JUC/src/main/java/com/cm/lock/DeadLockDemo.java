package com.cm.lock;

import java.util.concurrent.TimeUnit;

public class DeadLockDemo {

    private static Resource resource1 = new Resource();
    private static Resource resource2 = new Resource();

    public static void main(String[] args) {

        new Thread(() -> {
            synchronized (resource1){
                System.out.println(Thread.currentThread().getName()+"获取到了resource1，需要获取resource2");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resource2){
                    System.out.println(Thread.currentThread().getName()+"获取到了resource2，可以释放锁");
                }
            }
        },"A").start();


        new Thread(() -> {
            synchronized (resource2){
                System.out.println(Thread.currentThread().getName()+"获取到了resource2，需要获取resource1");
                synchronized (resource1){
                    System.out.println(Thread.currentThread().getName()+"获取到了resource1，可以释放锁");
                }
            }
        },"B").start();
    }
}


class Resource {
}
