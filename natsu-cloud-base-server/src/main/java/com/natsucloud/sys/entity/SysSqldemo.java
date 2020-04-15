package com.natsucloud.sys.entity;

import com.natsucloud.common.mybatis.entity.BaseEntity;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author moqishu
 * @since 2020-04-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SysSqldemo对象", description="")
public class SysSqldemo extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "日期")
    @TableField("inDate")
    @JSONField(format="yyyy-MM-dd")
    private LocalDate inDate;

    @ApiModelProperty(value = "创建时间")
    @TableField("createTime")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;


}
