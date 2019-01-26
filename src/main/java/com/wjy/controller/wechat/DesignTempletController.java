package com.wjy.controller.wechat;

import com.wjy.pojo.DesignTemplet;
import com.wjy.response.ResultBuilder;
import com.wjy.service.wechat.DesignTempletServiceWeChat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ybxxszl
 * @date 2019年1月20日
 * @description 微信调查问卷控制
 */
@Api(tags = "微信调查问卷控制")
@RestController
@RequestMapping(value = "/wechat/designTemplet")
public class DesignTempletController {

    @Autowired
    private DesignTempletServiceWeChat designTempletServiceWeChat;

    @ApiOperation(value = "微信调查问卷获取")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "searchContent", value = "搜索内容", example = "searchContent", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "pageCurrent", value = "当前页码", example = "1", dataType = "int", paramType = "query", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", example = "10", dataType = "int", paramType = "query", required = true)
    })
    @RequestMapping(value = "/getDesignTempletList", method = RequestMethod.GET)
    public ResultBuilder getDesignTempletList(@Param(value = "searchContent") String searchContent, @Param(value = "pageCurrent") Integer pageCurrent, @Param(value = "pageSize") Integer pageSize) {

        try {

            List<DesignTemplet> designTempletList = designTempletServiceWeChat.getDesignTempletList(searchContent, pageCurrent, pageSize);

            return ResultBuilder.success(designTempletList, null);

        } catch (Exception e) {

            e.printStackTrace();

            return ResultBuilder.error(e);

        }

    }

}
