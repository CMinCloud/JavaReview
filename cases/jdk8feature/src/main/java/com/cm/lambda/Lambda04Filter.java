package com.cm.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Author：CM
 * @Package：com.cm.lambda
 * @Project：JavaReview
 * @name：Lambda04Filter
 * @Date：2023/6/20 14:29
 * @Filename：Lambda04Filter
 */
public class Lambda04Filter {

    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        System.out.println("Languages which starts with J :");
        filter(languages, str -> str.startsWith("J"));        //将lambda表达式作为方法的形参传入

        System.out.println("Languages which ends with a ");
        filter(languages, str -> str.endsWith("a"));

        System.out.println("Print all languages :");
        filter(languages, str -> true);

        System.out.println("Print no language : ");
        filter(languages, str -> false);

        System.out.println("Print language whose length greater than 4:");
        filter(languages, (str) -> str.length() > 4);

        System.out.println("\nCombination with Predicate");
        filter2(languages,(str)->str.startsWith("J"),(str)->str.endsWith("a"));
    }

    /**
     * Predict接口组合filter
     */
    public static void filter2(List<String> names, Predicate<String> p1, Predicate<String> p2) {
     /*   Predicate<String> startWithJ = (name) -> name.startsWith("J");
        Predicate<String> endWithA = (name) -> name.endsWith("a");*/
        names.stream().filter(p1.and(p2)).forEach(System.out::println);
    }

    /*Predict接口配合filter*/
    public static void filter(List<String> names, Predicate<String> condition) {
        names.stream().filter(condition::test).forEach((name) -> {
            System.out.print(name + " ");
        });
        System.out.println();
    }





 /*   public static void filter(List names, Predicate condition) {
        names.stream().filter(name -> (condition.test(name))).forEach((name) -> {
            System.out.println(name+"  ");
        });
    }*/
}
