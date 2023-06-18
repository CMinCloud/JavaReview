package com.oop1.d4_reflect.annotation;

import java.lang.annotation.*;
import java.lang.reflect.Field;

public class Test {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class<?> c1 = Class.forName("com.oop1.d4_reflect.annotation.Student");

        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {     //打印注解
            System.out.println("#"+annotation);
        }



//        获得注解的value值
        TableCm tableCm = c1.getAnnotation(TableCm.class);
        String name = tableCm.name();
        System.out.println(name);

//        获得类指定的注解
        Field field = c1.getDeclaredField("name");
        FieldCm fieldCm = field.getAnnotation(FieldCm.class);
        System.out.println(fieldCm.name());
        System.out.println(fieldCm.clazz());
        System.out.println(fieldCm.length());


    }
}

@TableCm(name = "studentTable")
class Student{
    @FieldCm(name = "name",clazz = String.class,length = 8)
    private String name;
    @FieldCm(name = "age",clazz = int.class,length = 4)
    private int age;
    @FieldCm(name = "id",clazz = int.class,length = 4)
    private int id;

    public Student() {
    }

    public Student(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableCm{
    String name() default "";
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldCm{
    String name() default "";
    Class<?> clazz();
    int length();
}
