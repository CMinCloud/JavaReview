package com.oop5.d3_io;

import java.io.*;

public class FileInputStreamDemo01 {

    public static void main(String[] args) throws Exception {



//        1.创建一个字节输入流管道与源文件接通

//            InputStream is = new FileInputStream(new File("../d2_file/a.txt"));  // 找到对应文件夹
//        简化写法
        InputStream is = new FileInputStream("src/com/oop5/d2_file/a.txt");


//        2.使用循环读取     （因为是一个个字节读取，所以无法读取中文字符）
        int c ;
        while( (c= is.read()) != -1 ){
            System.out.print((char)c);
        }
    }
}
