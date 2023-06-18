package com.cm.asyn;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class testCompletable {


    public static void main(String[] args) throws ExecutionException, InterruptedException {


        int[] arr = new int[2];
        int a = arr.length;
        FutureTask<String> futureTask = new FutureTask(() -> {
            Thread.sleep(2000);
            return UUID.randomUUID().toString();
        });

        new Thread(futureTask).start();     // 开启一个子线程去异步执行任务

        System.out.println("主线程等待中。。。。");
        CompletableFuture<String> future = CompletableFuture.completedFuture(futureTask.get());
        String uuid = future.get();
        System.out.println(uuid);
    }




}
