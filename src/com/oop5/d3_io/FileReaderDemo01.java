package com.oop5.d3_io;

import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class FileReaderDemo01 {

    public static void main(String[] args) throws Exception{


        File file = new File("src/com/oop5/d2_file/a.txt");
        FileReader fileReader = new FileReader(file);

//        1.读取单个字符(每次读取一个字符，不用担心 每个字符的字节长度不同而乱码)   // 前提还是代码和文件编码一致
        int c;
        while( (c=fileReader.read()) != -1){
            System.out.print((char)c);
        }


//        2.读取字符数组
        char[] buffer = new char[1024];   //表示每次读取1k个字符
        int len ;  //接受字符数组的长度
        while( (len = fileReader.read(buffer)) != -1){
            System.out.println("长度为:"+len);
            System.out.println(new String(buffer,0,len));   //转换为字符串并打印
        }
//        关闭读取流
        fileReader.close();

    }
}
