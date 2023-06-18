package com.oop4.collectionReview;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @Author：CM
 * @Package：com.oop4.collectionReview
 * @Project：JavaReview
 * @name：TreeSetDemo2
 * @Date：2023/4/20 9:56
 * @Filename：TreeSetDemo2
 */
public class TreeSetDemo2 {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        TreeSet<Integer> set = new TreeSet<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2 > 0 ? 1 : -1;
            }
        });
        for(int i = 0; i< nums.length; i++){
            set.add(nums[i]);
        }
        int res = 0;
        // TreeSet有序无重复，弹出末尾第k个元素即可
        for(int i = 0; i<4; i++){
            res = set.pollLast();
        }
        System.out.println(res);
    }
}
