package com.cm.test;

import com.cm.entity.Address;
import com.cm.entity.User;
import com.cm.entity.convert.UserConverter;
import com.cm.entity.vo.UserQuryParam;
import com.cm.entity.vo.UserVo;
import com.cm.entity.vo.UserWithAddressVo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;

/**
 * @ClassName client
 * @Description TODO
 * @date 2023/7/6 11:29
 * @Version 1.0
 */
public class Client {

    public static void main(String[] args) {
        do2Vo();
        System.out.println();
        vo2Do();
        System.out.println();
        UserAddress2Vo();
    }


    public static void do2Vo() {
        User user = new User()
                .setId(1L)
                .setUsername("zhangsan")
                .setSex(1)
                .setPassword("abc123")
                .setCreateTime(LocalDateTime.now())
                .setBirthday(LocalDate.of(1999, 9, 27))
                .setConfig("[{\"field1\":\"Test Field1\",\"field2\":500}]");   //用于将json字符串转化为对象


        UserVo userVo = UserConverter.INSTANCE.do2Vo(user);
        System.out.println("--------原始对象--------");
        System.out.println(user);
        System.out.println("--------被转化后的vo对象--------");
        System.out.println(userVo);


    }


    public static void vo2Do() {
        UserVo.UserConfig userConfig = new UserVo.UserConfig("Test Field1", 500);

        UserVo userVo = new UserVo()
                .setId(1L)
                .setUsername("zhangsan")
                .setGender(2)
                .setCreateTime("2020-01-18 15:32:54")
                .setBirthday(LocalDate.of(1999, 2, 7))
                .setConfig(Collections.singletonList(userConfig));

        User user = UserConverter.INSTANCE.vo2Do(userVo);

        System.out.println("--------原始对象vo--------");
        System.out.println(userVo);
        System.out.println("--------被转化后的User对象--------");
        System.out.println(user);
        System.out.println();
//        转化多种类型的对象
        UserQuryParam quryParam = UserConverter.INSTANCE.User2Param(user);
        System.out.println(quryParam);

    }


    public static void UserAddress2Vo() {
        User user = new User()
                .setId(1L)
                .setUsername("zhangsan")
                .setSex(1)
                .setPassword("abc123")
                .setCreateTime(LocalDateTime.now())
                .setBirthday(LocalDate.of(1999, 9, 27))
                .setConfig("[{\"field1\":\"Test Field1\",\"field2\":500}]");

        Address address = new Address("华尔街", 503, 11, "华尔街B50311号");

        UserWithAddressVo vo = UserConverter.INSTANCE.UserAddressVo(user, address);
        System.out.println(vo);
    }
}
