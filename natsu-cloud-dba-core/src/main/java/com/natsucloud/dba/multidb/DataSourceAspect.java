package com.natsucloud.dba.multidb;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class DataSourceAspect {

    @Before("@annotation(ds)")
    public void beforeDataSource(DataSource ds) {
        DataSourceType value = ds.value();
        DataSourceContextHolder.setDataSourceType(value);
        log.info("当前使用的数据源为：{}", value);
    }

    @After("@annotation(ds)")
    public void afterDataSource(DataSource ds) {
        DataSourceContextHolder.removeDatabaseType();
    }
}
