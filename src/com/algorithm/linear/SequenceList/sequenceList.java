package com.algorithm.linear.SequenceList;


import java.util.Arrays;
/**
 * 线性表：一一连接的元素所构成
 * 第一个元素只有后继元素，称为头节点；
 * 最后一个元素只有前驱元素，成为尾节点
 * 其余元素有且仅有一个前驱元素，一个后继元素
 */
public class sequenceList<T> {
    //    存储元素的数组
    private T[] elements;
    //    记录当前顺序表中元素的个数
    private int N;

    //    构造方法
    public sequenceList(int capacity) {
//        初始化数据(初始化一个顺序数组)
        this.elements = (T[]) new Object[capacity];    // 初始化后所有元素暂时为0
        this.N = 0;         //初始化长度
    }

    //    将一个线性表置为空表
    public void clear() {
        this.N = 0;
    }

    //    判断当前线性表是否为空表
    public boolean isEmpty() {
        return this.N == 0;
    }

    //    获取线性表的长度
    public int length() {
        return this.N;
    }

    //    获取指定位置的元素
    public T get(int index) {
        return elements[index - 1];
    }

    //  向线性表中添加元素t
    public void insert(T t) {
        if (N == elements.length) {
            resize(N * 2);
        }
        elements[N++] = t;
    }

    //    向线性表指定位置添加元素t
    public void insert(T t, int index) {
        if (index > N + 1)      //插入位置越界
            return;
//        扩容
        if (N == elements.length) {
            resize(N * 2);
        }
        if (index == N + 1) {
//            直接插入在最末尾
            insert(t);
        }
//        判断添加位置 index - 1
        for (int i = N - 1; i >= index - 1; i--) {   // 数组位置后移
            elements[i + 1] = elements[i];
        }
        elements[index - 1] = t;
        N++;
    }

    //    向线性表中删除指定位置的元素
    public void delete(int index) {             // 数组位置前移
        if (index > N || index < 1)
            return;

        if (N < elements.length / 4) {
            resize(elements.length / 2);
        }
//        需要删除元素的下标为index -1
        for (int i = index - 1; i < elements.length - 1; i++) {
            elements[i] = elements[i + 1];
        }
//        元素个数-1
        N--;
    }

    //    扩容操作，模拟arrayList扩容
    public void resize(int newSize) {
//        创建一个临时数组指向原数组
        T[] temp = elements;
        elements = (T[]) new Object[newSize];
//        将原数组中的值迁移到新数组当中，原数组没有引用指向会被回收
        for (int i = 0; i < temp.length; i++) {
            elements[i] = temp[i];
        }
    }

    //    遍历线性表中的元素
    public void print() {
        System.out.println(Arrays.toString(elements));
    }

}
