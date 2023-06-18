package com.algorithm.heap;

import com.dataMining.MinPriorityQueue2;

public class MinPriorityQueueTest {

    public static void main(String[] args) {
        MinPriorityQueue2<String> queue = new MinPriorityQueue2<>(10);


        queue.insert("F");
        queue.insert("E");
        queue.insert("D");
        queue.insert("C");
        queue.insert("B");
        queue.insert("A");

        while (!queue.isEmpty()) {
            String min = queue.delMin();
            System.out.println(min);
        }

    }
}
