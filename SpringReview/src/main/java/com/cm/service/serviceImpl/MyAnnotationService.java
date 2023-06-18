package com.cm.service.serviceImpl;


import com.cm.common.aop.LogAnnotation;
import org.springframework.stereotype.Service;

@Service
public class MyAnnotationService {

    @LogAnnotation
    public String helloAop(String param) {
        System.out.println("step1-方法helloAop执行开始。。。。");
        return param;
    }
}
