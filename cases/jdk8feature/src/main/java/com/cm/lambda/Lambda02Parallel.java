package com.cm.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author：CM
 * @Package：com.cm.lambda
 * @Project：JavaReview
 * @name：Lambda02Parallel
 * @Date：2023/6/20 13:44
 * @Filename：Lambda02Parallel
 */
public class Lambda02Parallel {

    /*Lambda有两种模式，并行执行和顺序执行*/

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> collect = list.stream().parallel().collect(Collectors.toList());
        System.out.println(collect);

        parallerTest();
    }



    private static void parallerTest(){
            long t0 = System.nanoTime();

//            初始化一个范围100万的整数流，求能被2整除的数字，toArray()是终点方法

        int a[] = IntStream.range(0,1_000_0000).filter(p -> p%2 == 0).toArray();

        long t1 = System.nanoTime();        //系统时钟

//        和上面功能一样，这里使用并行流计算

        int b[] = IntStream.range(0,1_000_0000).parallel().filter(p -> p% 2 == 0).toArray();

        long t2 = System.nanoTime();

//        本机结果测试
        System.out.printf("serial: %.2fs,parallel: %.2fs%n",(t1-t0) * 1e-9, (t2-t1)* 1e-9);

    }
}
