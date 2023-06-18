package com.cm.nonblockingqueue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class conCurrentLinkedQueue {

    private static ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();


    public static void main(String[] args) {

        new Thread(() -> {
            for(int i = 0 ; i< 20 ;i++){
                queue.add(String.valueOf(i));
                System.out.println(Thread.currentThread().getName()+"=>"+i);
            }
        },"A").start();


        new Thread(() -> {
            for(int i = 0 ; i< 20 ;i++){
                String poll = queue.poll();
                while(poll == null){
                    System.out.println("等待了一下");
                    poll = queue.poll();
                }
                System.out.println(Thread.currentThread().getName()+"=>"+poll);
            }
        },"B").start();

    }
}
