package com.oop5.d2_file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;

public class fileDemo {
    public static void main(String[] args) throws Exception {


//        1.创建常见file对象：
        File f = new File("C:\\Users\\15878\\Pictures\\Saved Pictures\\xmr.jpg");
//        获取文件字节长度
        System.out.println(f.length());

        InputStream inputStream = new FileInputStream("src/com/oop5/d2_file/a.txt");
//        循环读取字节
        int c;
        while( (c = inputStream.read())  != -1){
            System.out.println((char) c);
        }

        File list = new File("C:\\Users\\15878\\Pictures\\Saved Pictures");
        System.out.println("---------------------------------------------------该目录下所有文件名称：");
        String[] list1 = list.list();
//        遍历文件名
        Arrays.stream(list1).forEach(s -> System.out.println(s));
    }



}
