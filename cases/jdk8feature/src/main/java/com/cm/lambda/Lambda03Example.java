package com.cm.lambda;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @Author：CM
 * @Package：com.cm.lambda
 * @Project：JavaReview
 * @name：Lambda03Example
 * @Date：2023/6/20 14:16
 * @Filename：Lambda03Example
 */
public class Lambda03Example {

    public static void main(String[] args) {

//        构造引用
//        Supplier<Demo> supplier = ()-> new Demo();
        Supplier<Demo> supplier = Demo::new;   //可以直接作为一个形参传入方法

        /*静态方法*/
        Stream<Double> stream = Stream.generate(Math::random);

        /*实例方法*/
        TreeSet<String> treeSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        TreeSet<String> treeSet1 = new TreeSet<>((o1,o2)->o1.compareTo(o2));

//        采用高效的Lambda表达式即可
        TreeSet<String> treeSet2 = new TreeSet<>(String::compareTo);
    }
}
