package com.wjy.service.website;

import com.wjy.bean.AuthorLoginBean;
import com.wjy.pojo.Author;

public interface AuthorServiceWebSite {

    Author login(AuthorLoginBean authorLoginBean);

    int verify(String authorAccount);

    void register(Author author);

}
