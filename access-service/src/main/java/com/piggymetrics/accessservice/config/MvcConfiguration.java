package com.piggymetrics.accessservice.config;

import com.piggymetrics.accessservice.interceptor.logger.LoggerHandler;
import com.piggymetrics.accessservice.interceptor.redis.RedisHandler;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class MvcConfiguration implements WebMvcConfigurer {
    public MvcConfiguration() {
        super();
    }

    // API
    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        registry.addInterceptor(new LoggerHandler());
        registry.addInterceptor(new RedisHandler());
    }
}
