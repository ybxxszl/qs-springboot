package com.wjy;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author ybxxszl
 * @date 2018年9月9日
 * @description GeneralMapper通用类
 */
public interface GeneralMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
