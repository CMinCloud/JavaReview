package com.bio;


import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestChannel {


    @Test
    public void write() {
        try {
            // 1、字节输出流通向目标文件
            FileOutputStream fileOutputStream = new FileOutputStream(new File("src\\main\\java\\com\\cm\\nio\\data02.txt"));
            // 2、得到字节输出流对应的通道Channel
            FileChannel channel = fileOutputStream.getChannel();
            // 3、分配缓冲区1MB
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.put("hello,黑马Java程序员！".getBytes());
            // 4、把缓冲区切换成写出模式
            buffer.flip();
            channel.write(buffer);
            channel.close();        //关闭通道
            System.out.println("写数据到文件中！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //    使用FileChannel（通道），完成文件的拷贝。
    @Test
    public void copy() throws Exception {
//        源文件
        File srcFile = new File("F:\\JavaWeb\\JAVA_IO\\文件\\壁纸.jpg");
//        目标文件
        File targetFile = new File("F:\\JavaWeb\\JAVA_IO\\文件\\壁纸new.jpg");

//        得到一个文件通道
        FileChannel isChannle = new FileInputStream(srcFile).getChannel();
        FileChannel osChannel = new FileOutputStream(targetFile).getChannel();

//        分配缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true) {
//            必须先清空缓存再写入数据到缓冲区
            buffer.clear();
//            开始读取下一次数据
            int flag = isChannle.read(buffer);
            if (flag == -1) {
                break;
            }
//            已经读取了数据，把缓冲区的模式切换成可读模式
            buffer.flip();
            osChannel.write(buffer);   //写到缓冲区中
        }
        isChannle.close();
        osChannel.close();
        System.out.println("复制完成");
    }


    /**
     * 分散和聚集
     * 分散读取：将Channel通道中的数据读取到多个缓冲区中
     * 聚集写入：将多个Buffer中的数据聚集到 Channel中
     *
     * @throws IOException
     */
    @Test
    public void test() throws IOException {
//        可读可写的模式
        RandomAccessFile raf1 = new RandomAccessFile("src\\main\\java\\com\\cm\\nio\\1.txt", "rw");
        //1. 获取通道
        FileChannel channel1 = raf1.getChannel();

        //2. 分配指定大小的缓冲区
        ByteBuffer buf1 = ByteBuffer.allocate(100);
        ByteBuffer buf2 = ByteBuffer.allocate(1024);
        //3. 分散读取
        ByteBuffer[] bufs = {buf1, buf2};
        channel1.read(bufs);

        for (ByteBuffer byteBuffer : bufs) {
            byteBuffer.flip();   //将每个buffer切换为可读模式
        }
        //4. 聚集写入
        RandomAccessFile raf2 = new RandomAccessFile("src\\main\\java\\com\\cm\\nio\\2.txt", "rw");
        FileChannel channel = raf2.getChannel();
        channel.write(bufs);
    }


    //    从目标通道中去复制原通道数据
    @Test
    public void test02() throws IOException {
        // 1、字节输入管道
        FileInputStream is = new FileInputStream("src\\main\\java\\com\\cm\\nio\\data01.txt");
        FileChannel isChannel = is.getChannel();
        // 2、字节输出流管道
        FileChannel osChannel = new FileOutputStream("src\\main\\java\\com\\cm\\nio\\data03.txt").getChannel();
//        3.复制
        osChannel.transferFrom(isChannel, isChannel.position(),
                isChannel.size());
        isChannel.close();
        osChannel.close();
    }


    //    把原通道（当前）通道数据复制到目标通道
    @Test
    public void test03() throws IOException {
        // 1、字节输入管道
        FileInputStream is = new FileInputStream("src\\main\\java\\com\\cm\\nio\\data01.txt");
        FileChannel isChannel = is.getChannel();
        // 2、字节输出流管道
        FileChannel osChannel = new FileOutputStream("src\\main\\java\\com\\cm\\nio\\data03.txt").getChannel();
//        3.复制
        isChannel.transferTo(isChannel.position(),
                isChannel.size(), osChannel);
        isChannel.close();
        osChannel.close();
    }


}
