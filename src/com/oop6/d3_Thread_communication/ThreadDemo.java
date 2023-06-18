package com.oop6.d3_Thread_communication;

public class ThreadDemo {

    public static void main(String[] args) {
        Account account = new Account(403630,0) ;   //创建一个共享资源来存钱

        new DrawThread(account,"zs").start();
        new DrawThread(account,"ls").start();

        new DepositThread(account,"亲爹").start();
        new DepositThread(account,"义父").start();
        new DepositThread(account,"干爹").start();
    }
}
