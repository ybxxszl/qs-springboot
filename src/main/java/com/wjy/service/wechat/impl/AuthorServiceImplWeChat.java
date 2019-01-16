package com.wjy.service.wechat.impl;

import com.alibaba.fastjson.JSONObject;
import com.wjy.bean.offical.UserInfoBean;
import com.wjy.mapper.custom.WXAuthorMapperCustom;
import com.wjy.pojo.WXAuthor;
import com.wjy.service.wechat.AuthorServiceWeChat;
import com.wjy.util.RandomCodeUtil;
import com.wjy.util.TokenUtil;
import com.wjy.util.WeChatUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ybxxszl
 * @date 2019年1月13日
 * @description 微信用户服务
 */
@Service
public class AuthorServiceImplWeChat implements AuthorServiceWeChat {

    @Resource
    private WXAuthorMapperCustom wxAuthorMapperCustom;

    @Override
    public Map<String, Object> loginAuthor(String code) throws Exception {

        Map<String, Object> map = new HashMap<String, Object>();

        JSONObject object = WeChatUtil.getCode2Session(code);

        if (object.containsKey("session_key")) {

            WXAuthor wxAuthor = wxAuthorMapperCustom.selectWXAuthorByWXAuthorOpenId(object.getString("open_id"));

            if (wxAuthor != null) {

                Map<String, Object> mapWXAuthor = new HashMap<String, Object>();

                mapWXAuthor.put("wxAuthorId", wxAuthor.getWxAuthorId());
                mapWXAuthor.put("wxAuthorEmail", wxAuthor.getWxAuthorEmail());
                mapWXAuthor.put("wxAuthorNickName", wxAuthor.getWxAuthorNickName());
                mapWXAuthor.put("wxAuthorSex", wxAuthor.getWxAuthorSex());
                mapWXAuthor.put("wxAuthorCountry", wxAuthor.getWxAuthorCountry());
                mapWXAuthor.put("wxAuthorCity", wxAuthor.getWxAuthorCity());
                mapWXAuthor.put("wxAuthorProvince", wxAuthor.getWxAuthorProvince());
                mapWXAuthor.put("wxAuthorAvatarUrl", wxAuthor.getWxAuthorAvatarUrl());
                mapWXAuthor.put("wxAuthorOpenId", wxAuthor.getWxAuthorOpenId());

                map.put("WXAuthor", mapWXAuthor);

            }

            String sessionKey = object.getString("session_key");
            String token = TokenUtil.getToken(wxAuthor.getWxAuthorId());

            map.put("sessionKey", sessionKey);
            map.put("token", token);

        } else {

            throw new Exception(object.getString("errMsg"));

        }

        return map;

    }

    @Override
    public boolean verifyEmail(String wxAuthorEmail) throws Exception {

        int count = wxAuthorMapperCustom.countWXAuthorByWXAuthorEmail(wxAuthorEmail);

        if (count == 0) {

            return true;

        } else {

            return false;

        }

    }

    @Override
    public void registerAuthor(String wxAuthorEmail, UserInfoBean userInfoBean) throws Exception {

        String sex = "未知";

        if (userInfoBean.getGender() == 1) {

            sex = "男";

        }
        if (userInfoBean.getGender() == 2) {

            sex = "女";

        }

        WXAuthor wxAuthor = new WXAuthor();

        wxAuthor.setWxAuthorId(RandomCodeUtil.getUUID());
        wxAuthor.setWxAuthorEmail(wxAuthorEmail);
        wxAuthor.setWxAuthorNickName(userInfoBean.getNickName());
        wxAuthor.setWxAuthorSex(sex);
        wxAuthor.setWxAuthorCountry(userInfoBean.getCountry());
        wxAuthor.setWxAuthorCity(userInfoBean.getCity());
        wxAuthor.setWxAuthorProvince(userInfoBean.getProvince());
        wxAuthor.setWxAuthorAvatarUrl(userInfoBean.getAvatarUrl());
        wxAuthor.setWxAuthorOpenId(userInfoBean.getOpenId());

        wxAuthorMapperCustom.insertWXAuthorByWXAuthor(wxAuthor);

    }

}
