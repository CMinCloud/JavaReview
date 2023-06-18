package com.cm.handler;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public String allExceptionHandler(Exception e) {
        log.warn(e.getMessage());   // 捕获之后打印异常信息
        return "系统异常，请稍后重试";
    }

}
