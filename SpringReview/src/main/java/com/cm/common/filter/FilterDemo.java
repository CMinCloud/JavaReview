package com.cm.common.filter;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(value = "/*")
@Slf4j
public class FilterDemo implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String remoteHost = servletRequest.getRemoteHost();
        System.out.println("remoteHost:" + remoteHost);
        log.info("before filter~");
//        方形请求
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("after filter~");
    }
}
