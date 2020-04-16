package com.natsucloud.common.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "分页模型")
public class PageData<T> {

    @ApiModelProperty("总行数")
    protected int total = 0;

    @ApiModelProperty("当前页数,首页为1")
    protected int currentPage = 1;

    @ApiModelProperty("每页显示多少条")
    protected int pageSize = 10;

    @ApiModelProperty("实体数据")
    protected List<T> data;



}
