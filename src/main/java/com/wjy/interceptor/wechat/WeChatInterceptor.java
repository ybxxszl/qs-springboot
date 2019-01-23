package com.wjy.interceptor.wechat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ybxxszl
 * @date 2018年1月23日
 * @description 过滤请求路径需要执行的方法
 */
@Component
public class WeChatInterceptor implements HandlerInterceptor {

	/**
	 * 请求处理之前，视图渲染之前
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		System.out.println("请求处理之前，视图渲染之前");

		return true;

	}

	/**
	 * 请求处理之后，视图渲染之前
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mav)
			throws Exception {

		System.out.println("请求处理之后，视图渲染之前");

	}

	/**
	 * 请求处理之后，视图渲染之后
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) throws Exception {

	}

}
