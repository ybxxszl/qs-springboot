package com.wjy.request.interceptor.wechat;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.wjy.request.filter.RequestFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ybxxszl
 * @date 2018年1月24日
 * @description 过滤请求路径需要执行的方法
 */
@Component
public class WeChatHandlerInterceptor implements HandlerInterceptor {

    /**
     * 请求处理之前，视图渲染之前
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        boolean flag = RequestFilter.filter(request);

        if (flag) {

            return true;

        } else {

            response.sendError(500, "请重新登录");

            return false;

        }

    }

    /**
     * 请求处理之后，视图渲染之前
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mav)
            throws Exception {

    }

    /**
     * 请求处理之后，视图渲染之后
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception exception) throws Exception {

    }

}
