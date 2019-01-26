package com.wjy.service.wechat.impl;

import com.wjy.mapper.custom.DesignTempletMapperCustom;
import com.wjy.pojo.DesignTemplet;
import com.wjy.service.wechat.DesignTempletServiceWeChat;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Date 2019/1/20
 * @Author ybxxszl
 * @Desc 微信调查问卷服务
 **/
@Service
public class DesignTempletServiceImplWeChat implements DesignTempletServiceWeChat {

    @Resource
    private DesignTempletMapperCustom designTempletMapperCustom;

    @Override
    public List<DesignTemplet> getDesignTempletList(String searchContent, Integer pageCurrent, Integer pageSize) {

        Integer itemBegin = (pageCurrent - 1) * pageSize;
        Integer itemEnd = pageCurrent * pageSize;

        if (searchContent == null) {
            searchContent = "%" + "%";
        } else {
            searchContent = "%" + searchContent + "%";
        }

        List<DesignTemplet> designTempletList = designTempletMapperCustom.selectDesignTempletsByWXAuthorId(searchContent, itemBegin, itemEnd);

        return designTempletList;

    }

}
