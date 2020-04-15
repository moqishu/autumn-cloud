package com.natsucloud.common.mybatis.service.impl;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.natsucloud.common.constants.EntityConst;
import com.natsucloud.common.mybatis.service.IBaseService;
import com.natsucloud.common.utils.SnowFlake;
import io.swagger.models.Model;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.time.LocalDateTime;
import java.util.*;

/**
 * 服务基类
 * 重复重写ServiceImpl原因：固定代码的命名风格
 * @author moqishu
 *
 * */
public class BaseServiceImpl<M extends BaseMapper<T>,T> extends ServiceImpl<M,T> implements IBaseService<T> {

    private Class<T> modelClass;

    public BaseServiceImpl(){
        ParameterizedType pt = (ParameterizedType)this.getClass().getGenericSuperclass();
        modelClass = (Class<T>)pt.getActualTypeArguments()[1];
    }

    @Override
    public T add(T model) throws Exception {
        List<Field> fieldList = getFields();
        // 如果字段名是id则创建唯一主键值
        for (Field field:fieldList) {
            String fieldName = field.getName();
            // 第一种:框架实现基类id的定义
//            if (fieldName.equalsIgnoreCase("id")) {
//                // 主键赋值
//                setBeanValue(field.getName(), model, SnowFlake.generateId(), field.getGenericType().getTypeName());
//            }
            /*// 第二种:根据注解判断
            TableId tableId = field.getAnnotation(TableId.class);
            if (tableId != null) {
                int type = tableId.type().getKey();
                if (type == IdType.ASSIGN_UUID.getKey()) {
                    setBeanValue(field.getName(), model, "UUIDUtil.get32UUID()");
                } else if (type == IdType.ASSIGN_ID.getKey()) {
                    setBeanValue(field.getName(), model, SnowFlake.generateId(), field.getGenericType().getTypeName());
                } else if (type == IdType.INPUT.getKey()) {
                    Object fieldValue = getFieldValue(fieldName, model);
                    if (fieldValue == null || "".equals(fieldName)) {
                        throw new Exception("主键id生成策略为输入且不能为空");
                    }
                }
                continue;
            }*/
            //设置初始值
            switch (fieldName) {
                case EntityConst.PRIMARY_KEY:
                    setBeanValue(field.getName(), model, SnowFlake.generateId(), field.getGenericType().getTypeName());
                case EntityConst.CREATE_ID:
                    setBeanValue(fieldName, model, "getUserId()", field.getGenericType().getTypeName());
                    break;
                case EntityConst.CREATE_NAME:
                    setBeanValue(fieldName, model, "getUserName()", field.getGenericType().getTypeName());
                    break;
                case EntityConst.CREATE_TIME:
                    setBeanValue(fieldName, model, LocalDateTime.now(), field.getGenericType().getTypeName());
                    break;
                default:
                    break;
            }
        }
        baseMapper.insert(model);
        return model;
    }

    @Override
    public T update(T model) throws Exception {
        List<Field> fieldList = getFields();
        for (Field f : fieldList) {
            f.setAccessible(true); // 设置些属性是可以访问的
            String fieldName = f.getName();
            switch (fieldName) {
                case EntityConst.UPDATE_ID:
                    setBeanValue(fieldName, model, "getUserId()", f.getGenericType().getTypeName());
                    break;
                case EntityConst.UPDATE_NAME:
                    setBeanValue(fieldName, model, "getUserName()", f.getGenericType().getTypeName());
                    break;
                case EntityConst.UPDATE_TIME:
                    setBeanValue(fieldName, model, new Date(), f.getGenericType().getTypeName());
                    break;
                default:
                    break;
            }
        }
        baseMapper.updateById(model);
        return model;
    }

    @Override
    public List<T> add(List<T> models) throws Exception {
        List<T> result = new ArrayList<>();
        for(T model : models){
            add(model);
            result.add(model);
        }
        return result;
    }

    @Override
    public List<T> update(List<T> models) throws Exception {
        List<T> result = new ArrayList<>();
        for(T model : models){
            update(model);
            result.add(model);
        }
        return result;
    }

    @Override
    public T findById(long id) throws Exception {
        T model = baseMapper.selectById(id);
        return model;
    }

    @Override
    public List<T> findAll() throws Exception {
        List<T> result = baseMapper.selectList(null);
        return result;
    }

    @Override
    public List<T> findByMap(Map<String, Object> map) throws Exception {
        //Map<String,Object> map = new HashMap<>();
        //map.put("carPlateNum","闽A009428");
        return baseMapper.selectByMap(map);
    }

    @Override
    public List<T> findByQuery(Wrapper queryWrapper) throws Exception {
        return baseMapper.selectList(queryWrapper);
    }

    private List<Field> getFields() {
        List<Field> fieldList = new ArrayList<>(Arrays.asList(modelClass.getDeclaredFields()));
        // 获取基类的字段
        for (Field f : modelClass.getSuperclass().getDeclaredFields())
            fieldList.add(f);
        return fieldList;
    }

    private Object getFieldValue(String fieldName, Object model) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = modelClass.getMethod("get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
        return method.invoke(model);
    }

    private void setBeanValue(String fieldName,Object model,Object value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method methodSet = modelClass.getMethod("set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1), value.getClass());
        methodSet.invoke(model, value);
    }

    private void setDeclaredValue(String fieldName,Object model,Object value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method methodSet = modelClass.getSuperclass().getDeclaredMethod("set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1), long.class);
        methodSet.invoke(value);
    }

    private void setBeanValue(String fieldName,Object model,Object value,String fieldType) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (value == null || "".equals(value)) {
            return;
        }
        // 反射字段的数据类型fieldType
        if (StringUtils.isNotBlank(fieldType)) {
            if ("java.lang.Long".equals(fieldType)) {
                value = Long.parseLong(value + "");
            } else if ("java.lang.Integer".equals(fieldType)) {
                value = Integer.parseInt(value + "");
            }
        }
        setBeanValue(fieldName, model, value);
    }
}
