package com.oop6.d1_thread;

public class ThreadDemo2 extends Thread {

    public ThreadDemo2(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("正在运行:"+getName()) ;
    }
}
