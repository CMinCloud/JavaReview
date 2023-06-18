package com.oop1.d6_interface;

public class test implements it1, it2 {
    @Override
    public int getA() {
//        return it1.a;
        return a;
    }

    @Override
    public String go() {
        return "重写两个接口重名的默认方法";
    }

    @Override
    public int getB() {
//        return it2.b;
        return b;
    }

    public static void main(String[] args) {
        test t = new test();
        System.out.println(t.getA());  //实现接口的方法
        System.out.println(it1.inAddr());   //接口的静态实现方法
        System.out.println(t.go());     //接口的默认实现方法
    }
}
