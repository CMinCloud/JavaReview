package com.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import static com.constants.Constants.PORT;

public class ServerChat {

    /** 定义一个集合存放所有在线的socket，key为当前处理的socket管道，value为该管道的客户端  */
    public static Map<Socket, String> onLineSockets = new HashMap<>();


    public static void main(String[] args) {
        try {
//            开启一个服务器端口
            ServerSocket server = new ServerSocket(PORT);
            while (true) {
                Socket accept = server.accept();
//                接收到客户端请求后开启一个线程来处理
                new ServerReader(accept).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
