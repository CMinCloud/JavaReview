package com.oop1.d4_reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class InvokeTest {

    private String name;
    private int age;

    public InvokeTest(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println(name+","+age);
    }

    public InvokeTest(){}

    public static void main(String[] args) throws Exception {
        invokeDemo();
    }

    public void test(String[] args) {
        for (String s : args) {
            System.out.println(s);
        }
    }

    public static void invokeDemo() throws Exception {
//        1.使用通配符来指定不确定的类型:       获取类的对象
        Class<?> aClass = Class.forName("com.oop1.d4_reflect.InvokeTest");
//        2.形式一：获取一个构造器对象   (这里获取的是指定的有参构造器)
        Constructor con = aClass.getDeclaredConstructor(String.class,int.class);
        InvokeTest invokeTest = (InvokeTest) con.newInstance("zs",1);     // 构建一个对象实例

/*        形式二：直接new对象，实际上不是框架的话，自己写代码直接指定某个对象创建并调用也可以
        InvokeTest invokeTest = new InvokeTest();*/
        String[] s = new String[]{"handsome", "smart"};
//        获取Method对象(根据参数调用对应的方法，是不是很神奇！！！,比方说这里是test，就调用test方法)
        Method method = aClass.getMethod("test", String[].class);  //方法名 和 参数类型
//        调用方法
        method.invoke(invokeTest, (Object) s);
    }
}
