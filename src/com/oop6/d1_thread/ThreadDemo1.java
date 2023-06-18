package com.oop6.d1_thread;

public class ThreadDemo1 implements Runnable {

    private Thread t;
    private String threadName;

    public ThreadDemo1(String threadName) {
        this.threadName = threadName;
    }


    @Override
    public void run() {
//        调用该方法即可开启线程
        for (int i = 0; i <5 ; i++) {
            System.out.println(threadName+"输出：" + i+1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread " +  threadName + " interrupted.");
            }
        }
        System.out.println("Thread " +  threadName + " exiting.");   //线程结束
    }

//    开启线程
    public void start(){
        if(t == null){
            t = new Thread(this,threadName);   //新建线程
            t.start();   //开启线程
        }
    }
}
