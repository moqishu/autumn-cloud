package com.natsucloud.common.configuration;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

/**
 * @author moqishu
 * @deprecated MybatisPlus配置类
 * */
@Configurable
public class MyBatisPlusConfig {

    /**
     * 分页插件
     * */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
