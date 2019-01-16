package com.wjy.exception.business;

import com.wjy.pojo.JSONResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ybxxszl
 * @date 2018年9月9日
 * @description 业务异常统一处理
 */
@ControllerAdvice
public class BusinessExceptionHandler {

    /**
     * @param request
     * @param response
     * @param exception
     * @return Object
     * @date 2018年9月9日
     * @author ybxxszl
     * @description 处理被捕获的异常
     */
    @ExceptionHandler(value = BusinessException.class)
    public Object errorHandler(HttpServletRequest request, HttpServletResponse response, BusinessException exception) {

        System.out.println("业务异常");

        exception.printStackTrace();

        return JSONResult.errorMsg(exception.getMessage());

    }

}
