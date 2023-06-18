package com.algorithm.link;


public class LinkList<T> {

    //    记录头节点
    private Node head;   //头节点不存放数据
    //    记录链表的长度
    private int N;

    public LinkList() {
//        初始化头节点
        this.head = new Node(null, null);
    }

    private class Node {            // 成员内部类,当作一个成员变量使用
        private T value;
        private Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    //    1.清空链表
    public void clear() {
        this.N = 0;
        this.head.next = null;
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
        Node node = this.head;
        for (int j = 0; j < i; j++) {
            node = node.next;
        }
        return node.value;
    }

    //    5.向链表中添加元素t
    public void insert(T t) {
        Node node = head;
//        指针移动到最后一个非空节点处
        while (node.next != null) {
            node = node.next;
        }
        node.next = new Node(t, null);  //添加到尾节点处
        this.N++;
    }

    //    6.在指定位置插入元素
    public void insert(int i, T t) {
        if (i > N + 1) {
            return;
        }
//        指针到指定位置前
        Node node = head;
        for (int j = 0; j < i - 1; j++) {
            node = node.next;
        }
        Node newNode = new Node(t, null);
//        将新节点插入在目标位置
        newNode.next = node.next;
        node.next = newNode;
        N++;
    }

    //    7.删除指定位置处的元素
    public T remove(int i) {
        if (i > N) {
            return null;
        }
        //        指针到指定位置前
        Node node = head;
        for (int j = 0; j < i - 1; j++) {
            node = node.next;
        }
        Node target = node.next;
        node.next = target.next;
        N--;
        return target.value;
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

    //    链表反转!!!!
    public void reverse() {
        if (isEmpty())  //判断是否为空链表
        {
            return;
        }
        reverse(head.next);   //反转第一个节点
    }

    //    反转单个链表
    public Node reverse(Node curr) {
        if (curr.next == null) {      // 代表是最后一个节点
//            插入到头节点和第一个节点位置处
            head.next = curr;
            return curr;
        }
//        不是最后一个节点，接着反转下一个节点
        Node pre = reverse(curr.next);
//        将当前节点接在   自己的下一个节点后
        pre.next = curr;
        //        将当前节点的下一个置为null
        curr.next = null;
        return curr;
    }

    public Node reverse2(Node curr){
//        递归终结条件
        if(curr.next == null){
//            查询到最后一个节点
            head.next = curr;
            return curr;
        }
        Node pre = reverse2(curr.next);
        pre.next = curr;
        curr.next = null;
        return curr;
    }
}
