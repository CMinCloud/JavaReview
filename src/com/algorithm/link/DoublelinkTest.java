package com.algorithm.link;

public class DoublelinkTest {

    public static void main(String[] args) {

        DoubleLinkList<String> linkList = new DoubleLinkList<>();
        linkList.insert("梅西");
        linkList.insert("C罗");
        linkList.insert("内马尔");
        System.out.println("链表长度"+linkList.length());
        linkList.print();
        System.out.println("after insert...");
        linkList.insert(4,"哈登");
        System.out.println("当前尾节点。。。"+linkList.getLast());
        System.out.println("after remove..."+linkList.remove(2));
        linkList.print();
        System.out.println("after remove..."+linkList.remove(3));
        linkList.print();
        System.out.println("当前尾节点。。。"+linkList.getLast());
    }
}
