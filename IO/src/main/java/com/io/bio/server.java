package com.io.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

import static java.lang.Thread.currentThread;

public class server {


    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9000);
        while (true) {
            System.out.println("等待连接");
            Socket socket = serverSocket.accept();  //阻塞方法
            System.out.println("有客户端连接了...");
            new Thread(() -> {
                try {
                    handler(socket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public static void handler(Socket socket) throws IOException {
        System.out.println("thread is" + currentThread().getId());
        byte[] buffer = new byte[1024];         //一次读取1kb
        System.out.println("准备read");
//        服务器接收消息
        SocketAddress address = socket.getRemoteSocketAddress();
        socket.getInputStream().read(buffer);
        System.out.println(address + ":上线了！,说: " + new String(buffer));
//        服务器发送消息
        OutputStream outputStream = socket.getOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        printStream.println("欢迎连接服务器~");
    }
}
