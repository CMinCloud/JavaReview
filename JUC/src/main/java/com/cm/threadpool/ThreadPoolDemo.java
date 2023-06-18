package com.cm.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {


    public static void main(String[] args) {


//        ExecutorService threadPool = Executors.newSingleThreadExecutor();//单个线程

//        ExecutorService threadPool = Executors.newFixedThreadPool(5);// 创建一个固定的线程池大小

        ExecutorService threadPool = Executors.newCachedThreadPool();//可伸缩的线程池大小，遇强则强遇弱则弱


        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + ":OK");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();  // 关闭线程池
        }


    }
}
