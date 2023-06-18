package com.cm.bio.five;


import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * 基于BIO下的文件上传
 * 目标：实现客户端上传任意类型的文件数据给服务端保存起来
 */
public class client {

    public static void main(String[] args) {
        try {

            InputStream is = new FileInputStream("F:\\JavaWeb\\JAVA_IO\\文件\\java.png");
            //  1、请求与服务端的Socket链接
            Socket client = new Socket("127.0.0.1", 9999);
            //  2、把字节输出流包装成一个数据输出流
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
            //  3、先发送上传文件的后缀给服务端
            dos.writeUTF(".png");
            //  4、把文件数据发送给服务端进行接收
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) > 0) {
                dos.write(buffer, 0, len);
            }
            dos.flush();
            client.shutdownOutput();        //通知服务端这边的数据发送完毕了
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
