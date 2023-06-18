package com.algorithm.tree;

public class BinaryTreeTest {

    public static void main(String[] args) {
        BinaryTree<Integer, String> tree = new BinaryTree<>();

      /*  tree.put(3,"ww");
        tree.put(1,"zs");
        tree.put(2,"ls");
        tree.put(5,"55");
        tree.put(4,"44");*/

        tree.put(9, "99");
        tree.put(4, "44");
        tree.put(2, "22");
        tree.put(7, "77");
        tree.put(5, "55");
        tree.put(6, "66");
        tree.put(8, "88");
        System.out.println("插入完毕后元素个数：" + tree.size());

        System.out.println("根据键获取值：" + tree.get(2));

        tree.delete(4);
        System.out.println("删除后元素个数：" + tree.size());

        System.out.println("找到最大的键：" + tree.maxKey());


        System.out.println("找到最小的键：" + tree.minKey());
    }
}
