package com.algorithm.heap;

public class MaxPriorityQueueTest {

    public static void main(String[] args) {
        MaxPriorityQueue<String> queue = new MaxPriorityQueue<>(10);

        queue.insert("A");
        queue.insert("B");
        queue.insert("C");
        queue.insert("D");
        queue.insert("E");
        queue.insert("F");

        String result = null;
        while ((result = queue.delMax()) != null) {
            System.out.print(result + " ");
        }

    }
}
