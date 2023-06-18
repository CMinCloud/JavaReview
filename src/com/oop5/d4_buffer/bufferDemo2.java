package com.oop5.d4_buffer;

import java.io.*;

public class bufferDemo2 {

    public static void main(String[] args) {

        Reader reader = null;
        Writer writer = null;
        BufferedReader br = null;
        BufferedWriter bw = null;

        try{
            File file = new File("src/com/oop5/d2_file/a.txt");
            reader = new FileReader(file);
            writer = new FileWriter("src/com/oop5/d2_file/d.txt",true);   // 追加写法

             br = new BufferedReader(reader);
             bw = new BufferedWriter(writer);

             char[] chars = new char[8096];
            String str ;
            int flag ;
            long l = System.currentTimeMillis();
            while((str = br.readLine()) != null){
                bw.write(str);
                bw.newLine();    //写入一个换行符，该方法会根据不同的操作系统生成对应的换行符
                Thread.sleep(1000L);
            }

/*            while((flag = br.read(chars)) != -1){
                bw.write(chars);
                Thread.sleep(1000L);
            }
            System.out.println(System.currentTimeMillis() - l);*/


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
