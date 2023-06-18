package com.cm.bio.two;

import com.cm.bio.three.ServerThreadReader;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class serverDemo {


    /**
     * 主线程相当于一个线程，用来接收一个请求（BIO）
     *
     * @param args
     */
    public static void main(String[] args) {

        try {
            System.out.println("==服务器的启动==");
            // （1）注册端口
            ServerSocket socket = new ServerSocket(9999);
            while (true) {
//            （2）开始在这里暂停等待接收客户端的连接,得到一个端到端的Socket管道
                Socket accept = socket.accept();        //监听端口
                InputStream is = accept.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                //（3）从Socket管道中得到一个字节输入流。
                String msg;
                while ((msg = br.readLine()) != null) {
                    System.out.println("服务端收到：" + msg);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
