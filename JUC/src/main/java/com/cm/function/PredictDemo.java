package com.cm.function;

import java.util.function.Function;
import java.util.function.Predicate;


/**
 * 断定型接口:有一个输入参数,返回值只能是boolean
 */
public class PredictDemo {
    public static void main(String[] args) {
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.isEmpty();
            }
        };

        System.out.println(predicate.test(""));
    }
}
