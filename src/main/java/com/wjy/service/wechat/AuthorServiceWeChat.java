package com.wjy.service.wechat;

import com.wjy.bean.WXUserInfoBean;

import java.util.Map;

public interface AuthorServiceWeChat {

    Map<String, Object> login(String code) throws Exception;

    boolean verify(String wxAuthorEmail);

    void register(String wxAuthorEmail, WXUserInfoBean wxUserInfoBean);

}
