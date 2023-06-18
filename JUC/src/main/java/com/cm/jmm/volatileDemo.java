package com.cm.jmm;

import java.util.concurrent.TimeUnit;

public class volatileDemo {

    private static volatile int num = 0;

//    volatile保证可见性，但不保障原子性
    public static void main(String[] args) {
        new Thread(() -> {
            while (num == 0) {
//                循环执行
                System.out.println(Thread.currentThread().getName()+"开始循环");
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("结束循环");
        }).start();


        //        主线程执行
        System.out.println("主线程等待操作---");
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(1);
            num = 1;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }





    }
}
