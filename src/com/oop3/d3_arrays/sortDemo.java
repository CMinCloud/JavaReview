package com.oop3.d3_arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class sortDemo {

    public static void main(String[] args) {
//        Integer[] arr = {55, 2, 6, 31, 54, 3, 58, 59};
        Integer[] arr = {6, 1, 2, 7, 9, 3, 4, 6, 6, 8};
//        choiceSort(arr);         //选择排序

        quicksort2(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
//        int idnex = binarySearch(arr, 58, 0, arr.length - 1);
//        int index = binarySearch2(arr, 8);
//        System.out.println(index);
//        System.out.println(binarySearch(arr,58,0,arr.length-1));
    }

    /**
     * 选择排序
     */
    public static Integer[] choiceSort(Integer[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            int index = minIndex;            //假设最小值下标为每次循环的第一个
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]) {
                    index = j;
                }
            }
            swap(array, minIndex, index);   //     调用方法交换当前位置和之后的最小值
//            Collections.swap(Arrays.asList(array),minIndex,index);
        }
        return array;
    }

    /**
     * 二分查找目标值的下标（传入的array必须是已经排序好的）
     *
     * @param array
     * @param key
     * @param bottom
     * @param top
     * @return
     */
    public static Integer binarySearch(Integer[] array, Integer key, int bottom, int top) {
        if (array == null || array.length <= 1)
            return null;
        int middle = (bottom + top) / 2;
        if (Objects.equals(array[middle], key)) {   //匹配目标值
            return middle;
        } else if (array[middle] > key) {       //大于目标值
            return binarySearch(array, key, bottom, middle - 1);
        } else                  //  小于目标值，查找右半区
            return binarySearch(array, key, middle + 1, top);
    }

    /**
     * 使用循环的方式实现二分查询
     *
     * @param array
     * @param key
     * @return
     */
    public static Integer binarySearch2(Integer[] array, Integer key) {
        int left = 0, right = array.length - 1;

        while (left <= right) {          // 循环运行条件：左右端未合并
            int middle = (left + right) / 2;
            if (array[middle] > key) {
//            查找左边区域
                right = middle - 1;
            } else if (array[middle] < key) {
//                查找右边区域
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static void quicksort(Integer[] array, int left, int right) {
//        当最终只有一个值时，基准值-1的坐标right 小于 left（也是递归结束条件）
        if (left >= right) return;
        int baseIndex = left;   //设置基准值为最左侧的值
        int i = left;       //把左端初始位置保存下来
        int j = right;      //把右端初始位置保存下来
        while (i < j) {
            while (array[j] >= array[baseIndex] && i < j)
                j--;    //向左寻找第一个小于基准数的数后停下
            while (array[i] <= array[baseIndex] && i < j)
                i++;    //向右寻找第一个大于基准数的数后停下
            if (i < j) {    //可能等于
                swap(array, i, j);    // 交换两个数
            }
        }
        swap(array, baseIndex, j);   //交换左右交点和基准点
        quicksort(array, left, j - 1);
        quicksort(array, j + 1, right);
    }

    public static void quicksort2(Integer[] array, int left, int right) {
//        递归跳出的条件
        if (left >= right) {
            return;
        }
        int base = left;
        int l = left;
        int r = right;
        while (l < r) {
            while (l < r && array[r] >= array[base]) {
                r--;
            }
            while (l < r && array[l] <= array[base]) {
                l++;
            }
            swap(array, l, r);
        }
//        当左右指针碰头后，交换交汇处和基准点
        swap(array,base,l);
//        对左边进行同样操作
        quicksort2(array,left,l-1);
        quicksort2(array,l+1,right);
//        对右边进行同样操作
    }


    public static <E> void swap(E[] array, int i, int j) {  //传入数组和两个下标
        E temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }

}
