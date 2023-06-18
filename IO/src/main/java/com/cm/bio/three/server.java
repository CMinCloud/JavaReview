package com.cm.bio.three;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * 开启多线程接收多个客户端请求
 */
public class server {

    public static void main(String[] args) {

//        注册端口，服务器端口只注册一个就好了
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            System.out.println("服务端启动~");
            while (true) {
//                这个accpet一定要放在while里面，而不能放在线程run中，因为accept会阻塞监听

                //（2）开始在这里暂停等待接收客户端的连接,得到一个端到端的Socket管道
                Socket accept = serverSocket.accept();
                System.out.println("一个客户端已连接==>"+accept.getRemoteSocketAddress());
                new ServerThreadReader(accept).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
