package com.oop5.d3_io;

import java.io.FileInputStream;
import java.io.InputStream;

public class FileInputStreamDemo02 {

    public static void main(String[] args) throws Exception {

//        1.创建一个字节输入流管道与源文件接通
        InputStream is = new FileInputStream("src/com/oop5/d2_file/a.txt");

//        2.定义一个字节数组用于读取数据
        byte[] buffer = new byte[6];     // 表示每次读取三个字节

        int n = is.read(buffer);         // 读取后字节存储在buffer中
        System.out.println("读取了"+n + "个字节");
        String rs1 = new String(buffer);
        System.out.println(rs1);
/*        while( (n=is.read()) != -1){
            System.out.println("读取了"+n + "个字节");
            String rs1 = new String(buffer);
            System.out.println(rs1);
        }*/
        int n1 = is.read(buffer);         // 读取后字节存储在buffer中
        System.out.println("读取了"+n + "个字节");
        String rs2 = new String(buffer);
        System.out.println(rs2);
        int n2 = is.read(buffer);         // 读取后字节存储在buffer中
        System.out.println("读取了"+n2 + "个字节");
        String rs3 = new String(buffer);
        System.out.println(rs3);

    }
}
