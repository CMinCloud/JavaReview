package com.algorithm.sort;

import java.util.Arrays;

public class MergeDemo {

    private static int[] temp;

    public static void main(String[] args) {

        int[] arr = new int[]{11, 5, 8, 3, 9, 8, 6, 5, 2};
        temp = new int[arr.length];
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(temp));
    }


    public static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;

        sort(arr, left, mid);
        sort(arr, mid + 1, right);

//        合并两个交换后的数组
        merge(arr, left, mid, right);
    }


    public static void merge(int[] arr, int left, int mid, int right) {

        int p1 = left;
        int p2 = mid + 1;
        int i = left;
        while (p1 <= mid && p2 <= right) {
            if (arr[p1] < arr[p2]) {
                temp[i++] = arr[p1++];
            } else {
                temp[i++] = arr[p2++];
            }
        }

//        读取剩下的一边
        while (p1 <= mid) {
            temp[i++] = arr[p1++];
        }
        while (p2 <= right) {
            temp[i++] = arr[p2++];
        }

        for (int index = left; index <= right; index++) {
            arr[index] = temp[index];
        }
    }
}

