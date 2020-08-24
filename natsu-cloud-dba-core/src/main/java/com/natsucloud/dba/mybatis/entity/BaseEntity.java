package com.natsucloud.dba.mybatis.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import java.io.Serializable;

@Data
public abstract class BaseEntity implements Serializable {

    @TableField(value = "id")
    public Long id ;
}
