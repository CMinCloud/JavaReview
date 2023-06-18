package com;

import com.bean.Cat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * 测试Bean的创建方式
 */
//@ComponentScan("com")
public class App1 {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("ApplicationContext.xml");

//        1、使用xml中bean加载的方式
/*        String[] beanDefinitionNames = app.getBeanDefinitionNames(); //获取所有bean的名字
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
        Object cat = app.getBean("cat");//根据id获取
        System.out.println(cat);
        Object dog1 = app.getBean("dog");//根据id获取
        Object dog2 = app.getBean("dog");//根据id获取
        System.out.println(dog1+","+dog2);
        System.out.println(app.isSingleton("dog"));     // 判断是否是单例
        */

//        2.使用注解+ xml扫描
       /* Object tom = app.getBean("tom");
        System.out.println("根据注解id获取"+tom);
        Cat cat = app.getBean(Cat.class);
        System.out.println("根据类名获取"+cat);*/
//        System.out.println(app.getBean("serviceA"));
//        System.out.println(app.getBean("serviceB"));


    }
}