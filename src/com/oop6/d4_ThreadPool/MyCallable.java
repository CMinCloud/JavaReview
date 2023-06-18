package com.oop6.d4_ThreadPool;

import java.util.concurrent.Callable;

class MyCallable implements Callable<String> {
    private int n;

    public MyCallable(int n) {
        this.n = n;
    }

    //    2.重写call方法（任务方法）
    @Override
    public String call() throws Exception {
        int sum = 0;
        for(int i = 0 ; i<n ; i++){
            sum += i;
//            System.out.println("总循环次数："+n);
        }
        return Thread.currentThread().getName()+"计算的结果为："+ sum;
    }

}