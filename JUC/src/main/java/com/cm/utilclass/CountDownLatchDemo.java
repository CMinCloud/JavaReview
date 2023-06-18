package com.cm.utilclass;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    private static int x = 6;
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch downLatch = new CountDownLatch(6);


        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() +"Go out");
                downLatch.countDown();    // 计数器-1
                x--;
            }, String.valueOf(i)).start();
        }

        downLatch.await();   //等待直到计数器归零才能往下执行


//       while(x != 0){
////           等待
//           System.out.println(Thread.currentThread().getName()+"等待中");
//       }
        System.out.println(Thread.currentThread().getName()+"_close");
    }
}
