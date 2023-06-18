package com.oop4.d5_stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamDemo2 {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        Collections.addAll(names,"张三","张无忌","张一山","张三丰","谢逊");
        names.forEach(s -> System.out.println(s));

        names.stream().filter(s -> s.startsWith("谢")).forEach(System.out::println);

/*        names.stream().filter(s -> s.startsWith("张")).forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
//                System.out.println(s);
            }
        });*/
//        names.stream().filter(s -> s.startsWith("张")).forEach(s -> System.out.println(s));
//        names.stream().forEach(s -> System.out.println(s));

        names.stream().map(new Function<String, Object>() {
            @Override
            public Object apply(String s) {
                return "黑马的"+s;
            }
        }).forEach(a->System.out.println(a));


        String collect = names.stream().map(str -> {
            return "hh" + str;
        }).collect(Collectors.joining(","));


        System.out.println(collect);
//        通过上面的中间方法获取流后并未修改原集合
        names.stream().forEach(System.out::println);
    }
}
