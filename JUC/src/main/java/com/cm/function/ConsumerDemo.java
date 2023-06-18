package com.cm.function;


import java.util.function.Consumer;

/**
 * 消费型接口:只有一个参数传入,没有返回值
 */
public class ConsumerDemo {

        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
    public static void main(String[] args) {

        Consumer consumer = (str) -> {
            System.out.println(str);
        };


        consumer.accept("aaa");
    }


}
