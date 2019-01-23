package com.wjy.webmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.wjy.interceptor.website.WebSiteInterceptor;
import com.wjy.interceptor.wechat.WeChatInterceptor;

/**
 * @author ybxxszl
 * @date 2019年1月23日
 * @description 配置过滤请求路径
 */
@Configuration
public class SystemWebMvcConfigurer implements WebMvcConfigurer {

	@Autowired
	private WebSiteInterceptor websiteInterceptor;

	@Autowired
	private WeChatInterceptor wechatInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(websiteInterceptor).addPathPatterns("/website/**");

		registry.addInterceptor(wechatInterceptor).addPathPatterns("/wechat/**");

	}

}
