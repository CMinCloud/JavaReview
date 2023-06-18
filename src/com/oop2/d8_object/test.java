package com.oop2.d8_object;

import java.util.Objects;

public class test {
    public static void main(String[] args) {
        String s1 = "hhh";
        String s2 = new String("hhh");

        System.out.println(s1.equals(s2));   //String的equals方法比较内容是否一致
        System.out.println(s1 == s2);       //比较地址
        System.out.println(Objects.equals(s1,s2));      //较安全的比较地址是否相同
    }
}
