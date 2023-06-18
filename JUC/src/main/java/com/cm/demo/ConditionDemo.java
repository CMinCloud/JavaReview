package com.cm.demo;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


//使用condition来实现线程通信
public class ConditionDemo {

    public static void main(String[] args) {
        Data2 data = new Data2();

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


class Data2 {

    private int number = 0;

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void increment() {
        lock.lock();        //锁住ReentrantLock对象
        try {
            while (number != 0) {
                //            等待
                condition.await();
            }
            //        执行业务
            number++;
            System.out.println(Thread.currentThread().getName() + "=>" + number);
//        通知
//        notify();   // 默认锁是this
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();        //锁住ReentrantLock对象
        try {
            while (number == 0) {
                //            等待
                    condition.await();
            }
            //        执行业务
            number--;
            System.out.println(Thread.currentThread().getName() + "=>" + number);
//        通知
//        notify();   // 默认锁是this
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}