package com.wjy.service.wechat;

import com.wjy.pojo.DesignTemplet;

import java.util.List;

public interface DesignTempletServiceWeChat {

    List<DesignTemplet> getDesignTempletList(String searchContent, Integer pageCurrent, Integer pageSize) throws Exception;

}
