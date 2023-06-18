package com.oop5.d5_printStream;

import java.io.PrintStream;
import java.io.PrintWriter;

public class d5_printStream {

    public static void main(String[] args) throws  Exception{

        //    1.创建一个打印流对象
        PrintStream ps = new PrintStream("src/com/oop5/d2_file/g.txt");
        ps.println("xdadaf");
        ps.println(true);
        ps.println(1564);

        ps.write(97);   //打印ASCII码对应的值

//        2.创建一个字符打印流
        PrintWriter pw = new PrintWriter("src/com/oop5/d2_file/g.txt");
        pw.print("dhaoifhaiosdjaioda");   //继承自缓冲流，记得要关闭字符打印流

        pw.close();


    }


}
