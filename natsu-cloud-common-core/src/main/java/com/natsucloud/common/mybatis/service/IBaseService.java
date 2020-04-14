package com.natsucloud.common.mybatis.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

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

    List<T> findByMap(Map<String,Object> map) throws Exception;

    List<T> findByQuery(Wrapper queryWrapper) throws Exception;

}
