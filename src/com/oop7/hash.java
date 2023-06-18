package com.oop7;

import java.util.HashMap;

public class hash {

    public static void main(String[] args) {

        HashMap<Integer,String> map = new HashMap<>();
        int i = generateHash(map);
        System.out.println(i);
        System.out.println("---------------");
        System.out.println(testShiftOperator(100110100));
        System.out.println(true^true);


//        位移运算符
        System.out.println(1561651>>16);
        System.out.println(16>>2);
    }

    public static int  generateHash(Object key){
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public static int testShiftOperator(int key){
        System.out.println(key^100000000);
        return key^100000000;
    }
}
