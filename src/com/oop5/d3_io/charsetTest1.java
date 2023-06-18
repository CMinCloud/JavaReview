package com.oop5.d3_io;


import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 学会字符集的编码和解码
 */
public class charsetTest1 {

    public static void main(String[] args) throws UnsupportedEncodingException {

//        1. 编码，将文字 或内容  转换为字节
        String name  = "abc我爱你中国";  //UTF-8编码 共 3+ 5*3 = 18个字节
        byte[] bytes = name.getBytes();  //以默认编码格式编码 ，UTF-8
        byte[] bytes1 = name.getBytes("GBK");
        System.out.println("UTF-8编码："+Arrays.toString(bytes));
        System.out.println("GBK编码："+Arrays.toString(bytes1));

        String decode1 = new String(bytes,"UTF-8");
        String decode2 = new String(bytes,"GBK");
        System.out.println("UTF-8编码，UTF-8解码："+decode1);
        System.out.println("UTF-8编码，GBK解码："+decode2);

        String decode3 = new String(bytes1,"UTF-8");
        String decode4 = new String(bytes1,"GBK");
        System.out.println("GBK编码，UTF-8解码："+decode3);
        System.out.println("GBK，GBK解码："+decode4);


//        2. 解码，将字节 重新转换为内容
    }
}
