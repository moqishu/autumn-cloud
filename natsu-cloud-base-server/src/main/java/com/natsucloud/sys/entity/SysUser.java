package com.natsucloud.sys.entity;

import com.natsucloud.common.mybatis.entity.BaseEntity;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * @author moqishu
 * @since 2020-04-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SysUser对象", description="")
public class SysUser extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "上次登录时间")
    @TableField("lastLoginTime")
    private LocalDateTime lastLoginTime;

    @ApiModelProperty(value = "是否管理员")
    @TableField("isAdmin")
    private Boolean isAdmin;

    @ApiModelProperty(value = "账号状态 0 使用 1 注销")
    private Integer status;

    @ApiModelProperty(value = "账号是否锁定，1：锁定，0未锁定")
    @TableField("isLocked")
    private Boolean isLocked;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "创建时间")
    @TableField("createTime")
    private LocalDateTime createTime;


}
