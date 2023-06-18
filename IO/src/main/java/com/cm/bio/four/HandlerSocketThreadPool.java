package com.cm.bio.four;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池处理类，用来处理客户端的请求
 */
public class HandlerSocketThreadPool {

    //    内部实现线程池
    private ExecutorService executorService;

    public HandlerSocketThreadPool(int maxPoolSize, int queueSize) {
        executorService = new ThreadPoolExecutor(
                3, maxPoolSize, 120L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(queueSize)
//                使用默认抛出策略
        );
    }


    public void excute(Runnable task) {
        executorService.execute(task);
    }


}
