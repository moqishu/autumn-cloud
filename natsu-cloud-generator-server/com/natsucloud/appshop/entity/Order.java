package com.natsucloud.appshop.entity;

import com.natsucloud.common.mybatis.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author moQiShu
 * @since 2020-04-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("appshop_order")
@ApiModel(value="Order对象", description="")
public class Order extends BaseEntity {

private static final long serialVersionUID=1L;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String orderId;

    private String orderDesc;


}
