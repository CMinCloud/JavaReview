package com.oop6.d4_ThreadPool;

import java.util.concurrent.*;

public class threadDemo2 {

    public static void main(String[] args) throws Exception {
        //    1.创建线程池对象
        /**
         * 核心线程数：常驻线程3个
         * 最大线程数：5个
         * 临时线程存活时间：6s
         * 等待队列：1个
         */
        ExecutorService pool = new ThreadPoolExecutor(
                3,5,6, TimeUnit.SECONDS,new ArrayBlockingQueue<>(1),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

//    2.给线程池任务来处理,不会影响主线程的进行
        MyCallable call =new MyCallable(100);

        Future<String> f1 = pool.submit(call);
        Future<String> f2 = pool.submit(call);
        Future<String> f3 = pool.submit(call);
        Future<String> f4 = pool.submit(call);

        System.out.println(f1.get());
        System.out.println(f2.get());
        System.out.println(f3.get());
        System.out.println(f4.get());


    }



}
