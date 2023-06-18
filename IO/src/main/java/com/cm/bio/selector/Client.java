package com.cm.bio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {

//        1. 获取通道
        SocketChannel socketChannel = SocketChannel.open(
                new InetSocketAddress("127.0.0.1", 9999)
        );

//        2. 切换非阻塞模式
        socketChannel.configureBlocking(false);

//        3.分配指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

//        4.发送数据到服务端
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String nextLine = scan.nextLine();
            buffer.put((new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(System.currentTimeMillis()) + "\n" + nextLine).getBytes());
            buffer.flip();   //切换为写模式
            socketChannel.write(buffer);
            buffer.clear();
        }
//        关闭通道
        socketChannel.close();

//        5.关闭通道
    }
}
