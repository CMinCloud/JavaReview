package com.oop1.d6_interface;

import java.io.Serializable;

public interface it2 extends Serializable {

//    public final static int a = 1;
    int b = 1;
//    public abstract int getA();
    int getB();

    default String go(){
        return "接口的默认实现方法...";
    }
}
