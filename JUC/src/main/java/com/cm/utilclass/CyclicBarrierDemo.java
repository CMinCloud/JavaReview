package com.cm.utilclass;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("计数器达到要求~");
        });


        for (int i = 1; i <= 7; i++) {
            final int temp = i;         // 注意new Thread为一个新类不能拿到i这个局部变量
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+":"+temp);
                try {
                    cyclicBarrier.await();      //等待直到计数器达到目标数值
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }


        cyclicBarrier.await();   //等待计数器达到7

        System.out.println("aaa");


    }

}
