package com.cm.demo;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 模拟生产者消费者问题
 */
public class pc {

    public static void main(String[] args) {
        Data data = new Data();

        int max = 10;
        new Thread(() -> {
            for (int i = 0; i < max; i++) {
                data.increment();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < max; i++) {
                data.decrement();
            }
        }, "B").start();

    }

}


class Data {

    private int number = 0;


    public synchronized void increment() {
//        使用while解决虚假唤醒问题
        while (number != 0) {
//            等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        执行业务
        number++;
        System.out.println(Thread.currentThread().getName() + "=>" + number);
//        通知
        notify();   // 默认锁是this
    }

    public synchronized void decrement() {
//        使用while解决虚假唤醒问题
        while (number == 0) {
//            等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        执行业务
        number--;
        System.out.println(Thread.currentThread().getName() + "=>" + number);
//        通知
        notify();   // 默认锁是this
    }
}