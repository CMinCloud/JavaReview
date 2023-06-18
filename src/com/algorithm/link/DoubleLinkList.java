package com.algorithm.link;

public class DoubleLinkList<T> {

    private Node head;  //头节点，头节点中不存储值
    private Node last;  //记录尾节点
    private int N;      // 记录双向链表的长度，不包含头节点

    public DoubleLinkList() {
//        初始化头节点和尾节点
        this.head = new Node(null, null, null);
        this.last = null;
        this.N = 0;
    }

    //    节点对象：成员内部类
    private class Node {
        private T value;
        private Node pre;
        private Node next;

        public Node(T value, Node pre, Node next) {
            this.value = value;
            this.pre = pre;
            this.next = next;
        }
    }

    //    1.清空链表
    public void clear() {
        this.N = 0;
        this.head.next = null;
        this.last = null;
    }

    //    2.获取链表长度
    public int length() {
        return this.N;
    }

    //    3.判断链表是否为空
    public boolean isEmpty() {
        return this.N == 0;
    }

    //    4.获取指定位置i处的元素值
    public T get(int i) {
        if (i > N) {
            return null;
        }
        Node node = head;
        for (int j = 0; j < i && node.next != null; j++) {
            node = node.next;
        }
        return node.value;
    }

    //    5.向链表中添加元素t
    public void insert(T t) {
        //            创建新节点
        Node newNode = new Node(t, null, null);
        if (isEmpty()) {
//        判断链表是否为空
            head.next = newNode;
            newNode.pre = head;
            this.last = newNode;
        }
//        链表不为空，直接操作尾节点:尾插法
        newNode.pre = this.last;
        last.next = newNode;
        this.last = newNode;
        this.N++;
    }

    //    6.在指定位置插入元素
    public void insert(int i, T t) {
        if (i > N + 1) {
            return;
        }
//        指针到指定位置前
        Node pre = head;
        for (int j = 0; j < i - 1; j++) {
            pre = pre.next;
        }
        //        插入位置后的节点
        Node next = pre.next;
        //        创建新节点
        Node newNode = new Node(t, pre, next);
        if(next == null){        //        判断插入位置是不是尾节点
            pre.next = newNode;
            this.last = newNode;
        }else {
//            插入位置不是尾节点
            pre.next = newNode;
            next.pre = newNode;
        }
        N++;
    }

    //    7.删除指定位置处的元素
    public T remove(int i) {
        if (i > N) {
            return null;
        }
        Node cur = head;
        //        指针到指定位置
        for (int j = 0; j < i; j++) {
            cur = cur.next;
        }
//        判断删除的是否是最后一个元素
        Node pre = cur.pre;
        if (cur.next == null) {
            pre.next = null;
            this.last = pre;
        } else {
//            删除节点不是最后一个节点
            Node next = cur.next;
            next.pre = pre;
            pre.next = next;
        }
        N--;
        return cur.value;
    }

    //    8.返回线性表中首次出现的指定数据元素的为序号,若不存在返回-1
    public int indexOf(T t) {
        Node node = head;
        int index = 0;
        while (node.next != null) {
            node = node.next;
            index++;
            if (node.value == t)
                return index;
        }
        return -1;
    }

    //    9.打印链表
    public void print() {
        Node node = head;
        int i = 0;
        if (N == 0) {
//            空链表
            System.out.println("nothing");
            return;
        }
        while (node.next != null) {
            node = node.next;
            i++;
            System.out.println(i + "." + node.value);
        }
    }

    //    10.获取第一个元素
    public T getFirst() {
        if (isEmpty()) {
            return null;
        }
        return head.next.value;
    }

    //    11.获取最后一个元素
    public T getLast() {
        if (isEmpty()) {
            return null;
        }
        return last.value;
    }

    public Iterator<T> iterator(){
        return new Iterator();
    }


    //   定义一个内部类实现遍历
    private class Iterator<T> implements java.util.Iterator {
        private Node n;
        public Iterator(){
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
}
