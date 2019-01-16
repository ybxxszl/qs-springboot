package com.wjy.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ybxxszl
 * @date 2018年9月9日
 * @description 配置过滤请求路径
 */
@Configuration
public class SystemWebMvcConfigurer implements WebMvcConfigurer {

    @Autowired
    private SystemInterceptor systemInterceptor;

    /*
     * @date 2018年9月9日
     *
     * @author ybxxszl
     *
     * @description 配置需要过滤的请求路径地址
     *
     * @param registry
     *
     * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#
     * addInterceptors(org.springframework.web.servlet.config.annotation.
     * InterceptorRegistry)
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(systemInterceptor).addPathPatterns("/**");

    }

}
