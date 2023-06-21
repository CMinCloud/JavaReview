package com.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.tomcat.jni.Local;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class QueryParams {

    /**
     * 开始时间:标识返回值使用该格式
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date startTime;

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private LocalDateTime dateTime;

    /**
     * 名称
     */
    private String name;

}
