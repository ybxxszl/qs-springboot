package com.wjy.mapper.custom;

import com.wjy.GeneralMapper;
import com.wjy.pojo.DesignTemplet;

import java.util.List;

public interface DesignTempletMapperCustom extends GeneralMapper<DesignTemplet> {

    List<DesignTemplet> selectDesignTempletsByWXAuthorId(String searchContent, Integer itemBegin, Integer itemEnd);

}
