package com.cm.bio.four;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 使用线程池来实现BIO的伪异步
 */
public class server {

    public static void main(String[] args) {
//        新建客户端
        try {
            System.out.println("----------服务端启动成功------------");
            ServerSocket serverSocket = new ServerSocket(9999);
//            声明一个线程池，最大先线程数为3，等待队列为1000
            // 一个服务端只需要对应一个线程池
            HandlerSocketThreadPool threadPool = new HandlerSocketThreadPool(3, 1000);
            while (true) {
                Socket accept = serverSocket.accept();       // 阻塞式的！
                System.out.println("有人上线了！！");
                threadPool.excute(new ReaderClientRunnable(accept));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


class ReaderClientRunnable implements Runnable {

    private Socket socket;

    public ReaderClientRunnable(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // 读取一行数据
            InputStream is = socket.getInputStream();
            // 转成一个缓冲字符流
            Reader fr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(fr);
            // 一行一行的读取数据
            String line = null;
            while ((line = br.readLine()) != null) { // 阻塞式的！！
                System.out.println("服务端收到了数据：" + line);
            }
        } catch (Exception e) {
            System.out.println("有人下线了");
        }

    }
}


