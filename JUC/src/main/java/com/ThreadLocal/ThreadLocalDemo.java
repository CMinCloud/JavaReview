package com.ThreadLocal;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadLocalDemo {

    private static ThreadLocal<BigMemory> threadLocal = new ThreadLocal<>();


    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try{
                    lock.lock();
                    BigMemory memory = new BigMemory();
                    threadLocal.set(memory);
                    System.out.println(Thread.currentThread().getName()+"=>新建了对象");
                threadLocal.remove();
                }finally {
                    lock.unlock();
                }
            }).start();
        }

/*        for (int i = 0; i < 10; i++) {
            BigMemory memory = new BigMemory();
            threadLocal.set(memory);
        }*/
    }


    static class BigMemory {
        //        20M
        private byte[] bytes = new byte[20 * 1024 * 1024];
    }
}
