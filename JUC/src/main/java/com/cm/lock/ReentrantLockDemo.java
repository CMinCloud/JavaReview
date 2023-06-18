package com.cm.lock;

public class ReentrantLockDemo {

    private int a;

    public static void main(String[] args) {

        new Thread(() -> {
            synchronized (ReentrantLockDemo.class) {
                System.out.println("第1次获取到该锁=》" + ReentrantLockDemo.class);
            }
            int index = 1;
            while (true) {
                synchronized (ReentrantLockDemo.class) {
                    System.out.println("第" + ++index + "次获取到该锁=》" + ReentrantLockDemo.class);
                }
                if (index == 10)
                    break;
            }
        }, "A").start();

    }
}
