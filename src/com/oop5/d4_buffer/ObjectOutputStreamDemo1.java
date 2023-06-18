package com.oop5.d4_buffer;


import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//   对对象进行序列化之后存入  磁盘文件
public class ObjectOutputStreamDemo1 {

    public static void main(String[] args) throws Exception{

//      1.  创建学生对象

//        2. 对象序列化，使用对象字节输出流包装   字节输出流管道
        ObjectOutputStream objectOut = new ObjectOutputStream
                (new FileOutputStream("src/com/oop5/d2_file/f.txt"));

//       封装多个对象为list
        List<Student> list = new ArrayList<>();
        Student stu1 = new Student("zs",21,15649865);
        Student stu2 = new Student("ls",20,156665116);
        Student stu3 = new Student("ww",19,156616);
        Collections.addAll(list,stu1,stu2,stu3);

//        3.使用输出流的序列化方法(序列化多个对象)
        objectOut.writeObject(list);

//        4.释放资源(不需要释放也可以直接输入，因为没有缓冲区)
        objectOut.close();
    }
}
