package com.oop4.collectionReview;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class conCurrentHashMapDemo {

    public static void main(String[] args) {


        ConcurrentHashMap<String,Integer> map = new ConcurrentHashMap<>();

//        Map<String,Integer> map = new HashMap<>();


        Thread a = new Thread(()->{
            for (int i = 0; i < 500; i++) {
                map.put(String.valueOf(i),i);
            }
        });

        Thread b = new Thread(()->{
            for (int i = 0; i < 500; i++) {
                Integer integer = map.get(String.valueOf(i));
                System.out.println(integer);
            }
        });

        a.start();
        b.start();

        try {
            System.out.println("使用join子线程执行完后主线程才继续执行");
            a.join();
            b.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhh");
    }
}
