package com.oop1.d4_reflect;

import java.lang.reflect.Method;

public class MethodDemo {

    public static void main(String[] args) throws Exception{
        getDeclaredMethods();
    }

    public static void getDeclaredMethods() throws Exception {
//        反射第一步：获取类对象
        Class<?> c = Class.forName("com.oop1.d4_reflect.Student");
        Method[] methods = c.getDeclaredMethods();

        for (Method method : methods) {
            System.out.println(method.getName()+",参数个数:"+method.getParameterCount());
        }

    }
}
