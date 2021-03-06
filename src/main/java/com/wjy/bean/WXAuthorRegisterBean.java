package com.wjy.bean;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Date 2019/1/20
 * @Author ybxxszl
 * @Desc 微信作者登录实体
 **/
public class WXAuthorRegisterBean {

    @ApiModelProperty(value = "电子邮件", example = "1062837400@qq.com", hidden = false)
    private String wxAuthorEmail;

    @ApiModelProperty(value = "验证码", example = "123456", hidden = false)
    private String verifyCode;

    @ApiModelProperty(value = "encryptedData", example = "encryptedData", hidden = false)
    private String encryptedData;

    @ApiModelProperty(value = "iv", example = "iv", hidden = false)
    private String iv;

    @ApiModelProperty(value = "sessionKey", example = "sessionKey", hidden = false)
    private String sessionKey;

    public WXAuthorRegisterBean() {
        super();
    }

    public WXAuthorRegisterBean(String wxAuthorEmail, String verifyCode, String encryptedData, String iv,
                                String sessionKey) {
        super();
        this.wxAuthorEmail = wxAuthorEmail;
        this.verifyCode = verifyCode;
        this.encryptedData = encryptedData;
        this.iv = iv;
        this.sessionKey = sessionKey;
    }

    public String getWxAuthorEmail() {
        return wxAuthorEmail;
    }

    public void setWxAuthorEmail(String wxAuthorEmail) {
        this.wxAuthorEmail = wxAuthorEmail;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    @Override
    public String toString() {
        return "WXAuthorRegisterBean{" +
                "wxAuthorEmail='" + wxAuthorEmail + '\'' +
                ", verifyCode='" + verifyCode + '\'' +
                ", encryptedData='" + encryptedData + '\'' +
                ", iv='" + iv + '\'' +
                ", sessionKey='" + sessionKey + '\'' +
                '}';
    }

}
