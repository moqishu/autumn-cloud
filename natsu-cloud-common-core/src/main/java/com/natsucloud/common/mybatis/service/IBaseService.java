package com.natsucloud.common.mybatis.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.natsucloud.common.model.PageData;

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

    List<T> findByMap(Map<String, Object> map) throws Exception;

    List<T> findByQuery(Wrapper queryWrapper) throws Exception;

    /**
     * @param map 全等于查询条件
     */
    PageData PageList(Map<String, Object> map) throws Exception;

    PageData PageList(String conditionJson) throws Exception;

    @Deprecated
    PageData PageListMap(String conditionJson) throws Exception;
}
