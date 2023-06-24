package com.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.tomcat.jni.Local;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Data
public class QueryParams {

    /**
     * 开始时间:标识返回值使用该格式
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date startTime;

    public static void main(String[] args) {
        System.out.println("Date类型--");
        Date date = new Date();
        System.out.println(date);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date));
        System.out.println("LocalDateTime类型--");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private LocalDateTime dateTime;

    /**
     * 名称
     */
    private String name;

}
