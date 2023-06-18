package com.algorithm.queue;

public class queueTest {

    public static void main(String[] args) {

        Queue<String> queue = new Queue();
        queue.enqueue("zs");
        queue.enqueue("ls");
        queue.enqueue("ww");
        queue.enqueue("dja");


        for (String s : queue) {
            System.out.println(s);
        }
        System.out.println("迁出一个元素"+queue.dequeue()+"后");
        for (String s : queue) {
            System.out.println(s);
        }
    }
}
