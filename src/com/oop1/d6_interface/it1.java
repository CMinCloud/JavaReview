package com.oop1.d6_interface;

public interface it1 {

//    public final static int a = 1;
    int a = 1;
//    public abstract int getA();
    int getA();

    static String inAddr(){
        return "接口的static实现方法...";
    }

    default String go(){
        return "接口的默认实现方法...";
    }
}
