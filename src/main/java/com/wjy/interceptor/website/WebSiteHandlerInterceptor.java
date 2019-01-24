package com.wjy.interceptor.website;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ybxxszl
 * @date 2018年1月24日
 * @description 网站过滤请求路径需要执行的方法
 */
@Component
public class WebSiteHandlerInterceptor implements HandlerInterceptor {

	/**
	 * 请求处理之前，视图渲染之前
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// System.out.println("请求处理之前，视图渲染之前");

		// System.out.println("preHandle方法中");
		// System.out.println("Object参数：" + handler);

		return true;

	}

	/**
	 * 请求处理之后，视图渲染之前
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mav)
			throws Exception {

		// System.out.println("请求处理之后，视图渲染之前");

		// System.out.println("postHandle方法中");
		// System.out.println("Object参数：" + handler);
		// System.out.println("ModelAndView参数：" + mav);

	}

	/**
	 * 请求处理之后，视图渲染之后
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) throws Exception {

		// System.out.println("请求处理之后，视图渲染之后");

		// System.out.println("afterCompletion方法中");
		// System.out.println("Object参数：" + handler);
		// System.out.println("Exception参数：" + exception);

	}

}
