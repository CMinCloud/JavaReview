package com.algorithm.linear.SequenceList;

public class test {
    public static void main(String[] args) {
        sequenceList<String> list = new sequenceList<>(8);

        list.insert("姚明");
        list.insert("科比");
        list.insert("麦迪");
        list.insert("哈登");
        list.insert("德罗赞");
        list.insert("保罗");

//        第一次打印
        System.out.println(list.length());
        list.print();

        System.out.println(list.get(3));

        list.insert("邓肯",3);
        list.print();

//        模拟arrayList扩容
        list.insert("zs");
        list.print();
        list.delete(2);
        list.print();
        list.insert("ls");
        list.print();
        list.insert("ww",1);
        list.print();
    }
}
