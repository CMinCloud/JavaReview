package com.oop1.d2_inheritance;

import java.util.Objects;

public class Father {
    private String name;
    private int age;
    public static String sex = "男";

//    父类无参构造器一定要存在，子类构造器会默认调用
    public Father(){
        System.out.println("father的无参构造方法");
    }

    public Father(String name,int age){
        this.name = name;
        System.out.println("father的构造方法");
    }

    public void eat(String name){
        System.out.println(name+"吃饭饭~");
    }

    @Override
    public String toString() {
        return "Father{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
//        1.判断是否是同一个对象，如果是返回true
        if (this == o) return true;
//        2.如果o是null返回false，如果o类型和this类型不一致返回false
        if (o == null || getClass() != o.getClass()) return false;
//        3.经过前面if判断一定说明了是同类型的，比较属性一否一致
        Father father = (Father) o;
        return age == father.age && Objects.equals(name, father.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
