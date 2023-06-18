package com.oop5.d6_properties;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class PropertiesDemo2 {

    public static void main(String[] args) throws Exception{

//        从属性文件中读取内容, 根据键名来读取对应的value值
        Properties properties = new Properties();

//        加载对应文件的流管道（这里采用字符流）
        properties.load(new FileReader("src/com/oop5/d6_properties/user.properties"));  // 封装了该流会自动帮我们关闭
        System.out.println(properties.getProperty("delei"));
        System.out.println(properties.getProperty("heidaa"));
        Set<String> set = properties.stringPropertyNames();  //获取所有存入的键的名称


        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
