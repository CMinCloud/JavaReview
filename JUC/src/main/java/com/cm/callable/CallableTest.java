package com.cm.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {

    public static void main(String[] args) {

        FutureTask<String> task = new FutureTask<>(new MyCallable());
        new Thread(task,"A").start();
//        获取结果
        try {
            System.out.println(task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}



class MyCallable implements Callable<String>{


    @Override
    public String call() throws Exception {
        return "2333";
    }
}
