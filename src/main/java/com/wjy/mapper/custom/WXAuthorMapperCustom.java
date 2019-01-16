package com.wjy.mapper.custom;

import com.wjy.GeneralMapper;
import com.wjy.pojo.WXAuthor;

public interface WXAuthorMapperCustom extends GeneralMapper<WXAuthor> {

    WXAuthor selectWXAuthorByWXAuthorOpenId(String wxAuthorOpenId);

    int countWXAuthorByWXAuthorEmail(String wxAuthorEmail);

    void insertWXAuthorByWXAuthor(WXAuthor wxAuthor);

}