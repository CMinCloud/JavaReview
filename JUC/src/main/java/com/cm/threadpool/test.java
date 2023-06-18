package com.cm.threadpool;
import java.util.concurrent.*;

public class test {

    public static void main(String[] args) throws Exception {
        int corePoolSize = 2;
        int maximumPoolSize = 5;
        long keepAliveTime = 5;

        int processors = Runtime.getRuntime().availableProcessors();//CPU可用线程数
        System.out.println(processors);

        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>(2);   //等待队列

//        四种拒绝策略：
//        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();    //抛出异常

//        RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();  //调用线程的是谁,就让谁来运行(并发性能小)

        ThreadPoolExecutor.DiscardPolicy handler = new ThreadPoolExecutor.DiscardPolicy();    //队列满了，直接丢弃任务，不会抛出异常

//        ThreadPoolExecutor.DiscardOldestPolicy handler = new ThreadPoolExecutor.DiscardOldestPolicy();//队列满了，尝试和最早的线程取竞争，也不会抛出异常

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                corePoolSize,
                processors-2,
                keepAliveTime,
                TimeUnit.SECONDS,
                workQueue,                              //排队队列
                Executors.defaultThreadFactory(),       //默认 线程池创建工厂
                handler);           //拒绝策略

        for (int i = 0; i < 10; i++) {
            try {
                executor.execute(new Thread(() -> System.out.println(Thread.currentThread().getName() + " is running")));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
//        executor.shutdownNow();
    }
}
