package com.wjy.mapper.custom;

import com.wjy.GeneralMapper;
import com.wjy.bean.AuthorLoginBean;
import com.wjy.pojo.Author;

public interface AuthorMapperCustom extends GeneralMapper<Author> {

    Author selectAuthorByAuthorLoginBean(AuthorLoginBean authorLoginBean);

    int countAuthorByAuthorAccount(String authorAccount);

    void insertAuthorByAuthor(Author author);

}
