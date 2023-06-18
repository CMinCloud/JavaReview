package com.cm.nonblockingqueue;

import java.util.*;
import java.util.stream.Collectors;

public class LinkedListDemo {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();


        list.push("aaa");       //从左边推入
        list.push("bbb");
        list.push("ccc");
        System.out.println(list.toString());

        System.out.println(list);

        System.out.println(list.pop());         //从最右边出来
        System.out.println(list.pop());



        HashMap<String,Integer> map = new HashMap<>();
        map.put(null,null);

        Hashtable<String,Integer> table = new Hashtable<>();
//        table.put(null,null);
//        table.put(null,2);
        System.out.println("-------------------------");
        boolean b = rotateString("abcde", "cdeab");

    }

    public static  boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }

        LinkedList<Character> list = new LinkedList(Arrays.asList(s.toCharArray()));
        String res;
        for(int i = 0; i< s.length() ; i++){
            Character c = list.removeFirst();
            list.addLast(c);
            // 转换为字符串并比较
            res = list.stream().map(String::valueOf).collect(Collectors.joining());
            if(goal.equals(res)){
                return true;
            }
        }
        return false;
    }


}
