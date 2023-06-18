package com.cm.jmm;

public class singletons {

    private static singletons Singletons;

    private singletons(){
        System.out.println(Thread.currentThread().getName()+"构造器私有化=>"+this);
    }


    public static singletons getInstance(){
        if(Singletons != null){
            return Singletons;
        }
//        创建方法
        synchronized (singletons.class){
            if(Singletons == null){
                Singletons = new singletons();
            }
        }
        return Singletons;
    }


    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(singletons.getInstance());
            },String.valueOf(i)).start();

        }
    }



}
