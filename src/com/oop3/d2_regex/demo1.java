package com.oop3.d2_regex;

public class demo1 {
    public static void main(String[] args) {
        System.out.println(check("054aa"));
    }

    public static boolean check(String qq) {
        if (qq != null && qq.length() <= 20 && qq.length() >= 6) {
//            判断字符串中全部是数字：
            char[] chars = qq.toCharArray();
            for (char aChar : chars) {
                if (aChar < '0' || aChar > '9') {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean RegexCheck(String qq) {
        if (qq != null && qq.matches("\\d{6,20}"))
            return true;
        else
            return false;
    }
}
