package com.cm.function_interface;

/**
 * @Author：CM
 * @Package：com.cm.function_interface
 * @Project：JavaReview
 * @name：customed
 * @Date：2023/6/20 15:54
 * @Filename：customed
 */

/**
 * 自定义函数式接口
 */

//这个注解也可以不声明，编译器会将符合函数式接口的接口自动添加上@FunctionalInterface注解
@FunctionalInterface
public interface CustomedInterface {
    void test();

    default void test1(){

    }

    default void test2(){

    }
}



