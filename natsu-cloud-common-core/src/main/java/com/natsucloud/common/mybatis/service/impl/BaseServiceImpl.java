package com.natsucloud.common.mybatis.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.natsucloud.common.mybatis.service.BaseService;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseServiceImpl<M extends BaseMapper<T>,T> extends ServiceImpl<M,T> implements BaseService<T> {

    private Class<T> modelClass;

    public BaseServiceImpl(){
        ParameterizedType pt = (ParameterizedType)this.getClass().getGenericSuperclass();
        modelClass = (Class<T>)pt.getActualTypeArguments()[1];
    }

    public T add(T model) throws Exception {
        List<Field> fieldList = new ArrayList<Field>(Arrays.asList(modelClass.getDeclaredFields()));
        // 获取基类的字段
        for(Field f:modelClass.getSuperclass().getDeclaredFields()) fieldList.add(f);
        // 如果字段名是id则创建唯一主键值
        for (Field field:fieldList) {
            String fieldName = field.getName();
            if(fieldName.equalsIgnoreCase("id")){
                // 主键赋值

                // 目前只做主键操作，遇到后可直接跳出循环
                break;
            }
        }
        baseMapper.insert(model);
        return model;
    }
}
