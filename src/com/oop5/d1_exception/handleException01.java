package com.oop5.d1_exception;

public class handleException01 {
    /**
     * 自定义异常，便于自己通过异常来管理流程模块
     * @param args
     */
    public static void main(String[] args)   {
        try {
            checkAge(17);
        } catch (customedException e) {
            e.printStackTrace();
        }
    }

    public static void checkAge(int age) throws customedException {
        if(age<18){
            throw  new customedException("年龄不满18");
        }else {
            System.out.println("随意挥霍~");
        }
    }



}
