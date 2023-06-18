package com.cm.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 使用lock实现线程通信
 */
public class SellTickets {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                ticket.sell();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                ticket.sell();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                ticket.sell();
            }
        }, "C").start();
    }
}

class Ticket {
    private Integer num = 50;
    Lock lock = new ReentrantLock();

    public void sell() {
        lock.lock();    // 加锁

//        System.out.println(lock.tryLock());

        try {
//            这里使用if，防止外层for循环进入后停留在while()中循环判断
            if (num > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出了" + (num--) + "张票，剩余" + num + "张票");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();      //释放锁
//             因为tryLock（）将返回一个布尔值，这意味着它将尽可能锁定，但如果锁被另一个线程锁定，它将立即返回false。
//              然后当你想在最后解锁时，由于当前线程没有持有锁，将抛出IllegalMonitorStateException。
        }
    }
}

