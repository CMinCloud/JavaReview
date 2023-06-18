package com.cm.jmm;

public class singleton {

    private static volatile singleton uniqueInstance;

    //    构造器私有化，实现单例模式
    private singleton() {
        System.out.println(Thread.currentThread().getName()+"调用私有构造器初始化:"+this);
    }

    public static singleton getInstance() {
        if (uniqueInstance == null) {
            synchronized (singleton.class) {
                if (uniqueInstance == null) {
                    //                双重校验
                    uniqueInstance = new singleton();
                }
            }
        }
        return uniqueInstance;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                singleton instance = singleton.getInstance();
                System.out.println(singleton.getInstance());
            },String.valueOf(i)).start();
        }








    }
}
