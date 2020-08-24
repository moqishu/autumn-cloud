package com.natsucloud.dba.mybatis.controller;


import com.alibaba.fastjson.JSON;
import com.natsucloud.dba.mybatis.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

public abstract class BaseController<M extends IBaseService<T>,T> {

    @Autowired
    protected M baseService;

    @PostMapping(value = "add")
    public String add(T model) throws Exception {
        baseService.add(model);
        return JSON.toJSONString(model);
    }

    public String update(T model) throws Exception {
        baseService.update(model);
        return JSON.toJSONString(model);
    }



}
