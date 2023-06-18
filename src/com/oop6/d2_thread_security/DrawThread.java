package com.oop6.d2_thread_security;



//创建一个线程类用来  执行取钱的任务
public class DrawThread extends Thread{

    private Account account;

    public DrawThread(Account account,String name){
        super(name);            // 调用父类的构造方法存储线程名字
        this.account = account;
    }

    @Override
    public void run() {
        account.drawMoney(5000);
    }
}
