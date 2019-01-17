package com.wjy.service.wechat;

import com.wjy.bean.offical.UserInfoBean;

import java.util.Map;

public interface AuthorServiceWeChat {

    Map<String, Object> login(String code) throws Exception;

    boolean verifyEmail(String wxAuthorEmail) throws Exception;

    void register(String wxAuthorEmail, UserInfoBean userInfoBean) throws Exception;

}
