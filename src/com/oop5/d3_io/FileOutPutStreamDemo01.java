package com.oop5.d3_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileOutPutStreamDemo01 {


    public static void main(String[] args) throws Exception{
//         1.字节输出流对象  (会清空之前那的数据，重新覆盖写入)
        FileOutputStream out = new FileOutputStream("src/com/oop5/d2_file/b.txt",true);

//        传入一整个字符串
//        2. 从a.txt中读取文件
        File file = new File("src/com/oop5/d2_file/a.txt");
        FileInputStream is = new FileInputStream(file);
        byte[] buffer = new byte[(int) file.length()];
        is.read(buffer);   // 通过字节流读取内容到buffer中

//        3.将字节数组写入out
        out.write("\t\n".getBytes());    //实现追加输入后换行
        out.write(buffer);
//        写数据必须要刷新数据
        out.flush();

        out.close();  // 关闭输出管道，之后就不能再输出了

    }

}
