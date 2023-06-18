package com.algorithm.sort;

import java.util.Arrays;

public class Merge {
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
        if (left >= right) return;    //递归调用终结处
        int mid = left + (right - left) / 2;        //根据运算顺序来排序，当数据量过大这种写法更靠谱
//        将数组分为left - mid , (mid +1 )- right 两个小组，再对两个小组进行排序
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
//        合并两个排序后的数组
        merge(arr, left, mid, right);
    }

    //    排序在归并中完成,将两个小组归并未一个大组
//    3 5 8 11  :  5 6 8 9
    public static void merge(int[] arr, int left, int mid, int right) {
        int i = left;
//        left - mid , (mid +1 )- right 两个小组，按顺序合并两个数组
        int p1 = left;          //移动左数组的下标
        int p2 = mid + 1;

//        双指针方法写入
        while (p1 <= mid && p2 <= right) {
            if (arr[p1] < arr[p2]) {
                temp[i++] = arr[p1++];
            } else {
                temp[i++] = arr[p2++];
            }
        }
//            填充上剩余元素
        while (p1 <= mid) {
            temp[i++] = arr[p1++];
        }
        while (p2 <= right) {
            temp[i++] = arr[p2++];
        }
//            将每次排序后的值赋给原数组
        for (int index = left; index <= right; index++) {
            arr[index] = temp[index];
        }
    }

//    对left~mid ,mid+1~right位置的数组进行归并
/*    public static void merge2(int[] arr, int left, int mid, int right) {
//        将两个小组归并为一个大组
//        左数组起始下标
        int p1 = left;
//        右数组起始下标
        int p2 = mid+1;
        int k = left; //辅助数组的起始下标
        while(p1<= mid && p2 <= right){
            if(arr[p1] < arr[p2]) temp[k++] = arr[p1++];
            else temp[k++] = arr[p2++];
        }
//        将左边剩余数组全部添加到辅助数组中
        while(p1<= mid)  temp[k++] = arr[p1++];
//            将右边剩余数组全部添加到辅助数组中
        while(p2<= right)  temp[k++] = arr[p2++];

//        相同索引处的元素可能进行重新赋值,所以每一次归并后都要将原数组的值修改
        for (int index = left; index <= right; index++) {
            arr[index] = temp[index];
        }
    }*/
}
