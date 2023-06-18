package com.oop4.d3_collection_set;

import java.util.Objects;

public class Student {
    private int age;
    private String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//重写equals和hashcode方法后，就可以直接比较成员变量的值来判断两个对象是否相同，，，在set中存入不重复的对象
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

//    在存入散列集合如hashset，hashtable时，会先比较hashcode是否已存在
//    如果已存在，再去通过equals比较，equals比较不相同就可以存入
//    如果不存在，则说明两个对象肯定不相同，可以存入

    @Override
    public int hashCode() {
        int hash = Objects.hash(age, name);
        return hash;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
