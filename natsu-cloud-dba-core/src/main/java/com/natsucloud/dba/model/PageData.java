package com.natsucloud.dba.model;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "分页模型")
public class PageData<T> {

    public PageData(IPage page){
        this.total = page.getTotal();
        this.data = page.getRecords();
        this.currentPage = page.getCurrent();
        this.pageSize = page.getSize();
    }

    @ApiModelProperty("总行数")
    protected long total = 0;

    @ApiModelProperty("当前页数,首页为1")
    protected long currentPage = 1;

    @ApiModelProperty("每页显示多少条")
    protected long pageSize = 10;

    @ApiModelProperty("实体数据")
    protected List<T> data;



}
