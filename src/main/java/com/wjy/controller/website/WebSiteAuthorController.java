package com.wjy.controller.website;

import com.wjy.bean.AuthorLoginBean;
import com.wjy.pojo.Author;
import com.wjy.response.ResultBuilder;
import com.wjy.service.website.AuthorServiceWebSite;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ybxxszl
 * @date 2019年1月13日
 * @description 网站作者控制
 */
@Api(tags = "网站作者控制")
@RestController
@RequestMapping(value = "/website/author")
public class WebSiteAuthorController {

    @Autowired
    private AuthorServiceWebSite authorServiceWebSite;

    @ApiOperation(value = "网站作者登录")
    @ApiImplicitParam(name = "authorLoginBean", value = "作者登录实体", dataType = "AuthorLoginBean", paramType = "body", required = true)
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultBuilder login(@RequestBody AuthorLoginBean authorLoginBean) {

        try {

            Author a = authorServiceWebSite.login(authorLoginBean);

            return ResultBuilder.success(a, null);

        } catch (Exception e) {

            e.printStackTrace();

            return ResultBuilder.error(e);

        }

    }

    @ApiOperation(value = "验证账号是否存在")
    @ApiImplicitParam(name = "authorAccount", value = "作者账号", example = "admin", dataType = "String", paramType = "query", required = true)
    @RequestMapping(value = "/verify", method = RequestMethod.GET)
    public ResultBuilder verify(@Param(value = "authorAccount") String authorAccount) {

        try {

            int count = authorServiceWebSite.verify(authorAccount);

            return ResultBuilder.success(count, null);

        } catch (Exception e) {

            e.printStackTrace();

            return ResultBuilder.error(e);

        }

    }

    @ApiOperation(value = "网站作者注册")
    @ApiImplicitParam(name = "author", value = "作者实体", dataType = "Author", paramType = "body", required = true)
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResultBuilder register(@RequestBody Author author) {

        try {

            authorServiceWebSite.register(author);

            return ResultBuilder.success(null, "注册成功");

        } catch (Exception e) {

            e.printStackTrace();

            return ResultBuilder.error(e);

        }

    }

}
