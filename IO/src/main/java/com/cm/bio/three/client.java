package com.cm.bio.three;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class client {

    public static void main(String[] args) {
        System.out.println("==客户端的启动==");
        try {
            // （1）创建一个Socket的通信管道，请求与服务端的端口连接。
            Socket socket = new Socket("127.0.0.1", 9999);
            // （2）从Socket通信管道中得到一个字节输出流。
            OutputStream os = socket.getOutputStream();
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            // （3）把字节流改装成自己需要的流进行数据的发送
            PrintStream ps = new PrintStream(os);
            // （4）开始发送消息
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("请说:");
                String msg = scanner.nextLine();
                ps.println(msg);
                ps.flush();
                String line  = br.readLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
