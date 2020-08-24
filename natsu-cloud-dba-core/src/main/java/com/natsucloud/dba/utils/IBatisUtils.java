package com.natsucloud.dba.utils;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.natsucloud.dba.constants.IBatisConst;
import com.natsucloud.dba.model.WhereEntity;

import java.util.List;
import java.util.Map;

/**
 * mybatis工具类
 * @author moqishu
 *
 * */
public class IBatisUtils {

    private IBatisUtils(){}

    public static WhereEntity parseWrapper(Map<String, Object> map) {
        QueryWrapper queryWrapper = new QueryWrapper();
        for (Map.Entry<String, Object> m : map.entrySet()){
            String colName = m.getValue().toString();
            if(colName.isEmpty()){ // 空则不传入条件过滤
                continue;
            }
            String[] keyAndType = m.getKey().split("&");
            String key = keyAndType[0];
            String type = keyAndType.length>1?keyAndType[1]:"";
            if(key.equals("currentPage") || key.equals("pageSize")){
                continue;
            }
            switch (type){
                case "eq":queryWrapper.eq(key,colName);break;
                case "ne":queryWrapper.ne(key,colName);break;
                case "like": queryWrapper.like(key,colName);break;
                case "likeLeft": queryWrapper.likeLeft(key,colName);break;
                case "likeRight": queryWrapper.likeRight(key,colName);break;
                case "notLike": queryWrapper.notLike(key,colName);break;
                case "gt": queryWrapper.gt(key,colName);break;
                case "lt": queryWrapper.lt(key,colName);break;
                case "ge": queryWrapper.ge(key,colName);break;
                case "le": queryWrapper.le(key,colName);break;
                default:queryWrapper.eq(key,colName);break;
            }
        }
        int currentPage = (int)map.get("currentPage");
        int pageSize = (int)map.get("pageSize");

        WhereEntity model = new WhereEntity();
        model.whereSql = queryWrapper;
        model.page = new Page(currentPage,pageSize);
        return model;
    }

    public static WhereEntity parseWhere(String conditionJson) {
        Map<String, Object> map = (Map) JSON.parse(conditionJson);
        return parseWrapper(map);
    }

    public static Map<String,Object> parseDateFormat(Map<String,Object> map){
        for(Map.Entry<String,Object> model : map.entrySet()){
            String key = model.getKey();
            String typeName = model.getValue().getClass().getTypeName();
            switch (typeName){
                case IBatisConst.IBF_TIMESTAMP_TYPE:
                case IBatisConst.IBF_DATE_TYPE:
                case IBatisConst.IBF_LOCALDATETIME_TYPE:
                case IBatisConst.IBF_LOCALDATE_TYPE:
                    String value = model.getValue().toString();
                    map.put(key,value);
                    break;
            }
        }
        return map;
    }


    public static List<Map<String,Object>> parseDateFormat(List<Map<String,Object>> mapList) {
        for (Map<String, Object> map : mapList) {
            parseDateFormat(map);
        }
        return mapList;
    }

}

