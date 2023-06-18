package com.oop5.d3_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class FileInputStreamDemo03 {

    public static void main(String[] args) throws Exception {

//        1.创建一个字节输入流管道与源文件接通
        File file = new File("src/com/oop5/d2_file/a.txt");
        InputStream is = new FileInputStream(file);   //  获取管道
        long length = file.length();// 获取文件长度（long类型的，原则上文件大小没有限制）

//        2.定义一个字节数组来接受字符串，大小与刚刚声明的文件大小一样（需要强转，因为int类型可能数组溢出，而文件无限制）
        byte[] buffer = new byte[(int) length];
        int i = is.read(buffer);
        System.out.println("读取了"+i+"个字节，字节长度为"+buffer.length);
        System.out.println("内容为："+new String(buffer));
        is.close();


    }
}
