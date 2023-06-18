package com.oop4.d5_stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {

//        1.初始化数据
        List<String> names = new ArrayList<>();
        Collections.addAll(names,"张三","张无忌","张一山","张三丰");
        System.out.println(names);

//        2.查找以张开头的姓名
        List<String > ZhangList = new ArrayList<>();
        for (String name : names) {
            if(name.startsWith("张")){
                ZhangList.add(name);
            }
        }

        System.out.println(ZhangList);

//        3.使用Stream流来输出数据(支持链式编程)
        Stream<String> stringStream = names.stream().filter(s -> s.startsWith("张")).filter(s -> s.length() == 3);
        stringStream.forEach(s -> System.out.println(s));


        Stream<String> stringStream1 = names.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return false;
            }
        });
        System.out.println(stringStream1);
    }
}
