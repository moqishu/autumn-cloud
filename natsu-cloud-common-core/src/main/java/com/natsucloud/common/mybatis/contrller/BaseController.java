package com.natsucloud.common.mybatis.contrller;


import com.natsucloud.common.mybatis.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

public abstract class BaseController<M extends BaseService<T>,T> {

    @Autowired
    protected M baseService;

    @PostMapping(value = "add")
    public String add(T model) throws Exception {
        baseService.add(model);
        return model.toString();
    }

    public String update(T model) throws Exception {
        baseService.updateById(model);
        return "";
    }

}
