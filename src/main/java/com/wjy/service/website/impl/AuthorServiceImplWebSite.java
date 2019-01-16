package com.wjy.service.website.impl;

import com.wjy.bean.offical.AuthorLoginBean;
import com.wjy.mapper.custom.AuthorMapperCustom;
import com.wjy.pojo.Author;
import com.wjy.service.website.AuthorServiceWebSite;
import com.wjy.util.UUIDUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Author login(AuthorLoginBean authorLoginBean) {

        try {

            Author a = authorMapperCustom.selectAuthorByAuthorLoginBean(authorLoginBean);

            return a;

        } catch (Exception e) {

            throw e;

        }

    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public int verify(String authorAccount) {

        try {

            int count = authorMapperCustom.countAuthorByAuthorAccount(authorAccount);

            return count;

        } catch (Exception e) {

            throw e;

        }

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public void register(Author author) {

        try {

            author.setAuthorId(UUIDUtil.getUUID());

            authorMapperCustom.insertAuthorByAuthor(author);

        } catch (Exception e) {

            throw e;

        }

    }

}
