package com.cm.asyn;


import java.time.Year;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 测试异步回调：CompletableFuture
 */
public class AsyncDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        test1();
        test2();
//
    }

    public static void test1() throws ExecutionException, InterruptedException {
        //        无返回值
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //另一个线程异步执行
            System.out.println(Thread.currentThread().getName() + "  runAsync=>void");
        });

        System.out.println(Thread.currentThread().getName() + "1111");  // 主线程输出

        // 主线程调用，会先执行异步操作
        System.out.println(Thread.currentThread().getName() + "  " + completableFuture.get());
        // 获取阻塞结果,也是由主线程调用，串行执行


    }


    //    有返回值的异步回调
    public static void test2() throws ExecutionException, InterruptedException {


        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "runSupplier=>String");
            int i = 10 / 0;
            return "test2";
        });

//          主线程调用，会先打印completableFuture中的回调方法,之后打印返回值 "test2"
//        System.out.println(Thread.currentThread().getName() + ":" + completableFuture.get());

//        消费者接口: 当completableFuture执行成功后会执行
        CompletableFuture<String> completableFuture1 = completableFuture.whenComplete((t, u) -> {
            System.out.println("when completableFuture active--------------");
            System.out.println("u=>" + t);      // 正常输出
            System.out.println("v=>" + u);      // 打印错误信息（正常时为null）
        }).exceptionally((e) -> {
            System.out.println(e.getMessage());
            return "2233";
        });

//       主线程获取到异步执行的返回结果0
        System.out.println(Thread.currentThread().getName() + ":" + completableFuture1.get());
    }
}
