package com.wjy.request.webmvc;

import com.wjy.request.interceptor.website.WebSiteHandlerInterceptor;
import com.wjy.request.interceptor.wechat.WeChatHandlerInterceptor;
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

		// 网站请求路径
		registry.addInterceptor(websiteHandlerInterceptor).addPathPatterns("/website/**");

		// 微信请求路径
		registry.addInterceptor(wechatHandlerInterceptor).addPathPatterns("/wechat/**");

	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		// Swagger API
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

	}

}
