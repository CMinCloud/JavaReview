package com.cm.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author：CM
 * @Package：com.cm.lambda
 * @Project：JavaReview
 * @name：Lambda05mapReduce
 * @Date：2023/6/20 15:10
 * @Filename：Lambda05mapReduce
 */
public class Lambda05mapReduce {

    public static void main(String[] args) {
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        double bill = costBeforeTax.stream().map((cost) -> cost + cost * .12).reduce((sum, cost) -> sum + cost).get();
        System.out.println("Total : " + bill);


        flatMapDemo();
    }


    /**
     * 将多个stream连成一个stream
     */
    private static void flatMapDemo() {
        List<Integer> collect = Stream.of(Arrays.asList(1, 3), Arrays.asList(4, 6)).flatMap(a -> a.stream()).collect(Collectors.toList());
        collect.forEach(System.out::print);
    }
}
