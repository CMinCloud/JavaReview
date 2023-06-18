package com.cm.readwriteLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {

    public static void main(String[] args) {
//        Mycache mycache = new Mycache();

        MyCacheLock mycache = new MyCacheLock();

        for (int i = 1; i <= 5; i++) {
            final int temp = i;
            new Thread(() -> {
                mycache.put(temp + "", temp + "");
            }, String.valueOf(i)).start();
        }

        for (int i = 1; i <= 5; i++) {
            final int temp = i;
            new Thread(() -> {
                mycache.get(temp + "");
            }, String.valueOf(i)).start();
        }

    }
}


class Mycache {

    private Map<String, Object> map = new HashMap<>();

    //    写入操作
    public void put(String key, Object value) {
        System.out.println(Thread.currentThread().getName() + "写入" + key);
        map.put(key, value);
        System.out.println(Thread.currentThread().getName() + "写入OK");
    }

    //    读取操作
    public void get(String key) {
        System.out.println(Thread.currentThread().getName() + "读取" + key);
        map.get(key);
        System.out.println(Thread.currentThread().getName() + "读取OK");
    }
}

class MyCacheLock {
    //    volatile字段提供线程间的可见性
    private volatile Map<String, Object> map = new HashMap<>();

    //读写锁对象
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    //    写入操作
    public void put(String key, Object value) {
        try {
            //        上写锁（独占锁）其他线程不能访问
            readWriteLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + "写入" + key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "写入OK");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();  //解锁
        }
    }

    //    读取操作
    public void get(String key) {
        try {
            readWriteLock.readLock().lock();
//            上读锁（共享锁）：其他线程均可以访问
            System.out.println(Thread.currentThread().getName() + "读取" + key);
            map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取OK");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}
