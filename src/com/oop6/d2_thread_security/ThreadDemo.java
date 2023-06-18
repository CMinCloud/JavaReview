package com.oop6.d2_thread_security;

public class ThreadDemo {

    public static void main(String[] args) {


        Account account = new Account(123,5000);

        // 执行两个线程来取钱
        new DrawThread(account,"zs").start();
        new DrawThread(account,"ls").start();
    }
}
