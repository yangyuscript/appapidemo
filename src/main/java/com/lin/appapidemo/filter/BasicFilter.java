package com.lin.appapidemo.filter;

import com.lin.appapidemo.util.RedisComponent;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter(urlPatterns = "/index/*|/super/*",filterName = "BasicFilter")
public class BasicFilter implements Filter{
    @Autowired
    private RedisComponent redisComponent;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化过滤器");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter");
        HttpServletRequest httpRequest=(HttpServletRequest)servletRequest;
        HttpServletResponse httpResponse=(HttpServletResponse)servletResponse;
        String contextPath=httpRequest.getContextPath();
        System.out.println("contextPath:"+contextPath);
        String url=httpRequest.getRequestURI();
        System.out.println("url:"+url);
        String url2=httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
        System.out.println("url2:"+url2);
        String requestHead=httpRequest.getHeader("token");
        System.out.println("requestHead:"+requestHead);
        if(requestHead!=null){
            int userid=(int)redisComponent.sentinelGet(requestHead);
            System.out.println("what the fuck"+userid);
        }else{
            httpResponse.sendRedirect("../user/");
        }
        filterChain.doFilter(httpRequest,httpResponse);
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
