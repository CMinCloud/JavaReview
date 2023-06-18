package com.oop6.d1_thread;

import java.io.FileInputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadDemo3 {

    public static void main(String[] args) {
//        创建Callable任务对象
/*        Callable<String> call = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return null;
            }
        }*/
//        3.相比Runnable的优点： 可以抛出已检查出的异常，并返回call的执行结果（如果有值的的话）
        Callable<String> call = new MyCallable(100,"任务1");
        Callable<String> call2 = new MyCallable(200,"任务2");
//        4.将Callable任务对象交给FutureTask对象（实现了Runnable接口），可以交给Thread
        FutureTask<String> f1 = new FutureTask<>(call);
        FutureTask<String> f2 = new FutureTask<>(call2);
//        5.交给线程处理
        Thread t1 = new Thread(f1);
        Thread t2 = new Thread(f2);
//        6.启动线程
        t1.start();
        t2.start();
//        获取结果
        try {
            String s1 = f1.get();
            System.out.println("线程1的执行结果：" + s1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            String s2 = f2.get();
            System.out.println("线程2的执行结果：" + s2);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}

//1.定义一个任务类实现Callable接口，同时要申明线程任务执行完毕后的结果的数据类型
class MyCallable implements Callable<String> {
    private int n;

    private String name;

    public MyCallable(int n, String name) {
        this.n = n;
        this.name = name;
    }

    //    2.重写call方法（任务方法）
    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
            System.out.println(name+"总循环次数：" + i);
        }
        return String.valueOf(sum);
    }

}
