package com.natsucloud.common.mybatis.service;

import com.baomidou.mybatisplus.extension.service.IService;

public interface BaseService<T> extends IService<T> {

    /*
    * 新增
    * @param model
    * */
    T add(T model) throws Exception;
}
