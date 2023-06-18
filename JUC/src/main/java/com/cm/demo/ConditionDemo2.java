package com.cm.demo;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 使用condition来实现线程通信,并按顺序执行
 */
public class ConditionDemo2 {

    public static void main(String[] args) {
        Data3 data = new Data3();

        new Thread(
                () -> {
                    for (int i = 0; i < 10; i++) {
                        data.printA();
                    }
                }, "A").start();

        new Thread(
                () -> {
                    for (int i = 0; i < 10; i++) {
                        data.printB();
                    }
                }, "B").start();

        new Thread(
                () -> {
                    for (int i = 0; i < 10; i++) {
                        data.printC();
                    }
                }, "C").start();


    }

}


class Data3 {

    private int number = 1;

    Lock lock = new ReentrantLock();
//    声明condition对象
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public void printA() {
        lock.lock();        //锁住ReentrantLock对象
        try {
            while (number != 1) {
//            等待
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName() + "=>" + number);
//            通知
            number = 2;
            condition2.signal();
            //        执行业务
        } catch (
                Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void printB() {
        lock.lock();        //锁住ReentrantLock对象
//        lock.tryLock();
        try {
            while (number != 2) {
//            等待
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName() + "=>" + number);
//            通知
            number = 3;
            condition3.signal();

            //        执行业务
        } catch (
                Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void printC() {
        lock.lock();        //锁住ReentrantLock对象
        try {
            while (number != 3) {
//            等待
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName() + "=>" + number);
//            通知
            number = 1;
            condition1.signal();

            //        执行业务
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}