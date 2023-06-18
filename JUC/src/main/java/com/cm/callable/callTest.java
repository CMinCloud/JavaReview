package com.cm.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class callTest {


    public static void main(String[] args) {

        FutureTask<String> futureTask = new FutureTask<>(new MyCallable2());
        new Thread(futureTask,"A").start();
        try {
            String s = futureTask.get();
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}


class MyCallable2 implements Callable<String> {


    @Override
    public String call() throws Exception {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(i);
            Thread.sleep(500);
        }
        return sb.toString();
    }
}
