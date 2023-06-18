package com.cm.utilclass;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(6);

        for (int i = 1; i <= 12; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();  //
                    System.out.println(Thread.currentThread().getName()+"抢到了车位");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println(Thread.currentThread().getName()+"离开了车位");
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}
