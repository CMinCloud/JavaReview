package com.oop3.d1_data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

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


        System.out.println("----------------------");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println("-----------");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-HH-dd hh:mm");
        String format = dateTimeFormatter.format(localDateTime);
        System.out.println(format);
//        TemporalAccessor parse = dateTimeFormatter.parse("2023-06-18T23:35:12.130");
//        System.out.println(parse);

    }
}
