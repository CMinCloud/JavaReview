package com.oop4.collectionReview;

import java.util.*;

/**
 * @Author：CM
 * @Package：com.oop4.collectionReview
 * @Project：JavaReview
 * @name：treeSet
 * @Date：2023/4/20 9:28
 * @Filename：treeSet
 */
public class TreeSetDemo {

    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>( (o1, o2) -> o1 - o2 > 0 ? 1 : -1);

        Collections.addAll(treeSet,3,2,3,1,2,4,5,5,6);
//        treeSet.add(3);
//        treeSet.add(1);
//        treeSet.add(2);
//        treeSet.add(6);
//        treeSet.add(4);
//        treeSet.add(1);
//        treeSet.add(1);
        System.out.println(treeSet);
//        System.out.println(treeSet.contains(1));
//        System.out.println("迭代器遍历：");
//        Iterator<Integer> iterator = treeSet.iterator();
        int res = 0;
        for(int i =0;i < 5; i++){
            res = treeSet.pollLast();
        }

        System.out.println(res);

    }
}
