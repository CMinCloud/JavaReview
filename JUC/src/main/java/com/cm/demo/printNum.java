package com.cm.demo;


public class printNum {

    private static int num = 100;

//    public static final Object lock = new Object();

    public static void main(String[] args) {

        Object lock = new Object();     // 设置一个对象作为共享资源，即锁

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    while (num > 0) {
                        System.out.println("线程1执行:" + num--);
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "1").start();

        new Thread(() -> {
            synchronized (lock) {
                while (num > 0) {
                    System.out.println("线程2执行:" + num--);
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "2").start();
    }
}
