package com.algorithm.link;

public class linkTest {

    public static void main(String[] args) {

        LinkList<String> linkList = new LinkList<>();
        linkList.insert("梅西");
        linkList.insert("C罗");
        linkList.insert("内马尔");
        linkList.insert("詹姆斯");
        linkList.insert("姆巴佩");
        linkList.insert("哈兰德");
        System.out.println(linkList.length());


        System.out.println("after Insert...");
        linkList.insert(4,"哈登");
        linkList.print();
        System.out.println("after remove");
        linkList.remove(7);
        linkList.print();
        linkList.insert(1,"ww");
        linkList.print();
        System.out.println("after reverse");
        linkList.reverse();
        linkList.print();
        System.out.println("after clear");
        linkList.clear();
        linkList.print();




    }
}
