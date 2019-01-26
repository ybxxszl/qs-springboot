package com.wjy.service.website.impl;

import com.wjy.bean.AuthorLoginBean;
import com.wjy.mapper.custom.AuthorMapperCustom;
import com.wjy.pojo.Author;
import com.wjy.service.website.AuthorServiceWebSite;
import com.wjy.util.RandomCodeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ybxxszl
 * @date 2019年1月13日
 * @description 网站作者服务
 */
@Service
public class AuthorServiceImplWebSite implements AuthorServiceWebSite {

    @Resource
    private AuthorMapperCustom authorMapperCustom;

    @Override
    public Author login(AuthorLoginBean authorLoginBean) {

        Author a = authorMapperCustom.selectAuthorByAuthorLoginBean(authorLoginBean);

        return a;

    }

    @Override
    public int verify(String authorAccount) {

        int count = authorMapperCustom.countAuthorByAuthorAccount(authorAccount);

        return count;

    }

    @Override
    public void register(Author author) {

        author.setAuthorId(RandomCodeUtil.getUUID());

        authorMapperCustom.insertAuthorByAuthor(author);

    }

}
