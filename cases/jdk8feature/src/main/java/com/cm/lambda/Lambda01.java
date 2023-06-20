package com.cm.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author：CM
 * @Package：com.cm.lambda
 * @Project：JavaReview
 * @name：Lambda01
 * @Date：2023/6/20 13:25
 * @Filename：Lambda01
 */
public class Lambda01 {

    private static int i = 0;
    public static void main(String[] args) {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        list.forEach(System.out::println);          //方法引用格式：类型::方法
//        当对参数有修改时，则不能使用
        list.forEach(s-> System.out.println("**"+s));

        List<Integer> primes = Arrays.asList(new Integer[]{2, 3,5,7});
        int factor = 2;
        primes.forEach(element -> { System.out.println(factor*element); });


        List<Integer> integerList = primes.stream().map(num -> num + 1).collect(Collectors.toList());
        System.out.println(integerList);
    }
}
