package com.oop1.d1_variable;

public class ConversionOfNumber {

    public static void main(String[] args) {



//        设置进制的转换：97

//        2进制:
 /*       int i1 = 0B01100001;
        System.out.println(i1);

//        8进制
        int i2 = 0141;
        System.out.println(i2);

//        16进制: 10进制97转换为2进制： 0B01100001 -> 61  ->转换为16进制：0X61
        int i3 = 0x61;
        System.out.println(i3);*/

//        自动类型转换
/*        byte a= 20;
        int b = a;
        System.out.println(b);

//        自动类型转换
        char ch = 'a';
        int cha = ch;
        System.out.println(cha);  // 输出对应的ascii码*/

//        强制类型转换 ： 大转小（会有数据丢失）
/*        int s = 500;
        byte s1 = (byte) s;
        System.out.println("强制类型转换int -> byte："+s1);

        byte t1 = 3;
        byte t2 = 5;
        byte t3 = (byte) (t1+t2);
        System.out.println(t1+","+t2+","+t3);
//        ^运算符 ： 异或操作：前后一样返回false，前后不一样返回true
        if(t1==3 ^ t2==5){
            System.out.println("a");
        }else {
            System.out.println("b");
        }*/

//        数组操作 ,生成随机数（Math.random()*(max-min)+min）   生成[min,max)之间的数
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = (int)(Math.random()*(99-0)+0);
        }
        for (int i : arr) {
            System.out.print(i+",");
        }

        Integer as1 = 1;
        Integer as2 = 2;
        Integer as3 = as1 + as2;
    }
}
