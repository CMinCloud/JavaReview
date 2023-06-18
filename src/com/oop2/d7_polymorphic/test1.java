package com.oop2.d7_polymorphic;

public class test1 {
    public static void main(String[] args) {

//        1.多态的形式：父类类型 对象名称 = new 子类类型()
        Animal doge = new Dog();
        System.out.println(doge.type); //获得的是父类属性

        doge.run();   //方法调用：编译看左边，运行看右边


    }
}

