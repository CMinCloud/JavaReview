package com.cm.asyn;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

public class testCompletableFuture {


    public static void main(String[] args) throws IOException {


        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("异步线程"+Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3);
                System.out.println("");
                return UUID.randomUUID().toString();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return UUID.randomUUID().toString();
        });

        future.whenComplete((uuid, e) -> {
            System.out.println(uuid);
            System.out.println(Thread.currentThread().getName());
        });

        System.out.println(1111111);
        System.in.read();

    }
}
