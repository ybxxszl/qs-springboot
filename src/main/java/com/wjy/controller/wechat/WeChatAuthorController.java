package com.wjy.controller.wechat;

import cn.binarywang.wx.miniapp.util.crypt.WxMaCryptUtils;
import com.alibaba.fastjson.JSONObject;
import com.wjy.bean.WXAuthorRegisterBean;
import com.wjy.bean.WXUserInfoBean;
import com.wjy.response.ResultBuilder;
import com.wjy.service.wechat.AuthorServiceWeChat;
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

	@ApiOperation(value = "微信作者登录")
	@ApiImplicitParam(name = "code", value = "临时登录凭证", example = "1234", dataType = "String", paramType = "query", required = true)
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ResultBuilder login(@Param(value = "code") String code) {

		try {

			Map<String, Object> map = authorServiceWeChat.login(code);

			return ResultBuilder.success(map, null);

		} catch (Exception e) {

			e.printStackTrace();

			return ResultBuilder.error(e);

		}

	}

	@ApiOperation(value = "发送验证码")
	@ApiImplicitParam(name = "wxAuthorEmail", value = "电子邮件", example = "1062837400@qq.com", dataType = "String", paramType = "query", required = true)
	@RequestMapping(value = "/send", method = RequestMethod.GET)
	public ResultBuilder send(@Param(value = "wxAuthorEmail") String wxAuthorEmail) {

		try {

			boolean flag = authorServiceWeChat.verifyEmail(wxAuthorEmail);

			if (flag) {

			} else {

				throw new Exception("该邮箱已注册");

			}

			return ResultBuilder.success(null, "验证码发送成功");

		} catch (Exception e) {

			e.printStackTrace();

			return ResultBuilder.error(e);

		}

	}

	@ApiOperation(value = "微信作者注册")
	@ApiImplicitParam(name = "wxAuthorRegisterBean", value = "微信作者", dataType = "WXAuthorRegisterBean", paramType = "body", required = true)
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResultBuilder register(@RequestBody WXAuthorRegisterBean wxAuthorRegisterBean) {

		try {

			if (!"123456".equals(wxAuthorRegisterBean.getVerifyCode())) {

				throw new Exception("验证码错误，请重新输入");

			}

			String text = WxMaCryptUtils.decrypt(wxAuthorRegisterBean.getSessionKey(),
					wxAuthorRegisterBean.getEncryptedData(), wxAuthorRegisterBean.getIv());

			WXUserInfoBean wxUserInfoBean = JSONObject.parseObject(text, WXUserInfoBean.class);

			authorServiceWeChat.register(wxAuthorRegisterBean.getWxAuthorEmail(), wxUserInfoBean);

			return ResultBuilder.success(null, "注册成功");

		} catch (Exception e) {

			e.printStackTrace();

			return ResultBuilder.error(e);

		}

	}

}
