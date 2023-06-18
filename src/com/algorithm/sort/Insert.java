package com.algorithm.sort;

import java.util.Arrays;

public class Insert {
    public static void main(String[] args) {
        int[] arr = new int[]{11, 5, 8, 3, 9, 8, 6};
        long begin = System.currentTimeMillis();
        InsertSort(arr);
        System.out.println("排序消耗时间" + (System.currentTimeMillis() - begin));
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 插入排序，将数组分为已排序和未排序两部分，已知第一个元素是一个单独元素，所以是已排序的
     * 将之后的元素与已排序元素中的元素依次比较并插入其中(这里类似选择排序)
     * 时间复杂度 1+2+...+n-1 = O(n^2)
     *
     * @param arr
     */
    public static void InsertSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {      //需要插入的元素个数arr.length - 1
            int index = i + 1;   //待插入元素的下标
            for (int j = 0; j <= i; j++) {      //带插入元素和已排序元素的比较次数
                if (arr[index] < arr[j]) {
                    utils.swap(arr, index, j);
                }
            }
        }
/*        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] > arr[j - 1]) {
                    break;
                }
                utils.swap(arr, j, j - 1);
            }
        }*/
    }
}
