package com.oop6.d4_ThreadPool;

import java.util.concurrent.*;

public class threadDemo1 {

    public static void main(String[] args) {
        //    1.创建线程池对象
        /**
         * 核心线程数：常驻线程3个
         * 最大线程数：5个
         * 临时线程存活时间：6s
         * 等待队列：1个
         */
        ExecutorService pool = new ThreadPoolExecutor(
                3,5,6, TimeUnit.SECONDS,new ArrayBlockingQueue<>(1),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.DiscardPolicy());

//    2.给线程池任务来处理
        Thread thread = new Thread(new MyRunnable());
//        请求的任务为 n
//        核心线程未满，可以继续提交任务 ：此时运行线程数 n <= core
        pool.execute(thread);
        pool.execute(thread);
        pool.execute(thread);

//        核心线程正在运行，新增一个请求会进入等待队列  n = core+wait ,wait = 1
        pool.execute(thread);

//        核心线程正在运行，等待队列已满，又新增一个请求：会新增一个线程来运行  n = max,run = max -1 ,wait =1
        pool.execute(thread);

//        总线程数已满，任务队列已满     n = max +1, run = max ,wait = 1
        pool.execute(thread);

//       总线程数+任务队列已满，新增请求则拒绝  n = max + 2, run = max ,wait = 1
        pool.execute(thread);





    }



}
