package com.cm.single;


import java.lang.reflect.Constructor;

/**
 * 懒汉式单例:等到需要得时候再返回一个new 得对象
 */
public class Lazy {

    private static Lazy lazy = null;

    private Lazy() {
        System.out.println(Thread.currentThread().getName() + "构造出来的对象" + this);  //判断当前对象是否是新对象
    }

    //    等到需要得时候再使用lazy:这里需要加锁防止 并发问题:多个线程同时判断为NULL
    public static Lazy getInstance() {
        synchronized (Lazy.class) {
            if (lazy == null) {
                lazy = new Lazy();      // 不是一个原子性操作
                /**
                 * 分配内存空间 -> 执行构造方法,初始化对象 ->把这个对象指向这个空间
                 */
            }
            return lazy;
        }
    }

    public static void main(String[] args) {

//        使用多线程给测试并发下使用单例模式产生的对象
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                Lazy.getInstance();
            }, String.valueOf(i)).start();
        }


        /**
         * 通过反射来破解单例模式
         */
        Lazy l = null;
        try {
            Class<?> aClass = Class.forName("com.cm.single.Lazy");
            try {
//                这里会调用lazy的构造方法
                l = (Lazy) aClass.newInstance();

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("反射构造出来的对象"+l);
    }


}
