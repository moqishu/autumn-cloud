package com.natsucloud.common.multidb;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
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
