package com.wjy.exception.system;

import com.wjy.pojo.JSONResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ybxxszl
 * @date 2018年9月9日
 * @description 系统异常统一处理
 */
@ControllerAdvice
public class SystemExceptionHandler {

    private final static String ERROR_VIEW = "error";

    /**
     * @param httpRequest
     * @return boolean
     * @date 2018年9月9日
     * @author ybxxszl
     * @description 判断是否Ajax请求
     */
    public static boolean isAjax(HttpServletRequest httpRequest) {
        return (httpRequest.getHeader("X-Requested-With") != null
                && "XMLHttpRequest".equals(httpRequest.getHeader("X-Requested-With").toString()));
    }

    /**
     * @param request
     * @param response
     * @param exception
     * @return Object
     * @date 2018年9月9日
     * @author ybxxszl
     * @description 处理被捕获的异常
     */
    @ExceptionHandler(value = SystemException.class)
    public Object errorHandler(HttpServletRequest request, HttpServletResponse response, SystemException exception) {

        System.out.println("系统异常");

        exception.printStackTrace();

        if (isAjax(request)) {

            return JSONResult.errorException(exception.getMessage());

        } else {

            ModelAndView mav = new ModelAndView();

            mav.addObject("exception", exception);
            mav.addObject("url", request.getRequestURL());
            mav.setViewName(ERROR_VIEW);

            return mav;

        }
    }

}
