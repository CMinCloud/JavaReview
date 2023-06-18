package com.algorithm.sort;

import java.util.Arrays;

import static com.algorithm.sort.utils.swap;

public class Bubble {

    public static void main(String[] args) {
        int[] arr = new int[]{11, 5, 8, 3, 9, 8, 6};
        long begin = System.currentTimeMillis();
        bubbleSort(arr);
        System.out.println("排序消耗时间" + (System.currentTimeMillis() - begin));
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 冒泡排序的原理，每一次循环将一个最大值\最小值放到数组的 尾部\首部，类似冒泡
     * 时间复杂度:(n-1) + (n-2) +... + 1 = O(n^2)
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {          // 控制循环次数
            for (int j = 1; j < arr.length - i; j++) {      //每次比较次数，不用比较已经排好的尾元素
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
        }


//        for (int i = 0; i < arr.length -1; i++) {
//            for (int j = i+1; j < arr.length; j++) {
//                if(arr[i] > arr[j]){
//                    swap(arr,i,j);
//                }
//            }
//        }
    }
}
