package com.oop1.d5_final;

public class test1 {
    public static void main(String[] args) {
        //final修饰基本类型变量，变量值不能发生改变
        final double a = 0.01;
//        a = 0.02;
        //final修饰引用类型变量，变量存储地址不能发生改变(堆内存中)、地址指向的对象能够发生改变
        A a1 = new A(19);
        a1.setAge(20);

    }
}

class A{
    private int age;

    public A(int age){
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}