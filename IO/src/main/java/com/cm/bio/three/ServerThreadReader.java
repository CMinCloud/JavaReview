package com.cm.bio.three;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThreadReader extends Thread {

    private Socket accept;

    public ServerThreadReader(Socket accept) {
        this.accept = accept;
    }

    @Override
    public void run() {
        try {
            InputStream is = accept.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
//            PrintStream ps = new PrintStream(accept.getOutputStream());
            PrintWriter pw = new PrintWriter(accept.getOutputStream());
            //（3）从Socket管道中得到一个字节输入流。
            String msg;
            while ((msg = br.readLine()) != null) {
                System.out.println(Thread.currentThread().getName() + "/服务端收到：" + msg);
//                发送消息给客户端
                pw.println("自动提醒：您的消息发送成功~");
                pw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
