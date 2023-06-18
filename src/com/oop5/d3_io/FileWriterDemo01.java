package com.oop5.d3_io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileWriterDemo01 {

    public static void main(String[] args) throws Exception{


//        定义文件，按相对地址获取
        File file = new File("src/com/oop5/d2_file/a.txt");
        FileReader fileReader = new FileReader(file);


//        定义文件字符输出流
        FileWriter fileWriter = new FileWriter("src/com/oop5/d2_file/c.txt",true);  // 以追加形式写入
//        先读取，在写入
        char[] buffer = new char[1024];   //表示每次读取1k个字符
        int len ;  //接受字符数组的长度
        while( (len = fileReader.read(buffer)) != -1){
//            写入新文件
            fileWriter.write("\r\n");     //写入换行符
            fileWriter.write(new String(buffer,0,len));
            fileWriter.flush();  //刷新内容将字符从缓存区写入文件
        }

//        关闭字符流
        fileWriter.close();
        fileReader.close();
    }
}
