package com.natsucloud.common.mybatis.model;

import com.baomidou.mybatisplus.annotation.TableField;
import org.springframework.context.annotation.Bean;

public class BaseEntity {

    @TableField(value = "id")
    public long id ;

}
