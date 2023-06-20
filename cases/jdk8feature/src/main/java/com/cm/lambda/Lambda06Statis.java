package com.cm.lambda;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author：CM
 * @Package：com.cm.lambda
 * @Project：JavaReview
 * @name：Lambda06Statis
 * @Date：2023/6/20 15:40
 * @Filename：Lambda06Statis
 */
public class Lambda06Statis {

    public static void main(String[] args) {
        statisCollection();
    }


    private static void statisCollection() {
        Integer max = Arrays.stream(new Integer[]{2, 4, 1, 3, 6, 5}).max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        }).get();
        System.out.println(max);
    }
}
