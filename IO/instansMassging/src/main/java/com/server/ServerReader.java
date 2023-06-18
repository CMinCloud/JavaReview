package com.server;

import com.constants.Constants;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Set;

public class ServerReader extends Thread {

    private Socket socket;

    public ServerReader(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(socket.getInputStream());
            /** 1.循环一直等待客户端的消息 */
            while (true) {
                int flag = dis.readInt();
                if (flag == 1) {
                    /** 先将当前登录的客户端socket存到在线人数的socket集合中   */
                    String name = dis.readUTF();
                    System.out.println(name + "---->" + socket.getRemoteSocketAddress());
                    ServerChat.onLineSockets.put(socket, name);
                }
                writeMsg(flag, dis);
            }
        } catch (Exception e) {
            System.out.println("--有人下线了--");
            // 从在线人数中将当前socket移出去
            ServerChat.onLineSockets.remove(socket);
            try {
                // 从新更新在线人数并发给所有客户端
                writeMsg(1, dis);
            } catch (Exception e1) {
                e.printStackTrace();
            }
        }
    }

    private void writeMsg(int flag, DataInputStream dis) throws IOException {
//        定义一个变量存放最终的消息形式
        String msg = null;
        if (flag == 1) {
            /** 读取所有在线人数发给所有客户端去更新自己的在线人数列表 */
            StringBuilder sb = new StringBuilder();
            Collection<String> onlineNames = ServerChat.onLineSockets.values();

            // 判断是否存在在线人数
            if (onlineNames.size() > 0) {
                for (String name : onlineNames) {
                    sb.append(name).append(Constants.SPILIT);
                }
//                去掉最后一个分隔符
                msg = sb.substring(0, sb.lastIndexOf(Constants.SPILIT));
//                将消息发送给所有的客户端
                sendMsgToAll(flag, msg);
            } else if (flag == 2 || flag == 3) {
                // 读到消息  群发的 或者 @消息：通过 管道的输入流接收消息
                String newMsg = dis.readUTF();
                // 得到发件人
                String sendName = ServerChat.onLineSockets.get(socket);
                // 最终消息
                StringBuilder finalMsg = new StringBuilder();

                //时间
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEE");
                if (flag == 2) {
//                    群体广播
                    finalMsg.append(sendName).append(" ").append(dateFormat.format(System.currentTimeMillis()))
                            .append("\r\n").append("     ").append(newMsg).append("\r\n");
                    sendMsgToAll(flag, finalMsg.toString());
                } else {
                    finalMsg.append(sendName).append("  ").append(dateFormat.format(System.currentTimeMillis()))
                            .append("对您私发\r\n");
                    finalMsg.append("    ").append(newMsg).append("\r\n");
//                    私发
//                    得到给谁私发
                    String destName = dis.readUTF();
                    sendMsgToOne(destName, finalMsg.toString());
                }
            }
        }
    }

    /**
     * 私发给某个客户端
     *
     * @param destName
     * @param msg
     */
    private void sendMsgToOne(String destName, String msg) throws IOException {
        Set<Socket> onlineSockets = ServerChat.onLineSockets.keySet();
        for (Socket socket : onlineSockets) {
//            遍历搜寻需要私发的对象名称
            if (destName.equals(ServerChat.onLineSockets.get(socket))) {
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                dos.writeInt(2);
                dos.writeUTF(msg);
                dos.flush();                //将缓冲区内容刷新给对方
            }
        }
    }

    private void sendMsgToAll(int flag, String msg) throws IOException {
        // 拿到所有的在线socket管道 给这些管道写出消息
        Set<Socket> onlineSockets = ServerChat.onLineSockets.keySet();
        for (Socket socket : onlineSockets) {
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());      //得到该和该客户端连接的管道
            dos.writeInt(flag);     //消息类型
            dos.writeUTF(msg);
            dos.flush();
        }
    }
}
