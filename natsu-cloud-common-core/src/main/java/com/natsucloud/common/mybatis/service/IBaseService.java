package com.natsucloud.common.mybatis.service;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IBaseService<T> extends IService<T> {

    /*
    * 新增
    * @param model
    * */
    T add(T model) throws Exception;

    T update(T model) throws Exception;

    List<T> add(List<T> models) throws Exception;

    List<T> update(List<T> models) throws Exception;

    T findById(long id) throws Exception;

    List<T> findAll() throws Exception;

}
