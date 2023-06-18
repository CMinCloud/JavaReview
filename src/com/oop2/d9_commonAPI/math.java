package com.oop2.d9_commonAPI;



public class math {

    public static void main(String[] args) {

//        1.取绝对值
        System.out.println(Math.abs(-4.2568));

//        2.向上取整
        System.out.println(Math.ceil(-3.1415926));
//        3.向下取整
        System.out.println(Math.floor(3.158));
//        4.四舍五入
        System.out.println(Math.round(4.518564));

//        5.求指数次方（a的b次方）
        System.out.println(Math.pow(2.412,2));

//        6.获取两个int中的最大值
        System.out.println(Math.max(5,7.2));

//        7.返回值为double的随机值，范围[0.0,1.0 )
        System.out.println(Math.random());

//        8.返回[a,b]之间的随机数整数
        int a = 1,b =99;
        System.out.println((int)(Math.random()*(b-a+1)+a));
    }
}
