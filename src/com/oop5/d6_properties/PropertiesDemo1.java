package com.oop5.d6_properties;

import java.io.FileWriter;
import java.util.Properties;

public class PropertiesDemo1 {

    public static void main(String[] args) throws Exception{
//        使用properties将键值对写入到属性文件中去,properties继承自hashtable
        Properties properties =  new Properties();
        properties.setProperty("admin","123456");
        properties.setProperty("delei","16548");
        properties.setProperty("heidaa","49863");

        System.out.println(properties);

        /**
         *  参数一：保存管道，字符输出管道
         *  参数二：保存心得
         */

        properties.store(new FileWriter("src/com/oop5/d6_properties/user.properties"),
                "nothing really matters!");



    }
}
