package com.wjy.webmvc;

import com.wjy.interceptor.website.WebSiteHandlerInterceptor;
import com.wjy.interceptor.wechat.WeChatHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ybxxszl
 * @date 2019年1月24日
 * @description 配置过滤请求路径
 */
@Configuration
public class SystemWebMvcConfigurer implements WebMvcConfigurer {

    @Autowired
    private WebSiteHandlerInterceptor websiteHandlerInterceptor;

    @Autowired
    private WeChatHandlerInterceptor wechatHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(websiteHandlerInterceptor).addPathPatterns("/website/**");

        registry.addInterceptor(wechatHandlerInterceptor).addPathPatterns("/wechat/**");

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

    }

}
