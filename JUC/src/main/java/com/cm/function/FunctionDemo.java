package com.cm.function;

import java.util.function.Function;


/**
 * 函数型接口:有一个输入参数T,有一个输出类型参数R
 */
public class FunctionDemo {


    public static void main(String[] args) {


/*        Function<String,String> func = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s;
            }
        };*/


        Function func = (str)->{
            return str;
        };

        System.out.println(func.apply("aaa"));
    }
}
