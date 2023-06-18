package com.oop5.d4_buffer;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

//   对对象进行序列化之后存入  磁盘文件

//  使用transient 声明的 成员属性就不会被序列化
public class ObjectInputStreamDemo1 {

    public static void main(String[] args) throws Exception {

//        1.创建反序列化的对象输入流
        ObjectInputStream is = new ObjectInputStream(new FileInputStream("src/com/oop5/d2_file/f.txt"));

//        2.调用反序列化方法读取多个对象
        List<Student> list = (ArrayList<Student>)is.readObject();

        System.out.println(list);

    }
}
