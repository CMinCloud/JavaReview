package com.oop5.d2_file;

import java.io.*;

public class recursionDemo {

    public static void main(String[] args) throws Exception {
//        从D盘中开始查询
        findTarget(new File("D:/"), "target.txt");
    }


    //
    public static void findTarget(File dir, String filename) throws Exception {
//        对传入的dir进行判断(传入的都是目录)
        if (dir != null && dir.isDirectory()) {
//                获取files文件数组
            File[] files = dir.listFiles();
//            判断是否存在一级文件对象,才可以开启遍历
            if (files != null && files.length > 0) {        // 这里必须先判断 files != null 否则无法 判断files.length长度
                //                对文件进行遍历
                for (File file : files) {
                    if (file.isFile()) {
                        if (filename.equals(file.getName())) {
                            System.out.println("找到对应文件了:" + file.getAbsolutePath());  // 输出绝对路径
                            System.out.println("文件内容:");
                            int c;
                            FileInputStream inputStream = new FileInputStream(file.getAbsolutePath());
                            while ((c = inputStream.read()) != -1) {
                                System.out.print((char) c);   //输出字符
                            }
                            break;
                        }
                    } else {
//                        不是文件就是目录,  递归
                        findTarget(file, filename);
                    }
                }
            }
        }

    }
}
