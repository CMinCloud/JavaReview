package com.unsafe.threadExecutor;

import javax.annotation.PostConstruct;
import java.util.concurrent.*;

public class shutDown {

    private static final ExecutorService executor = new ThreadPoolExecutor(
            3, 5, 2, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(1), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy()
    );
    private  static BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue(1024);




    static void asyncExecuteOne() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            System.out.println("--async execute one ---");
        });
        executor.shutdown();        //只有执行了shutdown方法后才会关闭线程池（会处理完当前正在运行的线程，包括任务队列中等待的线程）
    }

    static void asyncExecuteTwo() {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.execute(() -> {
            System.out.println("--async execute two ---");
        });
        executor.shutdown();
    }

    public static void main(String[] args) {
 /*       //(1)同步执行
        System.out.println("---sync execute---");
        //(2)异步执行操作one
        asyncExecuteOne();
        //(3)异步执行操作two
        asyncExecuteTwo();
        //(4)执行完毕
        System.out.println("---execute over---");*/


        for (int i = 0; i < 50; i++) {

            System.out.println("主线程创建了一个任务交给异步线程=>" + i);
            blockingQueue.add(i);
        }


        Future<?> submit = executor.submit(() -> {
            while (true) {
                Integer task = blockingQueue.take();
                System.out.println("线程池" + Thread.currentThread().getId() + "正在处理=》" + task);
            }
        });
        Object o = null;
        try {
            o = submit.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(o);

    }
}
