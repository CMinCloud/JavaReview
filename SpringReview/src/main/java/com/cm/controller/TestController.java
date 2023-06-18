package com.cm.controller;

import com.cm.service.serviceImpl.MyAnnotationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {

    @Autowired
    private MyAnnotationService annotationService;

    @GetMapping("/test")
    public String testLogAnnotation() {
//        String s = annotationService.helloAop("丁眼如真~");
        System.out.println(annotationService.getClass());
        return "hello world: ";
    }

    @GetMapping("/name")
    public String testFilter() {
        log.info("getName");
        return "cm~";
    }


    @GetMapping("/age")
    public String testInterceptor() {
        log.info("getAge");
        return "cm~";
    }

    @GetMapping("/exce")
    public String testException() {
        log.info("testException");
        throw new RuntimeException("报错啦！");
    }


}
