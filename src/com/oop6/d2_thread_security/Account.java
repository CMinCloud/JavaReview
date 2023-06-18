package com.oop6.d2_thread_security;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

    private long cardId;
    //    public static double money;
    private double money;

    //    创建一个不可变的锁对象
    private final Lock lock = new ReentrantLock();

    public Account(long cardId, double money) {
        this.cardId = cardId;
        this.money = money;
    }

    public Account() {
    }

    public long getCardId() {
        return cardId;
    }

    public void setCardId(long cardId) {
        this.cardId = cardId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    //    取钱:使用同步代码块
/*    public void drawMoney(long money) {
        Thread thread = Thread.currentThread();

//        设置同步代码块 (字符串在字符串常量池中是唯一的，所以可以用来做锁)
        System.out.println(thread.getName() + "来取钱：" + money);
        synchronized (this) {
            if (this.money >= money) {
                this.money -= money;
                System.out.println(thread.getName() +"取钱成功,剩余" + this.money);
            } else {
                System.out.println(thread.getName()+"取钱失败，余额不足!");
            }
        }
    }*/

    //    使用同步方法
/*    public synchronized void  drawMoney(long money) {
        Thread thread = Thread.currentThread();

//        设置同步代码块 (字符串在字符串常量池中是唯一的，所以可以用来做锁)
        System.out.println(thread.getName() + "来取钱：" + money);

        if (this.money >= money) {
            this.money -= money;
            System.out.println(thread.getName() + "取钱成功,剩余" + this.money);
        } else {
            System.out.println(thread.getName() + "取钱失败，余额不足!");
        }
    }*/


    //    3.使用lock锁对象
    public void drawMoney(long money) {
        Thread thread = Thread.currentThread();

//        上锁
        lock.lock();
        try {
            System.out.println(thread.getName() + "来取钱：" + money);

            if (this.money >= money) {
                this.money -= money;
                System.out.println(thread.getName() + "取钱成功,剩余" + this.money);
            } else {
                System.out.println(thread.getName() + "取钱失败，余额不足!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
