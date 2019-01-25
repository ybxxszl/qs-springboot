package com.wjy.send.mail;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.wjy.redis.RedisUtil;
import com.wjy.util.HttpClientUtil;
import com.wjy.util.PropertiesUtil;
import com.wjy.util.RandomCodeUtil;

public class VerifyCode {
	
	@Autowired
	private RedisUtil redisUtil;

    private static String mqUrl;
    private static String mqVerifyCodeMills;

    static {

        mqUrl = PropertiesUtil.getValue("mq.url");
        mqVerifyCodeMills = PropertiesUtil.getValue("mq.verifycode.mills");

    }

    public JSONObject send(String authorEmail) throws Exception {

        String verifyCode = RandomCodeUtil.getVerifyCode();

        redisUtil.setValue("verifycode:" + authorEmail, verifyCode, Integer.parseInt(mqVerifyCodeMills));

        JSONObject mqInfo = new JSONObject();
        JSONObject mailInfo = new JSONObject();

        mailInfo.put("recipientAddress", authorEmail);
        mailInfo.put("text", verifyCode);

        mqInfo.put("type", "pc");
        mqInfo.put("name", "Mail_VerifyCode");
        mqInfo.put("mailInfo", mailInfo);
        mqInfo.put("smsInfo", null);

        JSONObject object = HttpClientUtil.doPost(mqUrl + "/postVerifyCode", mqInfo, null);

        return object;

    }

}
