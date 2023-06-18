package com.oop1.d4_reflect.reflection;

public class test01 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student("zs",22);

//        1.测试获取类
//        方式一:通过Class.forName获得
        Class<?> c1 = Class.forName("com.oop1.d4_reflect.reflection.Student");
        System.out.println(c1.hashCode());
//        方式二:通过类名.class获得
        Class<Student> c2 = Student.class;
        System.out.println(c2.hashCode());
//        方式三:通过对象.getClass()获得
        Class<? extends Person> c3 = person.getClass();
        System.out.println(c3.hashCode());
    }
}


class Person{
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


class Student extends Person{
    public Student(String name, int age) {
        super(name, age);
    }
//    会继承toString方法
}
