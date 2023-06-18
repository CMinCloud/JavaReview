package com.algorithm.sort;

import java.util.Arrays;

public class Choose {
    public static void main(String[] args) {
        int[] arr = new int[]{11, 5, 8, 3, 9, 8, 6};
        long begin = System.currentTimeMillis();
        chooseSort(arr);
        System.out.println("排序消耗时间"+(System.currentTimeMillis() - begin));
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 选择排序是假定第一个值为最小值，之后遍历其后的队列去寻找更小值并交换
     * 每一次循环找到一个最小值放到数组首部
     * 时间复杂度：(n-1)+(n-2)+...+1 = O(n^2)
     *
     * @param arr
     */
    public static void chooseSort(int[] arr) {
/*        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            utils.swap(arr, i, minIndex);
        }*/

        for(int i = 0; i< arr.length -1 ;i++){
            int min = arr[i];
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < min){
                    min = arr[j];
                    minIndex = j;
                }
            }
            if(minIndex != i){
                utils.swap(arr,i,minIndex);
            }
        }
    }
}
