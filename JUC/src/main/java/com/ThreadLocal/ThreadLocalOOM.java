package com.ThreadLocal;


import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 测试使用线程池场景下，ThreadLocal的内存泄露
 * 设置初始内存和最大内存 -Xmx100m  -Xms100m
 */
public class ThreadLocalOOM {

    private static ThreadLocal<BigMemory> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 1,
                TimeUnit.MINUTES, new LinkedBlockingQueue<>());

        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(() -> {
                System.out.println(Thread.currentThread().getName()+"创建对象：");
                BigMemory bigMemory = new BigMemory();          // 20M
                threadLocal.set(bigMemory);
//                bigMemory = null;  //将对象设置为null，表示此对象不再使用了，此时如果不remove会出现内存泄露
//                threadLocal.remove();       //不管key加不加null，不remove的话最终可能会内存溢出
            });
        }
    }


    static class BigMemory {
        //        20M
        private byte[] bytes = new byte[20 * 1024 * 1024];
    }
}
