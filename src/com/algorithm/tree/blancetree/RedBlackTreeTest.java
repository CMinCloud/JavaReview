package com.algorithm.tree.blancetree;

public class RedBlackTreeTest {
    public static void main(String[] args) {
        RedBlackTree<String, String> tree = new RedBlackTree<>();

        tree.put("1", "zs");
        tree.put("2", "ls");
        tree.put("3", "ww");
        tree.put("4","44");
        tree.put("5","55");
//        从树中获取数据
        String r1 = tree.get("1");
        System.out.println(r1);
        String r2 = tree.get("2");
        System.out.println(r2);
        String r3 = tree.get("4");
        System.out.println(r3);
    }
}
