package com.wjy.service.wechat;

import com.wjy.bean.offical.UserInfoBean;

import java.util.Map;

public interface AuthorServiceWeChat {

    Map<String, Object> loginAuthor(String code) throws Exception;

    boolean verifyEmail(String wxAuthorEmail) throws Exception;

    void registerAuthor(String wxAuthorEmail, UserInfoBean userInfoBean) throws Exception;

}
