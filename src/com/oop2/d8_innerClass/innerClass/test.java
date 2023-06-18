package com.oop2.d8_innerClass.innerClass;

import com.oop2.d8_innerClass.innnerClass_static.People;

public class test {

    public static void main(String[] args) {
//        成员内部类的构建
        Outer.Inner inner = new Outer().new Inner("zs",18);
        inner.InnerShow();   //调用成员内部类的方法
//        inner.getAge();


        People.Heart heart = new People().new Heart();
        heart.show();
    }
}
