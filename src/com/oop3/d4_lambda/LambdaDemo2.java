package com.oop3.d4_lambda;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaDemo2 {
    public static void main(String[] args) {

        Integer[] array = {5, 3, 5, 8, 1, 2, 3, 5};

//        自定义排序规则
/*        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -(o1 - o2);
            }
        });*/

//        使用Lambda表达式简化1，因为只有一个方法，可以省略掉接口声明
/*        Arrays.sort(array, (Integer o1, Integer o2) -> {
            return -(o1 - o2);
        });*/

//        Lambda表达式简化2,省略参数类型
/*        Arrays.sort(array, (o1, o2) -> {
            return -(o1 - o2);
        });*/

//        Lambda表达式简化3,单行代码省略{}  类似if...else
        Arrays.sort(array, ((o1, o2) -> -(o1 - o2)));

        System.out.println(Arrays.toString(array));
    }
}
