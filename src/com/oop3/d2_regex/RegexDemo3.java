package com.oop3.d2_regex;

public class RegexDemo3 {
    public static void main(String[] args) {
        String names = "小李djaiodai张三dajdaio李四dhauid_135王五";

//        使用正则表达式分割字符串：
        String[] split = names.split("\\w+");   //代表按任意多个数字字母和下划线分割
        for (String s : split) {
            System.out.println(s);
        }

        String hhh = names.replaceAll("\\w+", "hhh");
        System.out.println(hhh);
    }
}
