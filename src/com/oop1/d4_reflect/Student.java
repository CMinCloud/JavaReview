package com.oop1.d4_reflect;

public class Student {

    private int age;
    public static String name;
    public static final String COUNTRY = "中国";

    public Student(){
        System.out.println("无参构造器执行");
    }

    public Student(int age,String name){
        System.out.println("有参构造器执行");
        Student.name = name;    //为静态变量赋值
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        Student.name = name;
    }
}
