package com.oop5.d5_printStream;

import java.io.PrintStream;

public class d5_printStream2 {

    public static void main(String[] args) throws  Exception{

        System.out.println("123154");
        System.out.println(87867454);


//        其实上面也是打印流
//        自定义打印路径
        PrintStream ps = new PrintStream("src/com/oop5/d2_file/g.txt");
        System.setOut(ps);

        System.out.println("123154");
        System.out.println(87867454);
    }


}
