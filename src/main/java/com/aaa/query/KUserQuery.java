package com.aaa.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @program: springboot
 * @description
 * @author: lc
 * @create: 2020-11-25 23:07
 **/
@ApiModel(value = "用户查询对象")
public class KUserQuery {
    @ApiModelProperty(value = "当前页码",example = "1")
    private Integer pageNum = 1; // 当前页
    @ApiModelProperty(value = "每页显示的数量",example = "10")
    private Integer pageSize = 10; //
    @ApiModelProperty(value = "查询条件：用户名")
    private String kname; // 查询条件：用户名
    public String getKname() {
        return kname;
    }

    public void setKname(String kname) {
        this.kname = kname;
    }
    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }


}
