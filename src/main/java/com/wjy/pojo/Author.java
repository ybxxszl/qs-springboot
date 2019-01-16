package com.wjy.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class Author {

    @ApiModelProperty(value = "作者ID", hidden = true)
    @Id
    @Column(name = "author_id")
    private String authorId;

    @ApiModelProperty(value = "账号", example = "test", hidden = false)
    @Column(name = "author_account")
    private String authorAccount;

    @ApiModelProperty(value = "密码", example = "0000", hidden = false)
    @Column(name = "author_password")
    private String authorPassword;

    @ApiModelProperty(value = "姓名", example = "王军岩", hidden = false)
    @Column(name = "author_name")
    private String authorName;

    @ApiModelProperty(value = "性别", example = "男", hidden = false)
    @Column(name = "author_sex")
    private String authorSex;

    @ApiModelProperty(value = "出生日期", example = "1995/10/16", hidden = false)
    @JsonFormat(pattern = "yyyy/MM/dd", locale = "zh", timezone = "GMT+8")
    @Column(name = "author_birthday")
    private Date authorBirthday;

    @ApiModelProperty(value = "电话号码", example = "18743102774", hidden = false)
    @Column(name = "author_phone")
    private String authorPhone;

    @ApiModelProperty(value = "电子邮件", example = "1062837400@qq.com", hidden = false)
    @Column(name = "author_email")
    private String authorEmail;

    @ApiModelProperty(value = "照片", example = "logo.jpg", hidden = false)
    @Column(name = "author_photo")
    private String authorPhoto;

    @ApiModelProperty(value = "状态", example = "1", dataType = "Integer", hidden = false)
    @Column(name = "author_state")
    private Integer authorState;

    /**
     * @return author_id
     */
    public String getAuthorId() {
        return authorId;
    }

    /**
     * @param authorId
     */
    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    /**
     * @return author_account
     */
    public String getAuthorAccount() {
        return authorAccount;
    }

    /**
     * @param authorAccount
     */
    public void setAuthorAccount(String authorAccount) {
        this.authorAccount = authorAccount;
    }

    /**
     * @return author_password
     */
    public String getAuthorPassword() {
        return authorPassword;
    }

    /**
     * @param authorPassword
     */
    public void setAuthorPassword(String authorPassword) {
        this.authorPassword = authorPassword;
    }

    /**
     * @return author_name
     */
    public String getAuthorName() {
        return authorName;
    }

    /**
     * @param authorName
     */
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    /**
     * @return author_sex
     */
    public String getAuthorSex() {
        return authorSex;
    }

    /**
     * @param authorSex
     */
    public void setAuthorSex(String authorSex) {
        this.authorSex = authorSex;
    }

    /**
     * @return author_birthday
     */
    public Date getAuthorBirthday() {
        return authorBirthday;
    }

    /**
     * @param authorBirthday
     */
    public void setAuthorBirthday(Date authorBirthday) {
        this.authorBirthday = authorBirthday;
    }

    /**
     * @return author_phone
     */
    public String getAuthorPhone() {
        return authorPhone;
    }

    /**
     * @param authorPhone
     */
    public void setAuthorPhone(String authorPhone) {
        this.authorPhone = authorPhone;
    }

    /**
     * @return author_email
     */
    public String getAuthorEmail() {
        return authorEmail;
    }

    /**
     * @param authorEmail
     */
    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    /**
     * @return author_photo
     */
    public String getAuthorPhoto() {
        return authorPhoto;
    }

    /**
     * @param authorPhoto
     */
    public void setAuthorPhoto(String authorPhoto) {
        this.authorPhoto = authorPhoto;
    }

    /**
     * @return author_state
     */
    public Integer getAuthorState() {
        return authorState;
    }

    /**
     * @param authorState
     */
    public void setAuthorState(Integer authorState) {
        this.authorState = authorState;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId='" + authorId + '\'' +
                ", authorAccount='" + authorAccount + '\'' +
                ", authorPassword='" + authorPassword + '\'' +
                ", authorName='" + authorName + '\'' +
                ", authorSex='" + authorSex + '\'' +
                ", authorBirthday=" + authorBirthday +
                ", authorPhone='" + authorPhone + '\'' +
                ", authorEmail='" + authorEmail + '\'' +
                ", authorPhoto='" + authorPhoto + '\'' +
                ", authorState=" + authorState +
                '}';
    }

}
