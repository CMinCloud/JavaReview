package com.oop6.d3_Thread_communication;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

    private long cardId;
    //    public static double money;
    private double money;


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

    //    存钱
    public synchronized void depositMoney(double money) {
        try {
            String name = Thread.currentThread().getName();
            if (this.money == 0) {
                this.money += money;
                System.out.println(name + "存钱成功，余额为" + this.money);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //        存完钱，唤醒其他线程
            this.notifyAll();
            try {
//                当前线程等待
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    //    取钱
    public synchronized void drawMoney(double money) {
        String name = Thread.currentThread().getName();
        if (this.money > 0) {
            this.money -= money;
            System.out.println(name + "取钱成功，余额为" + this.money);
//            唤醒其他线程
            this.notifyAll();   // 唤醒所有线程
            try {
                this.wait();   //锁对象，当前线程等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(name + "取钱失败，余额不足,当前余额为：" + this.money);
            this.notifyAll();
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
