package com.natsucloud.dba.model;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * batisPlus插件条件构造模型
 * */
public class WhereEntity {

    public Wrapper whereSql;

    public IPage page;

}
