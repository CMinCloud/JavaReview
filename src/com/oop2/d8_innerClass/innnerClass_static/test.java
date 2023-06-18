package com.oop2.d8_innerClass.innnerClass_static;

public class test {

    public static void main(String[] args) {
        //创建内部类：
        Outer.Inner in = new Outer.Inner();
        //创建内部类
//        Outer outer = new Outer();
//        Outer.Inner inner = new Outer.Inner();

        in.setA(1);
        in.setStr("aa");
        in.show();   //打印外部类的静态成员
    }
}
