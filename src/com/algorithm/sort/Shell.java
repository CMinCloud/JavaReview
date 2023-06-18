package com.algorithm.sort;

import java.util.Arrays;

public class Shell {
    public static void main(String[] args) {
        int[] arr = new int[]{11, 5, 8, 3, 9, 8, 6};
        long begin = System.currentTimeMillis();
        ShellSort(arr);
        System.out.println("排序消耗时间" + (System.currentTimeMillis() - begin));
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 希尔排序实际是插入排序的优化版
     * 为了减少插入排序和已排序队列的比较次数,我们可以插缝比较,设置一个增长量进行分组
     * 比如 数组11, 5, 8, 3, 9, 8, 6 ,增长量为3 ,那么 11和 3是一组,5和9一组,8和8一组,3和6一组
     * 比较分组中的值并交换位置
     * <p>
     * 当数据量级非常大时,希尔排序和插入排序的差距非常大
     *
     * @param arr
     */
    public static void ShellSort(int[] arr) {

//        1.根据数组arr的长度确定增长量
        int h = 1;
        while (h < arr.length / 2) {
            h = 2 * h + 1;
        }
//        2.进行排序 进行排序
//           将待插入的元素插入到有序数列中(每一组待插入元素前的元素都是有序的)
        while(h>=1){
            for (int i = h; i < arr.length; i++) {          //找到每一个待插入元素
                for (int j = i; j >= h; j -= h) {           //插入待插入元素
                    if (arr[j] < arr[j - h]) {              //找到第一个比待插入值arr[j]小或等于的元素位置停止
                        utils.swap(arr, j, j - h);
                    } else{
                        break;          // 减少比较次数,当前一个数更小时就不会再进行插入了
                    }
                }
            }
            h = h / 2;
        }
    }
}
