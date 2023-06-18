package com.oop5.d4_buffer;

import jdk.internal.org.objectweb.asm.commons.SerialVersionUIDAdder;

import java.io.Serializable;

public class Student implements Serializable {
//    序列化版本号（注意大小写）
    private static final long serialVersionUID = 4;
    private String name;
    //  使用transient 声明的 成员属性就不会被序列化
    private transient int age;
    private long password;



    public Student(String name, long password,int age) {
        this.name = name;
        this.password = password;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPassword() {
        return password;
    }

    public void setPassword(long password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", password=" + password +
                '}';
    }
}
