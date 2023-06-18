package com.oop6.d5_timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

public class timerDemo2 {

    public static void main(String[] args) {

//        创建线程池定时器
        ScheduledExecutorService pool = new ScheduledThreadPoolExecutor(3, Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

//       执行线程定时器
        pool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"giligiliAi~~~");
                int i = 1/0;
            }
        },1,TimeUnit.SECONDS);

        pool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"dudududu~~~");
            }
        },1,TimeUnit.SECONDS);

        pool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"dudududu~~~");
            }
        },1,TimeUnit.SECONDS);

        pool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"dudududu~~~");
            }
        },1,TimeUnit.SECONDS);

        pool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"dudududu~~~");

            }
        },1,TimeUnit.SECONDS);

        pool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"dudududu~~~");
            }
        },1,TimeUnit.SECONDS);

        pool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"dudududu~~~");
            }
        },1,TimeUnit.SECONDS);

        pool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"dudududu~~~");
            }
        },1,TimeUnit.SECONDS);

    }
}
