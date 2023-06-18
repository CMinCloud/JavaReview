package com.oop3.d2_regex;

import java.util.Scanner;

public class RegexDemo2 {
    public static void main(String[] args) {
//        checkPhone();
        checkEmail();
    }

    public static void checkPhone(){
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.print("请输入您的手机号：");
            String phone = in.next();
//            判断手机号格式是否正确
//            以1开头，第二位3-9,剩下数字9位
            String regex = "1[\\d&&[^012]]\\d{9}";  //可以用括号来分割不造成影响1([\d&&[^012]])\d{9}
//            String regex = "1[3-9]\\d{9}";
            if(phone.matches(regex)){
                System.out.println("\n格式正确");
                break;      //格式正确，结束输入
            }else {
                System.out.println("格式有误，请重新输入");
            }
        }
    }

    public static void checkEmail(){
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.print("请输入您的邮箱：");
            String phone = in.next();
//            判断邮箱格式是否正确:
//            1587813968@qq.com
//                cm_403630@163.com
//                32165485@pci.com.cn   //二级域名
//            String regex = "\\w{2,30}@[a-zA-Z0-9]{2,20}(\\.[a-zA-Z0-9]{2,10}){1,2}";
            String regex = "\\w{2,30}@[\\w&&[^_]]{2,20}(\\.[a-zA-Z0-9]{2,10}){1,2}";
            if(phone.matches(regex)){
                System.out.println("\n格式正确");
                break;      //格式正确，结束输入
            }else {
                System.out.println("格式有误，请重新输入");
            }
        }
    }
}
