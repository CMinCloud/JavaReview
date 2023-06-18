package com.algorithm.sort;

import java.util.Arrays;

public class Merge2 {
    private static int[] temp;  // 定义一个静态数组来归并生成一个新的排序数组

    public static void main(String[] args) {

        int[] arr = new int[]{11, 5, 8, 3, 9, 8, 6, 5, 2};
//        int[] arr = new int[]{4, 3, 2, 1};
        temp = new int[arr.length];  //对数组进行初始化
        long begin = System.currentTimeMillis();
        sort(arr, 0, arr.length - 1);
        System.out.println("排序消耗时间" + (System.currentTimeMillis() - begin));
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(temp));

    }

    //    对数组内left到right的元素进行排序
    public static void sort(int[] arr, int left, int right) {
        if(left >= right) return;
//        分别对左右两边继续排序，排序后进行合并
        int mid = left + (right - left) / 2;
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    //    排序在归并中完成,将两个小组归并未一个大组
//    3 5 8 11  :  5 6 8 9
    public static void merge(int[] arr, int left, int mid, int right) {
//        记录这一串数组的初始位置
        int i = left;
        int p1, p2;
        for (p1 = left, p2 = mid + 1; p1 <= mid && p2 <= right; ) {
            if (arr[p1] > arr[p2]) temp[i++] = arr[p2++];
            else temp[i++] = arr[p1++];
        }

//        合并剩下未合并完的
        while (p1 <= mid) {
            temp[i++] = arr[p1++];
        }
        while (p2 <= right) {
            temp[i++] = arr[p2++];
        }

//        写回原数组
        for (int j = left; j <= right; j++) {
            arr[j] = temp[j];
        }
    }

}
