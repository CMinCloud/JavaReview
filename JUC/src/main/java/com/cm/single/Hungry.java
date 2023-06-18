package com.cm.single;


/**
 * 饿汉式单例:提前创建好对象
 * 如果成员对象很多,那么会占过多空间
 */
public class Hungry {

    private Hungry() {
    }

    private final static Hungry hungry = new Hungry();

    public static Hungry getInstance() {
        return hungry;
    }
}
