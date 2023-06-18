package com.oop4.collectionReview;

import java.util.HashSet;

/**
 * @Author：CM
 * @Package：com.oop4.collectionReview
 * @Project：JavaReview
 * @name：hashsetDemo
 * @Date：2023/4/20 10:19
 * @Filename：hashsetDemo
 */
public class hashsetDemo {

    public static void main(String[] args) {

        int count = 0;      // 记录下读取到子串的最长长度
        String s = "dvdf";
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
            } else {
                count = Math.max(set.size(), count);
                set.clear();  //set归零
                while (!set.contains(s.charAt((i - 1))) && i > 1) {
                    i --;
                }
                i--;   //防止新子串的读取位置指向下一个
            }
        }

        count = Math.max(set.size(), count);
        System.out.println(count);
    }
}
