package com.ThreadLocal;


/**
 * 父子线程间共享数据
 */
public class inheritableThreadLocals {


    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("threadLocal父~");
        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
        inheritableThreadLocal.set("inheritableThreadLocal父~");
//        子线程打印父线程数据
        new Thread(()->{
            System.out.println(threadLocal.get());
            System.out.println(inheritableThreadLocal.get());
        }).start();
    }
}
