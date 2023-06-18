package com.oop3.d3_arrays;

import java.util.Arrays;
import java.util.List;

public class arraysDemo {

    public static void main(String[] args) {
//        int[] arr = {11,2,55,3,416,56};
//        System.out.println(arr);   //会打印地址
        int[] arr = new int[2];
        arr = new int[]{11, 2};


//        1.打印数组
        System.out.println(Arrays.toString(arr)); //直接打印数组
//        2.数组排序
        Arrays.sort(arr);
        int[] array = Arrays.stream(arr).filter(v -> v % 2 != 0).toArray();
        System.out.println("所有的奇数："+Arrays.toString(array));
        System.out.println(Arrays.toString(arr)); //直接打印数组
//        3.二分搜索：前提是必须要先排好序
        int i = Arrays.binarySearch(arr, 55);  //返回下标
        System.out.println(i);

//        调用asList方法
        List<Integer> list = Arrays.asList(2, 5, 6, 7, 8);
        System.out.println(list);


//        转换成二进制计算
        System.out.println(8192>>13);
    }


}
