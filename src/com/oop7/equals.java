package com.oop7;

import java.util.ArrayList;
import java.util.Objects;

public class equals {

    public static void main(String[] args) {
        String a = new String("ab"); // a 为⼀个引⽤
        String b = new String("ab"); // b为另⼀个引⽤,对象的内容⼀样
        String aa = "ab"; // 放在常量池中
        String bb = "ab"; // 从常量池中查找
        if (aa == bb) // true
            System.out.println("aa==bb");
        if (a == b) // false，⾮同⼀对象
            System.out.println("a==b");
        if (a.equals(b)) // true
            System.out.println("aEQb");
        if (Objects.equals(a, b))  //true
            System.out.println("Object a EQ b");
        if (42 == 42.0)  // true
            System.out.println("true");

    }
}
