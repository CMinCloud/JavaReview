package com.oop4.d3_collection_set;

public class alterableParams {

    public static void main(String[] args) {
        aa("a");        //甚至可以不填入参数
        aa("a",2);
        aa("a",2,34,3);
        aa("a",new int[]{2,5,6,80});   //可以传入一个数组
    }
    public static void aa(String s,int ...nums){
//        可变参数内部其实是一个数组
        System.out.println(nums.length);

    }
}
