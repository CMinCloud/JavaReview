package com.cm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/getway")
public class RequestController {

    @GetMapping("request")
    public void request(HttpServletRequest req) {
//获取统一资源标识符:虚拟路径/Servlet映射路径
        System.out.println("获取统一资源标识符:" + req.getRequestURI());
        //获取统一资源定位符: 浏览器的访问地址
        System.out.println("获取统一资源定位符:" + req.getRequestURL());
//获取当前项目虚拟目录
        System.out.println("获取虚拟目录:" + req.getContextPath());
//获取资Servlet映射路径
        System.out.println("获取Servlet映射路径:" + req.getServletPath());
        System.out.println("获取访问者ip地址:" + req.getRemoteAddr());
    }
}
