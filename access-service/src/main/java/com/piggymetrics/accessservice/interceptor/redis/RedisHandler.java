package com.piggymetrics.accessservice.interceptor.redis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class RedisHandler implements HandlerInterceptor {

    @Override
    public void afterCompletion(
        final HttpServletRequest request,
        final HttpServletResponse response,
        final Object handler,
        final Exception exception) throws Exception
    {
        System.out.println("Response Result to View :" + response);
    }
}
