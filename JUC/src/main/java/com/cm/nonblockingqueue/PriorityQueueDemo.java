package com.cm.nonblockingqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {


    public static void main(String[] args) {

//        自定义排序规则
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.indexOf(0) > o1.indexOf(0) ? 1 : -1;
            }
        });
        queue.add("aaa");
        queue.add("bbb");
        queue.add("ccc");
        queue.add("ddd");

        System.out.println(queue.peek());
        Comparator<? super String> comparator = queue.comparator();
        System.out.println(comparator);
    }
}
