package com.oop5.d3_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileOutPutStreamDemo02 {


    public static void main(String[] args) throws Exception {

        FileOutputStream out = null;
        FileInputStream is = null;
        try {
//         1.字节输出流对象  (会清空之前那的数据，重新覆盖写入)
            out = new FileOutputStream("C:\\Users\\15878\\Pictures\\Saved Pictures\\mrxxx.gif");

//        2. 从a.txt中读取文件
            File file = new File("C:\\Users\\15878\\Pictures\\Saved Pictures\\mrx.gif");
            is = new FileInputStream(file);
            byte[] buffer = new byte[(int) file.length()];
            is.read(buffer);   // 通过字节流读取内容到buffer中

//        3.将字节数组写入out
            out.write(buffer);
//        写数据必须要刷新数据
            out.flush();
            System.out.println("复制完成了!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null)
                is.close();
            if (out != null)
                out.close();
        }

    }

}
