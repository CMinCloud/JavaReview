package com.algorithm.heap;

public class HeapTest {

    public static void main(String[] args) {
//        创建堆对象
        Heap<String> heap = new Heap<>(10);
//        存入字符串数据
        heap.insert("A");
        heap.insert("B");
        heap.insert("C");
        heap.insert("D");
        heap.insert("E");
        heap.insert("F");
//        通过循环从堆中删除元素（检验堆每次删除的是最大元素）

        String result = null;
        while ((result = heap.delMax()) != null) {
            System.out.print(result + " ");
        }

    }
}
