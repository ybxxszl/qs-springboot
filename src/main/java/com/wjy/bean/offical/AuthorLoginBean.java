package com.wjy.bean.offical;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Date 2019/1/13
 * @Author ybxxszl
 * @Desc 作者登录实体
 **/
public class AuthorLoginBean {

    @ApiModelProperty(value = "账号", example = "admin", hidden = false)
    private String authorAccount;

    @ApiModelProperty(value = "密码", example = "1234", hidden = false)
    private String authorPassword;

    public String getAuthorAccount() {
        return authorAccount;
    }

    public void setAuthorAccount(String authorAccount) {
        this.authorAccount = authorAccount;
    }

    public String getAuthorPassword() {
        return authorPassword;
    }

    public void setAuthorPassword(String authorPassword) {
        this.authorPassword = authorPassword;
    }

    @Override
    public String toString() {
        return "AuthorLoginBean{" +
                "authorAccount='" + authorAccount + '\'' +
                ", authorPassword='" + authorPassword + '\'' +
                '}';
    }

}
