package com.oop5.d1_exception;


/**
 * 自定义异常
 * 1、继承Exception
 * 2、重写构造器
 */
public class customedException extends RuntimeException{

    public customedException(){

    }

    public customedException(String  message){
//        调用父类的构造器来套用
        super(message);
    }
}
