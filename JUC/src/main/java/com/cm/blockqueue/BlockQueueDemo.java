package com.cm.blockqueue;

import jdk.nashorn.internal.ir.Block;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class BlockQueueDemo {

    public static void main(String[] args) {

//        第一组会抛出异常API演示 add remove element
//        test1();


//        第二组不会抛出异常演示： offer poll peak
//        test2();

//        第三组存放不进去会被阻塞（可以设置等待时间） put take
//        test3();

//        测试同步队列
        test4();


    }


    /**
     * 抛出异常
     */
    public static void test1() {
        //指定队列大小
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        //add添加成功返回true
        System.out.println(arrayBlockingQueue.add("1"));
        System.out.println(arrayBlockingQueue.add("2"));
        System.out.println(arrayBlockingQueue.add("3"));
        //查看队首的元素是谁 1
        System.out.println(arrayBlockingQueue.element());
        //超过队列大小 add会抛出异常  Queue full
//        System.out.println(arrayBlockingQueue.add("4"));
        //remove取出一个元素  返回取出的值   如果队列为空  remove会抛出异常
        // NoSuchElementException
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
    }


    /**
     * 不会抛出异常
     */
    public static void test2() {
        //队列的大小
        ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(2);
        //offer  添加一个元素  返回一个boolean值   成功返回true失败返回true
        System.out.println(blockingQueue.offer(1));
        System.out.println(blockingQueue.offer(2));
        System.out.println(blockingQueue.offer(3));
        System.out.println("----------------");
        //检测队首元素
        System.out.println(blockingQueue.peek());
        //poll  取出一个元素  返回一个元素    队列为空时 取出null
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.peek());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
    }


    /**
     * 等待 一直阻塞
     */
    public static void test3() {
        ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(2);


        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    blockingQueue.put(String.valueOf(i));
                    System.out.println(Thread.currentThread().getName() + "put" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "publisher").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    //获取不到就阻塞等待
                    System.out.println(Thread.currentThread().getName() + "take=>" + blockingQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "consumer").start();

/*        try {
            //put添加元素 没有返回值 满了一直阻塞
            //队列大小为二   第三个元素放不进去   阻塞两秒过后就会结束
            blockingQueue.put("1");
            blockingQueue.put("2");
//            blockingQueue.put("3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            //取出元素  空了一直阻塞  返回值取出的元素
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }


    //    测试同步队列 SynchronousQueue<>()

    /**
     * 和其他的BlockingQueue 不一样，SynchronousQueue不存储元素
     * put一个元素，必须从里面先take出来，否则不能再put进去
     */
    public static void test4() {
        BlockingQueue<Object> queue = new SynchronousQueue<>();


        new Thread(() -> {

            try {
                System.out.println(Thread.currentThread().getName() + "put 1");
                queue.put(1);
                System.out.println(Thread.currentThread().getName() + "put 2");
                queue.put(2);
                System.out.println(Thread.currentThread().getName() + "put 3");
                queue.put(3);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }, "T1").start();


        new Thread(() -> {

            try {
                Thread.sleep(200);
                System.out.println(Thread.currentThread().getName() + "==>" + queue.take());
                Thread.sleep(200);
                System.out.println(Thread.currentThread().getName() + "==>" + queue.take());
                Thread.sleep(200);
                System.out.println(Thread.currentThread().getName() + "==>" + queue.take());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }, "T2").start();
    }


}
