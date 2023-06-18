package dataHandler;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @Author：CM
 * @Package：dataHandler
 * @Project：JavaReview
 * @name：jdk8api
 * @Date：2023/5/6 22:49
 * @Filename：jdk8api
 */
public class jdk8api {

    public static void main(String[] args) {
        testLocalDate();

        testLocalTime();

        testLocalDateTime();

        testDuration();
    }



    /*当前日期*/
    public static void testLocalDate(){
        LocalDate now = LocalDate.now();
        System.out.println(now.minusDays(1));   //一天前时间
        System.out.println(now.plusDays(1));    //一天后时间
    }

    /*当前时间*/
    public static void testLocalTime(){
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        System.out.println(localTime.plusHours(1));     //1小时后
    }

    /*当前时间日期*/
    public static void testLocalDateTime(){
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
    }


    /*计算时间间隔*/
    public static void testDuration(){
        LocalDateTime today = LocalDateTime.now();
        System.out.println(today);
        LocalDateTime time = LocalDateTime.of(1999, 10, 1, 12, 12, 12);
        System.out.println(time);
        Duration duration = Duration.between(today,time);
        System.out.println(duration.toDays());  //两个时间的相隔天数
    }


}
