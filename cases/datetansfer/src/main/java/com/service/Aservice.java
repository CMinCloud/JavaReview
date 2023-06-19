package com.service;

import com.pojo.QueryParams;

import java.lang.reflect.Field;

/**
 * @Author：CM
 * @Package：com.service
 * @Project：JavaReview
 * @name：Aservice
 * @Date：2023/6/17 12:58
 * @Filename：Aservice
 */
public class Aservice {


    public static void main(String[] args) {
//        使用反射打印对象的名称
        Field[] declaredFields = QueryParams.class.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
        }
    }
}
