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
