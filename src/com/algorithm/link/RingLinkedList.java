package com.algorithm.link;

import java.util.Arrays;

// 有环链表
public class RingLinkedList {

    public static void main(String[] args) {
        int [] arr = new int[]{5,0,6,7,3,9,1,4};
        int[] index = new int[]{6,0,2,1,3,6,7,0,2,5,4};

        String tel = "";
        for (int i : index) {
            tel += arr[i];
        }
        System.out.println(tel);

        String str = "dasdjuha dadlkqd as da fias da dqewq s";
        String[] strings = str.split(" ",3);
        String s = Arrays.toString(strings);
        System.out.println(s);
    }
}
