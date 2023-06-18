package com.oop3.d1_data;

import java.time.LocalDate;
import java.time.Period;

public class jdk8_date {
    public static void main(String[] args) {

//        当前时间
        LocalDate now = LocalDate.now();
        System.out.println(now);
//        生日的年月日
        LocalDate birthday = LocalDate.of(2002, 5, 7);
        System.out.println(birthday);
//        时间间隔对象
        Period period = Period.between(birthday, now);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
    }
}
