package com.oop1.d4_reflect;

public class test {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("java.awt.List");
        System.out.println(aClass);
    }
}
