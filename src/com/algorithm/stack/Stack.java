package com.algorithm.stack;


import java.util.Iterator;

//使用链表的方式来实现栈  ： 只操作栈顶（尾节点）
//我的理解：使用链表可以自由地扩容，而数组来实现则需要体现申请空间
public class Stack<T> implements Iterable<T>{

    //    记录头节点
    private Node head;
    //    记录栈中地节点数目
    private int N;

    public Stack(){
//        初始化类
        head = new Node(null,null);
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    //    向栈中压入元素t(为了保证遍历的时候先进后出，采取头插法的方式存入节点)
    public void push(T t) {
        Node node = head.next;          //找到首节点
        Node newNode = new Node(t, node);
        head.next = newNode;
        N++;
    }

    //    弹出栈顶元素
    public T pop() {
        if(head.next == null){
//            当前无节点
            return null;
        }
        T value = head.next.value;
        head.next = head.next.next;
        N--;
        return value;
    }

    @Override
    public Iterator iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator{
        private Node n;

        public SIterator(){
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


    //    定义一个成员内部类
    private class Node {
        //        该成员内部类的属性由public修饰，方便外部类可以访问
        public T value;
        public Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
