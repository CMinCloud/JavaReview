package com.oop5.d2_file;

import java.io.File;
import java.io.FileInputStream;

public class recursionDemo2 {

    //  定义静态变量存储总的酒的数量,剩余瓶子的数量,剩余空瓶子的数量
    public static int totalBottles;
    public static int restTips;
    public static int restEmptyBottles;

    public static void main(String[] args) throws Exception {
            int money = 10;
            count(money/2);
        System.out.println(totalBottles+","+restTips+","+restEmptyBottles);
    }

    public static  void count(int bottleNum) {
        totalBottles += bottleNum;     //给总啤酒数赋值
        restTips += bottleNum;
        restEmptyBottles += bottleNum;

//        消耗
        if (restEmptyBottles >= 2) {      // 多于两个空瓶
            int temp = restEmptyBottles;
            restEmptyBottles = restEmptyBottles%2;   // 先消耗
            count(temp/2);                 // 再补充
        }

        if (restTips >= 4)       // 多于4个盖子
        {
            int temp = restTips;
            restTips = restTips%4;      // 先消耗
            count((temp/4));            // 再补充
        }
    }

}
