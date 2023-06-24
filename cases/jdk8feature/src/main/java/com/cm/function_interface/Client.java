package com.cm.function_interface;

/**
 * @Author：CM
 * @Package：com.cm.function_interface
 * @Project：JavaReview
 * @name：Client
 * @Date：2023/6/20 15:56
 * @Filename：Client
 */
public class Client {

    public static void main(String[] args) {
        CustomedInterface customedInterface = ()-> System.out.println("testaaaa");
        customedInterface.test();
    }
}


class A implements CustomedInterface{

    @Override
    public void test() {

    }


    @Override
    public void test1() {
        CustomedInterface.super.test1();
        System.out.println("重写了接口的默认方法");
    }
}
