package com.cm.unselflist;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class mapTest {

    public static void main(String[] args) {

        Map<String, String> map = new ConcurrentHashMap<>();


        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 5));
                System.out.println(map);
            }, String.valueOf(i)).start();

        }
    }
}
