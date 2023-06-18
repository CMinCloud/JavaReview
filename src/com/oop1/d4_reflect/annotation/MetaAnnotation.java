package com.oop1.d4_reflect.annotation;


import java.lang.annotation.*;

//元注解测试
public class MetaAnnotation {

    @Myannotation
    public void test() {

    }


}

//自定义一个注解

@Target({ElementType.METHOD, ElementType.TYPE})  //该注解只能使用在方法上、（类、接口、枚举）上
@Retention(RetentionPolicy.RUNTIME)     //表示该注解在什么地方有效  （描述该注解的生命周期）
@Documented         //表示是否将我们的文档注解生成在JAVAdoc中
@interface Myannotation {
    //    注解的参数: 参数类型 + 参数名()
    String name() default "";
    int age() default 0;
}
