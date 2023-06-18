package com.oop4.d5_stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo1 {

    public static void main(String[] args) {
        /** --------------Collection集合获取流--------------------------------------- */

        List<String> list = new ArrayList<>();
        Stream<String> listStream = list.stream();

        /** --------------Map集合获取流--------------------------------------- */
        Map<String, Integer> map = new HashMap<>();
        Stream<Map.Entry<String, Integer>> KeyAndValueStream = map.entrySet().stream();
        Stream<String> keyStream = map.keySet().stream();
        Stream<Integer> valueStream = map.values().stream();

        /** --------------数组获取流--------------------------------------- */
        String[] strings = new String[]{};
        Stream<String> stringStream = Arrays.stream(strings);
        Stream<String> stringStream2 = Stream.of(strings);
        String stream = stream();
        System.out.println(stream);
    }


    //    stream调试测试
    public static String stream() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        String collect = list.stream().map(Integer::valueOf).distinct().map(each -> each + 1).map(each -> each.toString())
                .collect(Collectors.joining(","));
        return collect;
    }
}
