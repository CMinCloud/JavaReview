package com.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class client {


    public static void main(String[] args) throws IOException {


        Socket client = new Socket("127.0.0.1", 9000);
        client.getOutputStream().write("HelloServer".getBytes());
        client.getOutputStream().flush();
        System.out.println("向服务端发送数据请求");
        byte[] buffer  = new byte[1024];

//        接收服务端的消息
        client.getInputStream().read(buffer);
        System.out.println("服务端说："+new String(buffer));
        client.close();


    }
}
