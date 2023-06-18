package com.oop5.d4_buffer;

import java.io.*;


/**
 * 字节转换流，解决编码不一致而乱码
 */
public class bufferDemo3 {

    public static void main(String[] args) throws Exception {

//            使编码规则不一致而出现乱码
        BufferedReader br = new BufferedReader(new FileReader("src/com/oop5/d2_file/d.txt"));


//        使用字节转换流   ： 将原本的 字节 输入流转换成 字符 输出流  （可以按照指定的编码）
        System.out.println("使用转换流先获取原始字节码，再转换为字符输入流：--------------------");
        InputStreamReader streamReader =
                new InputStreamReader(new FileInputStream("src/com/oop5/d2_file/d.txt"), "GBK");
        int c;
        while ((c = streamReader.read()) != -1) {
            System.out.print((char) c);
        }

        System.out.println("直接使用字符流读取--------------------");
        String str;
        while ((str = br.readLine()) != null) {
            System.out.println(str);
        }

        System.out.println("使用转换流转换为字符流后输出--------------------");
        OutputStreamWriter streamWriter =
                new OutputStreamWriter(new FileOutputStream("src/com/oop5/d2_file/e.txt", true), "GBK");

//        将转换得到的字符输出流  再进行一次包装为 缓冲字符输出流
        BufferedWriter bw = new BufferedWriter(streamWriter);

        bw.write("\n");
        bw.write("我爱你中国！！！");
        bw.write("132155415");
        bw.write("djaioudha");
//
        bw.close();    //注意要关闭 缓冲流后  才会将缓冲区中的内容写入到对应文件中
    }
}
