package com.wjy.controller.wechat;

import cn.binarywang.wx.miniapp.util.crypt.WxMaCryptUtils;
import com.alibaba.fastjson.JSONObject;
import com.wjy.bean.offical.UserInfoBean;
import com.wjy.bean.offical.WXAuthorRegisterBean;
import com.wjy.pojo.JSONResult;
import com.wjy.send.mail.VerifyCode;
import com.wjy.service.wechat.AuthorServiceWeChat;
import com.wjy.util.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author ybxxszl
 * @date 2019年1月13日
 * @description 微信作者控制
 */
@Api(tags = "微信作者控制")
@RestController
@RequestMapping(value = "/wechat/author")
public class WeChatAuthorController {

    @Autowired
    private AuthorServiceWeChat authorServiceWeChat;

    private VerifyCode verifyCode = new VerifyCode();

    private RedisUtil redisUtil = new RedisUtil();

    @ApiOperation(value = "微信作者登录")
    @ApiImplicitParam(name = "code", value = "临时登录凭证", example = "1234", dataType = "String", paramType = "query", required = true)
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public JSONResult login(@Param(value = "code") String code) {

        try {

            Map<String, Object> map = authorServiceWeChat.loginAuthor(code);

            return JSONResult.ok(map);

        } catch (Exception e) {

            e.printStackTrace();

            return JSONResult.errorMsg(e.getMessage());

        }

    }

    @ApiOperation(value = "发送验证码")
    @ApiImplicitParam(name = "wxAuthorEmail", value = "作者电子邮件", example = "1062837400@qq.com", dataType = "String", paramType = "query", required = true)
    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public JSONResult send(@Param(value = "wxAuthorEmail") String wxAuthorEmail) {

        try {

            boolean flag = authorServiceWeChat.verifyEmail(wxAuthorEmail);

            if (flag) {

                if (verifyCode.send(wxAuthorEmail).getInteger("code") != 200) {

                    JSONResult.errorMsg("验证码发送失败");

                }

            } else {

                JSONResult.errorMsg("该邮箱已注册");

            }

            return JSONResult.ok("验证码发送成功");

        } catch (Exception e) {

            e.printStackTrace();

            return JSONResult.errorMsg(e.getMessage());

        }

    }

    @ApiOperation(value = "微信作者注册")
    @ApiImplicitParam(name = "registerWXAuthor", value = "作者注册实体", dataType = "WXAuthorRegisterBean", paramType = "body", required = true)
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public JSONResult register(@RequestBody WXAuthorRegisterBean wxAuthorRegisterBean) {

        try {

            String VerifyCode = redisUtil.get("verifycode:" + wxAuthorRegisterBean.getWxAuthorEmail());

            if (!VerifyCode.equals(wxAuthorRegisterBean.getVerifyCode())) {

                return JSONResult.errorMsg("验证码错误，请重新输入");

            }

            String text = WxMaCryptUtils.decrypt(wxAuthorRegisterBean.getSessionKey(), wxAuthorRegisterBean.getEncryptedData(), wxAuthorRegisterBean.getIv());

            UserInfoBean userInfoBean = JSONObject.parseObject(text, UserInfoBean.class);

            authorServiceWeChat.registerAuthor(wxAuthorRegisterBean.getWxAuthorEmail(), userInfoBean);

            return JSONResult.ok("注册成功");

        } catch (Exception e) {

            e.printStackTrace();

            return JSONResult.errorMsg(e.getMessage());

        }

    }

}
