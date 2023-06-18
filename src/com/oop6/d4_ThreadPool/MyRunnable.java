package com.oop6.d4_ThreadPool;

public class MyRunnable implements Runnable{
//    private String name;
//
//    public MyRunnable(String name){
//        this.name = name;
//    }

    @Override
    public void run() {
        for(int i = 0; i<20;i++){
            String name = Thread.currentThread().getName();
            System.out.println(name+"正在输出："+(i+1));
            try {
                System.out.println(Thread.currentThread().getName()+"进入了休眠");
                Thread.sleep(1000000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
