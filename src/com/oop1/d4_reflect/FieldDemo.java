package com.oop1.d4_reflect;

import java.lang.reflect.Field;

public class FieldDemo {

    public static void main(String[] args) throws Exception{
//        getDeclaredFields();
        setFiled();
    }


    public static void getDeclaredFields() throws NoSuchFieldException {
//        a.定位class对象
        Class c = Student.class;
//        b.定位全部成员变量(添加参数就获取对应的)
        Field[] declaredFields = c.getDeclaredFields();
        Field country = c.getDeclaredField("COUNTRY");
        System.out.println(country);
//        c.遍历
        for (Field field : declaredFields) {
            System.out.println(field.getName()+"==>"+field.getType());
        }
    }

    public static void setFiled() throws Exception {
//        a.反射第一步：定位class对象
        Class c = Student.class;
//        b.定位某个成员变量(添加参数就获取对应的)
        Field age = c.getDeclaredField("age");   //获取对应的age变量
//        c.暴力打开权限
        age.setAccessible(true);

        Student s = new Student();  //调用了无参构造器
//        d.赋值
        age.set(s,19);
//      e.取值
        System.out.println(s);
        System.out.println(s.getAge());
    }
}
