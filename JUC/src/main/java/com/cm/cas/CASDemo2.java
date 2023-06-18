package com.cm.cas;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

public class CASDemo2 {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(100);

        LongAdder longAdder = new LongAdder();

        new Thread(()->{
            for (int i = 0; i < 50; i++) {
                longAdder.add(1L);
                countDownLatch.countDown();
            }
        }).start();

/*        new Thread(()->{
            for (int i = 0; i < 50; i++) {
                longAdder.add(1L);
                countDownLatch.countDown();
            }
        }).start();*/

        new Thread(()->{
            for (int i = 0; i < 50; i++) {
                longAdder.add(1L);
                countDownLatch.countDown();
            }
        }).start();

        countDownLatch.await();

        System.out.println(longAdder.sum());

    }
}
