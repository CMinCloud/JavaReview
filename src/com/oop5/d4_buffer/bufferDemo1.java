package com.oop5.d4_buffer;

import java.io.*;

public class bufferDemo1 {

    public static void main(String[] args)  {

        InputStream inputStream = null;
        OutputStream outputStream = null;

        try{
            File  file = new File("C:\\Users\\15878\\Pictures\\Saved Pictures\\mrx.gif");

//        使用缓冲流读入数据
             inputStream = new BufferedInputStream(new FileInputStream(file));

            //        使用缓冲流输出数据
             outputStream =
                    new BufferedOutputStream(
                            new FileOutputStream("C:\\Users\\15878\\Pictures\\Saved Pictures\\mrx2.gif"));

            int len;
            byte[] buffer = new byte[1024];   //每次最多读取1024个字节
            while((len = inputStream.read(buffer)) != -1){   //读取字节存入buffer数组
                outputStream.write(buffer,0,len );
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
//        关闭缓冲流
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
}
