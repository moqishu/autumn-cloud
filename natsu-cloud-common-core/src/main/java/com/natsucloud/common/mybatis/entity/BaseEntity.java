package com.natsucloud.common.mybatis.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import java.io.Serializable;

@Data
public abstract class BaseEntity implements Serializable {

    @TableField(value = "id")
    public long id ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
