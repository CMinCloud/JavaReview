package com.algorithm.heap;

public class IndexMinPriorityQueueTest {

    public static void main(String[] args) {

//        创建索引最小优先队列
        IndexMinPriorityQueue<String> queue = new IndexMinPriorityQueue<>(10);

//        添加元素
        queue.insert(0, "A");
        queue.insert(1, "C");
        queue.insert(2, "F");
//        while (!queue.isEmpty()) {
//            int index = queue.delMin();
//            System.out.println(index + " ");
//        }

//        修改
        queue.changeItem(2, "B");
        while (!queue.isEmpty()) {
            int index = queue.delMin();
            System.out.println(index + " ");
        }
//        删除
    }
}
