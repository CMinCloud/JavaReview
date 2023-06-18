package com.algorithm.heap;


//  修改items中元素  --> 根据qp数组中下标找到的元素值获取pq数组下标 --> 对应修改pq数组下标对应的元素值
public class IndexMinPriorityQueue<T extends Comparable<T>> {
    //    用来存储元素的数组
    private T[] items;
    //    保存每个元素在items中的索引，pq数组需要堆有序
    private int[] pq;
    //    保存qp的逆序，pq的值作为索引，pq的索引作为值
    private int[] qp;
    //    记录堆中元素的个数
    private int N;

    public IndexMinPriorityQueue(int capacity) {
        this.items = (T[]) new Comparable[capacity + 1];
        pq = new int[capacity + 1];
        qp = new int[capacity + 1];
        N = 0;
//        默认情况下，队列中没有任何数据，让qp中元素均为-1
        for (int i = 0; i < qp.length; i++) {
            qp[i] = -1;
        }
    }

    //    判断heap中索引处i处元素是否小于索引j处元素的值
//    pq[x] 获取items的下标
    private boolean less(int i, int j) {
        return items[pq[i]].compareTo(items[pq[j]]) < 0;
    }

    //    交换heap堆（pq数组）中索引i处和索引j处的值
//    同时更新qp数组
    private void swap(int i, int j) {
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
//        更新qp数组
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    //    删除队列中最小的元素，并返回该元素关联的索引
    public int delMin() {
//        1.先操作pq数组
        int minIndex = pq[1];
        swap(1, N);

//        2.删除qp数组对应位置处的值: pq[N] 获取到item的索引，item索引和qp索引对应
        qp[pq[N]] = -1;

//        3.删除items中原位置存储的值
        items[pq[N]] = null;

//        4.删除pq[]中的值
        pq[N] = -1;

//        元素个数-1
        N--;
//        下沉调整
        sink(1);
        return minIndex;
    }

    //    往队列中插入一个元素，并关联索引i
    public void insert(int i, T t) {
//        判断i是否已经被关联,已经被关联则无法插入
        if (contains(i)) {
            return;
        }
//        元素个数+1,存入items
        items[i] = t;
        N++;
//        把i存储到pq当中
        pq[N] = i;
//        使用qp来记录pq的下标
        qp[i] = N;
//        通过堆上浮完成堆的排序
        swim(N);

    }

    //    使用上浮算法，使索引k处的元素能在队中处于一个正确的位置
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

    //    使用下沉算法：使索引k处的元素能在堆中处于一个正确的位置
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

    //    获取队列中元素的个数
    public int size() {
        return N;
    }

    //    判断队列是否为空
    public boolean isEmpty() {
        return N == 0;
    }

    //    判断k对应的元素是否存在: items中k下标对应的元素是否存在
    public boolean contains(int k) {
        return qp[k] != -1;
    }

    //    把与索引i关联的元素修改为t
    public void changeItem(int i, T t) {
//        修改items中i位置的元素为t
        items[i] = t;

//        找到item再pq的索引
        int k = qp[i];
//        堆调整
        sink(1);
        swim(k);

    }

    //    最小元素关联的索引
    public int minIndex() {
        return pq[1];
    }

    //    删除索引i关联的元素
    public void delete(int i) {
//        找到pq索引
        int k = qp[i];

//        类似delMin的删除方式
        //        1.先操作pq数组
        int minIndex = pq[k];
        swap(k, N);

//        2.删除qp数组对应位置处的值: pq[N] 获取到item的索引，item索引和qp索引对应
        qp[pq[N]] = -1;

//        3.删除items中原位置存储的值
        items[pq[N]] = null;

//        4.删除pq[]的值
        pq[N] = -1;
//        元素个数-1
        N--;
//        先下沉再上浮\先上浮再下沉
        sink(k);
//        再上浮
        swim(N);
    }


    //    获取排序后的第i个元素
    public T get(int i) {
        return items[pq[i]];
    }

}
