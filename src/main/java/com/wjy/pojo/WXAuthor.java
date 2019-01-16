package com.wjy.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "wx_author")
public class WXAuthor {
    @Id
    @Column(name = "wx_author_id")
    private String wxAuthorId;

    @Column(name = "wx_author_email")
    private String wxAuthorEmail;

    @Column(name = "wx_author_nick_name")
    private String wxAuthorNickName;

    @Column(name = "wx_author_sex")
    private String wxAuthorSex;

    @Column(name = "wx_author_country")
    private String wxAuthorCountry;

    @Column(name = "wx_author_city")
    private String wxAuthorCity;

    @Column(name = "wx_author_province")
    private String wxAuthorProvince;

    @Column(name = "wx_author_avatar_url")
    private String wxAuthorAvatarUrl;

    @Column(name = "wx_author_open_id")
    private String wxAuthorOpenId;

    /**
     * @return wx_author_id
     */
    public String getWxAuthorId() {
        return wxAuthorId;
    }

    /**
     * @param wxAuthorId
     */
    public void setWxAuthorId(String wxAuthorId) {
        this.wxAuthorId = wxAuthorId;
    }

    /**
     * @return wx_author_email
     */
    public String getWxAuthorEmail() {
        return wxAuthorEmail;
    }

    /**
     * @param wxAuthorEmail
     */
    public void setWxAuthorEmail(String wxAuthorEmail) {
        this.wxAuthorEmail = wxAuthorEmail;
    }

    /**
     * @return wx_author_nick_name
     */
    public String getWxAuthorNickName() {
        return wxAuthorNickName;
    }

    /**
     * @param wxAuthorNickName
     */
    public void setWxAuthorNickName(String wxAuthorNickName) {
        this.wxAuthorNickName = wxAuthorNickName;
    }

    /**
     * @return wx_author_sex
     */
    public String getWxAuthorSex() {
        return wxAuthorSex;
    }

    /**
     * @param wxAuthorSex
     */
    public void setWxAuthorSex(String wxAuthorSex) {
        this.wxAuthorSex = wxAuthorSex;
    }

    /**
     * @return wx_author_country
     */
    public String getWxAuthorCountry() {
        return wxAuthorCountry;
    }

    /**
     * @param wxAuthorCountry
     */
    public void setWxAuthorCountry(String wxAuthorCountry) {
        this.wxAuthorCountry = wxAuthorCountry;
    }

    /**
     * @return wx_author_city
     */
    public String getWxAuthorCity() {
        return wxAuthorCity;
    }

    /**
     * @param wxAuthorCity
     */
    public void setWxAuthorCity(String wxAuthorCity) {
        this.wxAuthorCity = wxAuthorCity;
    }

    /**
     * @return wx_author_province
     */
    public String getWxAuthorProvince() {
        return wxAuthorProvince;
    }

    /**
     * @param wxAuthorProvince
     */
    public void setWxAuthorProvince(String wxAuthorProvince) {
        this.wxAuthorProvince = wxAuthorProvince;
    }

    /**
     * @return wx_author_avatar_url
     */
    public String getWxAuthorAvatarUrl() {
        return wxAuthorAvatarUrl;
    }

    /**
     * @param wxAuthorAvatarUrl
     */
    public void setWxAuthorAvatarUrl(String wxAuthorAvatarUrl) {
        this.wxAuthorAvatarUrl = wxAuthorAvatarUrl;
    }

    /**
     * @return wx_author_open_id
     */
    public String getWxAuthorOpenId() {
        return wxAuthorOpenId;
    }

    /**
     * @param wxAuthorOpenId
     */
    public void setWxAuthorOpenId(String wxAuthorOpenId) {
        this.wxAuthorOpenId = wxAuthorOpenId;
    }
}