package com.algorithm.sort;

import java.util.Arrays;

public class quick {
    public static void main(String[] args) {
//        int[] arr = new int[]{6, 5, 8, 3, 9, 8, 11, 5, 4, 3, 2, 1};
        int[] arr = new int[]{49, 38, 65, 97, 2342, 23, 1, 654, 76, 13, 27, 49};
        long begin = System.currentTimeMillis();
        quickSort3(arr, 0, arr.length - 1);
        System.out.println("排序消耗时间" + (System.currentTimeMillis() - begin));
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 采用分治的思想，每一次拆分将数组分为  小于基准值和大于基准值的部分
     * 之后再对左边部分和右边部分进一步进行拆分排序
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr, int left, int right) {
        //   当最终只有一个值时，基准值-1的坐标right 小于 left（也是递归结束条件）
        if (left >= right) return;
//        记住边界初始值
        int preLeft = left;
        int preRight = right;
        int base = left;
        while (left < right) {
//            1、先right向左遍历找到第一个小于arr[base] / key的值
            /**
             * 为什么要先从右边开始查找：
             *  前提：因为最后left和right的交点 的值一定是小于基准值的
             *  我们让right向左找先查询到小于key 的值然后会停住！！！那么left和right的交点是小于基准值的
             *  从左边开始找，循环结束后的 i j 碰面的时的值肯定是要 大于 key的 此时再交换key与索引位置 相当于把比key大的值放到了key左边 也就违背了快排的条件
             *
             *
             * 如果要从左边开始查找：
             *  只需把key设置在右侧即可
             */
            while (left < right && arr[right] >= arr[base]) {
                right--;
            }
//            2、再向left向右遍历找到第一个大于arr[base]的值
            while (left < right && arr[left] <= arr[base]) {
                left++;
            }
//            交换两个值
            if (left < right)
                utils.swap(arr, left, right);
        }
        if (left != base)
            utils.swap(arr, left, base);        //将小于基准值的数都放到它的左边，大于基准值的数都放到右边
//        分别用同样的方式去对 左右部分排序
        quickSort(arr, preLeft, left - 1);
        quickSort(arr, left + 1, preRight);
    }

    public static void quickSort2(int[] arr, int left, int right) {
//        递归循环的终止判定
        if (left >= right)
            return;
        int i = left;
        int j = right;
        int base = left;

        while (i < j) {
//            right先向左查找比arr[base]小的数
            while (i < j && arr[j] >= arr[base]) j--;
//            left向右查找比arr[base]大的数
            while (i < j && arr[i] <= arr[base]) i++;
//            交换i、j位置处的值
            utils.swap(arr, i, j);
        }
//        交换交点和base的值
        if (i != base) utils.swap(arr, base, i);
//        对左边进行相同操作
        quickSort2(arr, left, i);
        quickSort2(arr, i + 1, right);
    }

    public static void quickSort3(int[] arr, int left, int right) {
        if (left >= right)           //递归跳出条件
            return;
        int baseIndex = left;
        int i = left;       //记住初始位置
        int j = right;
        while (left < right) {
            while (arr[right] >= arr[baseIndex] && left < right) {
                right--;
            }
            while (arr[left] <= arr[baseIndex] && left < right) {
                left++;
            }
            utils.swap(arr, left, right);
        }
//        交换left、right交点与baseIndex
        int mid = left;
        if (arr[mid] < arr[baseIndex]) {
            utils.swap(arr, mid, baseIndex);
        }
        quickSort3(arr,i,mid);
        quickSort3(arr,mid+1,j);
    }
}
