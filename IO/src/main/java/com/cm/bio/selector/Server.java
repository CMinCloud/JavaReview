package com.cm.bio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * 使用选择器来监听客户端通道
 */
public class Server {

    public static void main(String[] args) throws IOException {
//        1、获取通道
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
//        2、切换非阻塞模式
        ssChannel.configureBlocking(false);
//        3. 绑定连接,连接服务端
        ssChannel.bind(new InetSocketAddress(9999));
//        4. 获取选择器
        Selector selector = Selector.open();
//        5. 将通道注册到选择器上,并指定"监听接收事件(发生该事件才会被线程调用)"
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);
//        6. 轮询式的获取选择器上已经"准备就绪"的事件
        while (selector.select() > 0) {
            System.out.println("论一轮");
            //        7.选择当前选择器中所有注册的"选择键"(已就绪的监听事件)
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while (it.hasNext()) {
                //        8.获取准备"就绪"的事件
                SelectionKey sk = it.next();
                //        9.判断具体是什么事件准备就绪
                if (sk.isAcceptable()) {
                    //        10.若"接收就绪",获取客户端接收
//                    对于每一个客户端,都会开启一个socketChannel
                    SocketChannel socketChannel = ssChannel.accept();
//                    11.切换非阻塞模式
                    socketChannel.configureBlocking(false);
//                      12.将该通道注册到选择器上
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (sk.isReadable()) {
//        13.获取当前选择器上"读就绪"状态的通道
                    SocketChannel socketChannel = (SocketChannel) sk.channel();

//        14.读取数据
                    ByteBuffer buf = ByteBuffer.allocate(1024);
                    int len = 0;
                    while ((len = socketChannel.read(buf)) > 0) {
                        buf.flip();
                        System.out.println(new String(buf.array(), 0, len));
                        buf.clear();
                    }
                }
                it.remove();
            }


        }


//        15.取消选择键 selectionKey

    }

}
