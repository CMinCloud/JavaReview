package com.oop3.d4_lambda;

public class LambdaDemo1 {
    public static void main(String[] args) {
        Animal tiger = new Animal() {
            @Override
            public void run() {
                System.out.println("tiger run ...");
            }
        };
        tiger.run();

        System.out.println("--------------------------");
//        函数式接口
        test(()->{
            System.out.println("哈哈哈哈");
        });
    }


   public static void test(Swimming s){   //传入一个接口的实现类作为参数
       System.out.println("开始...");
       s.swim();
       System.out.println("结束...");
   }


}

abstract class Animal {
    public abstract void run();
}

interface Swimming {
    void swim();
}
