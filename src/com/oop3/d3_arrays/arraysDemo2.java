package com.oop3.d3_arrays;

import java.util.Arrays;
import java.util.Comparator;

public class arraysDemo2 {
//    自定义数组排序规则
public static void main(String[] args) {
    Integer[] ages = {18,22,15,44,35};

//    按需求自定义排序规则(只支持引用类型的对象)
    /**
     * 1.参数1：被排序的数组必须是引用类型的元素
     * 2.参数2：可以设置一个匿名内部类构造比较器对象
     */
//    !!!可以自定义规则给自定义实体类数组排序
    Arrays.sort(ages, (o1, o2) -> {
        return -(o1-o2);   //若取正则交换，取负则不交换
    });
    System.out.println(Arrays.toString(ages));

}
}
