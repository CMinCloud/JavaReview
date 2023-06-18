package com.algorithm.heap;


/**
 * 使用堆的结构来设计队列，   方便每次获取最小元素
 */
public class MinPriorityQueue<T extends Comparable<T>> {

    private T[] items;    //用来存储元素的数组

    private int N;  //记录堆中元素个数

    //  初始化
    public MinPriorityQueue(int capacity) {
        this.items = (T[]) new Comparable[capacity + 1];   //注意这里要new一个  Comparable，因为我们继承了Comparable
        this.N = 0;

    }


    /**
     * 判断堆中索引i处的元素是否小于索引j处的元素
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
     * 删除队列中最大的元素，并返回这个最大元素
     *
     * @return
     */
    public T delMin() {
        if (isEmpty()) {
            return null;
        }
        //        删除最大元素，方法：与最后一个元素N交换，并删除最后一个元素
        T min = items[1];
        swap(1, N);
//        将最后一个元素删除
        items[N] = null;
        N--;
        //        将新的最大元素下沉
        sink(1);
        return min;
    }


    /**
     * 往队列中插入一个元素
     *
     * @param t
     */
    public void insert(T t) {
        items[++N] = t;
        swim(N);
    }

    /**
     * 使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
     *
     * @param k
     */
    private void swim(int k) {
        while (k > 1) {
            if (!less(k / 2, k)) {      //与父节点进行比较
                swap(k / 2, k);
                k = k / 2;      // k节点指向新的位置
            } else {
                break;
            }
        }
    }

    /**
     * 使用下沉算法，使索引k处的元素能在堆中处于一个正确的位置
     *
     * @param k
     */
    private void sink(int k) {
        while (k * 2 <= N) {
            int min;    //与子树中较小的一个进行交换
            if (k * 2 + 1 <= N) {
                if (less(k * 2, k * 2 + 1)) {
                    min = k * 2;
                } else {
                    min = k * 2 + 1;
                }
            } else {
                min = k * 2;
            }
            //            比较当前节点和较小子节点的值
            if ((less(k, min))) {
                break;
            }
            swap(min, k);
            k = min;
        }
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

}
