package com.oop2.d9_commonAPI;

import java.text.DateFormat;
import java.util.Date;

public class system {
    public static void main(String[] args) {
        System.out.println("程序开始...");

        /**
         * 1.终止当前的虚拟机,非0表示异常终止
         */
//        System.exit(0);       //JVM终止

        /**
         * 2.获取时间(时间毫秒值,可以转换为当前时间)
         */
/*        long l = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            System.out.println(i+1);
        }
        System.out.println("顺序递增10000次所需的时间:"+(System.currentTimeMillis()-l)/1000.0+"s");*/

        /**
         * 3.获取格式化的时间
         */
/*        Date date = new Date();
        long time = date.getTime();
        System.out.println(time);
        System.out.println(System.currentTimeMillis());

        DateFormat dateFormat = DateFormat.getDateInstance();
        String format = dateFormat.format(date);
        System.out.println(format);
        System.out.println(DataUtils.getSimpleDate());   //自己编写的工具类*/


        System.out.println("程序结束...");

    }



}
