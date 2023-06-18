package com.algorithm.tree;

import com.algorithm.queue.Queue;

public class ergodicTest {
    public static void main(String[] args) {
        BinaryTree<Integer, String> tree = new BinaryTree<>();

        tree.put(7, "77");
        tree.put(5, "55");
        tree.put(6, "66");
        tree.put(8, "88");
        tree.put(9, "99");
        tree.put(4, "44");
        tree.put(2, "22");

        System.out.println("------------前序遍历---------------");
        Queue<Integer> preErgodic = tree.preErgodic();
        for (Integer key : preErgodic) {
            System.out.println(key + ":" + tree.get(key));
        }
        System.out.println("------------中序遍历---------------");
        Queue<Integer> midErgodic = tree.midErgodic();
        for (Integer key : midErgodic) {
            System.out.println(key + ":" + tree.get(key));
        }
        System.out.println("------------层序遍历---------------");
        Queue<Integer> layerErgodic = tree.layerErgodic();
        for (Integer key : layerErgodic) {
            System.out.println(key + ":" + tree.get(key));
        }

        System.out.println("------------最大深度---------------");
        int maxDepth = tree.maxDepth();
        System.out.println(maxDepth);

    }
}
