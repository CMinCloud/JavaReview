package com.oop5.d2_file;

import java.util.Scanner;

public class recursion {

    public static void main(String[] args) {
//        递归计算n+1
/*        Scanner in = new Scanner(System.in);
        int i  = Integer.parseInt(in.next());
        System.out.println(plus(i));*/
        System.out.println(peach(10, 1));

    }

    public static int plus(int n) {
        if (n == 1) {
            return n;
        }
        return n + plus(n - 1);
    }

    //    猴子吃桃
    public static int peach(int day, int num) {
        if (day == 0) {
            return num;
        }
        return peach(day - 1, (num + 1) * 2);
    }



}
