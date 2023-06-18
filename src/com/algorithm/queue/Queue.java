package com.algorithm.queue;


import java.util.Iterator;


/**
 * 队列，只操作头和尾
 * @param <T>
 */
public class Queue<T> implements Iterable<T> {
    //          首节点
    private Node head;
    //          记录节点数目
    private int N;
    //          记录最后一个节点
    private Node last;

    //    初始化队列
    public Queue() {
        this.head = new Node(null, null);
        this.N = 0;
        this.last = head.next;      //head不存储数据，last指向第一个节点
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    //    从队列中拿出一个元素
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
//        去除第一个节点
        Node node = head.next;
        T value = node.value;
        head.next = node.next;   //更换首节点
        if (size() == 1) {
            last = head.next;
        }
        N--;
        return value;
    }

    //    往队列末尾插入一个元素(操作last节点就好了)
    public void enqueue(T t) {
        if (last == null) {
            last = new Node(t,null);
            head.next = last;
        }else {
            last.next = new Node(t,null);
            last = last.next;
        }
        N++;
    }

    @Override
    public Iterator<T> iterator() {
        return new QIterator();
    }

    private class QIterator implements Iterator {
        private Node n;

        public QIterator() {
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.value;
        }
    }


    private class Node {
        public T value;
        public Node next;

        public Node(T value, Node next) {
            this.next = next;
            this.value = value;
        }
    }
}
