package com.algorithm.heap;


/**
 * 用数组格式来存储树结构的数据:堆是一个完全二叉树
 * @param <T>
 */
public class Heap<T extends Comparable<T>> {
    //    存储堆中的元素
    private T[] items;
    //    记录堆中的个数
    private int N;

    public Heap(int capacity) {
        this.items = (T[]) new Comparable[capacity+1];   //注意这里要new一个  Comparable，因为我们继承了Comparable
        this.N = 0;
    }

    /**
     * 判断堆中索引i处的元素是否小于索引j处元素
     *
     * @param i
     * @param j
     * @return
     */
    private boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    /**
     * 交换堆中i索引和j索引处的值
     *
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    /**
     * 删除堆中最大的的元素，并返回这个最大元素
     *
     * @return
     */
    public T delMax() {
        if (N == 0) {
            return null;
        }
//        删除最大元素，方法：与最后一个元素N交换，并删除最后一个元素
        T max = items[1];
        swap(1, N);
//        将最后一个元素删除
        items[N] = null;
        N--;
//        将新的最大元素下沉
        sink(1);
        return max;
    }

    /**
     * 往堆中插入一个元素
     *
     * @param t
     */
    public void insert(T t) {
        items[++N] = t;  // 0下标不存放元素
        swim(N);        // 将堆底的元素上浮
    }

    /**
     * 使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
     *
     * @param k
     */
    private void swim(int k) {
        while (k > 1) {
            if (less(k / 2, k)) {      //构造的是大堆根，每一个节点大于其子树
                swap(k, k / 2);
                k = k / 2;
            }else {
                break;
            }
        }
    }

    /**
     * 使用下沉算法，使索引k处的元素能咋子堆中处于一个正确的位置
     */
    private void sink(int k) {
//            通过循环不断比较当前k处节点 和 （其左子节点和右子节点中的较大值），如果k处节点更小，则交换
        while (2 * k <= N) {        //表示k处元素可以下沉
            int max;   //记录较大元素所在的索引
            if (2 * k + 1 <= N) {         // 右子节点存在
                if (less(2 * k, 2 * k + 1)) {
                    max = 2 * k + 1;
                } else {
                    max = 2 * k;
                }
            } else {
                max = 2 * k;
            }
//            比较当前节点和较大节点的值
            if (!(less(k, max))) {
                break;
            }
//            交换k索引处的值和max索引处的值
            swap(k, max);
//            变换k的值!!!改变k当前的索引，使目标节点继续下沉
            k = max;
        }
    }
}
