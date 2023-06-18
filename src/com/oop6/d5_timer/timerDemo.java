package com.oop6.d5_timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class timerDemo {

    public static void main(String[] args) {

//        1.创建定时器
        Timer timer = new Timer();
//        2.调用方法，设置定时任务

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"执行AAA~~~"+new Date());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },2000);  //延时2s

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"执行BBB~~~"+new Date());
            }
        },2000);  //延时2s
    }
}
