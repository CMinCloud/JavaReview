package com.algorithm.heap;

import java.util.Arrays;

public class HeapSort {

    //    判断heap中索引处i处元素是否小于索引j处元素的值
    private static boolean less(Comparable[] heap, int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }

    //    交换heap堆中索引i处和索引j处的值
    private static void swap(Comparable[] heap, int i, int j) {
        Comparable temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    //    根据原数组source，构造出堆heap   => 这里是大根堆
    private static void createHeap(Comparable[] source, Comparable[] heap) {
//        将source中的元素拷贝到heap中，heap中可以形成一个无序的堆
//        目标索引从1开始存放
        System.arraycopy(source, 0, heap, 1, source.length);
//        对堆中的元素做下沉调整
        for (int i = (heap.length) / 2; i >= 1; i--) {
            sink(heap, i, heap.length - 1);
        }
    }

    //    堆source数组中的数据从小到大排序:每次将大根堆的最大元素和 尚未交换的最末尾元素 进行交换，进行下沉
    public static void sort(Comparable[] source) {
//        构建堆
        Comparable[] heap = new Comparable[source.length + 1];
        createHeap(source, heap);
//        定义变量，记录未排序的最大元素下标值
/*        int max = heap.length - 1;
//        通过循环，交换1索引处的元素和排序的元素的最大索引处的元素
        while (max != 1) {
//            交换元素
            swap(heap, 1, max);
//            调整最大索引的值，已排序到末尾的值不需要再调整
            max--;
//            对1索引处的数进行下沉调整
            sink(heap, 1, max);
        }*/
        for (int i = heap.length - 1; i > 1; ){
//            交换元素
            swap(heap,1,i);
            i --;
            sink(heap,1,i);
        }
//        copy回原数组
            System.arraycopy(heap, 1, source, 0, source.length);
    }

    //    在heap堆中，堆target处的元素做下沉，返回是0~range
    private static void sink(Comparable[] heap, int target, int range) {
        while (target * 2 <= range) {
//        判断是否有右节点（一定是有左节点的哦）
            int max;
            if (target * 2 + 1 <= range) {
                if (less(heap, 2 * target, target * 2 + 1)) {
                    max = target * 2 + 1;
                } else {
                    max = target * 2;
                }
            } else {
                max = target * 2;
            }
            if (!less(heap, target, max)) {
                break;
            }
            swap(heap, target, max);
            target = max;  //目标节点继续下沉
        }
    }
}
