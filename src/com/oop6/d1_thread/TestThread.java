package com.oop6.d1_thread;

import java.util.concurrent.atomic.AtomicInteger;

public class TestThread {

    public static void main(String[] args) {


/*        ThreadDemo1 t1 = new ThreadDemo1("t1111");
        ThreadDemo1 t2 = new ThreadDemo1("t2222");

        t1.start();
        t2.start();*/

/*        ThreadDemo2 t3 = new ThreadDemo2("t3");
        ThreadDemo2 t4 = new ThreadDemo2("t4");
        t3.start();
        t4.start();*/

/*        ThreadDemo1_1 target = new ThreadDemo1_1();
        Thread thread = new Thread(target);
        thread.start();*/

//        实现Runnable接口的 匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i<10;i++){
                    System.out.println("子线程输出:"+(i+1));
                }
            }
        }).start();





        for(int i = 0;i<10;i++){
//            主线程输出
            System.out.println("主线程输出:"+(i+1));
        }


        AtomicInteger atomic = new AtomicInteger(1);
        System.out.println(atomic);
    }
}
