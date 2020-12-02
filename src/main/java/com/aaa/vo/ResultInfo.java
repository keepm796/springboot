package com.aaa.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @program: springboot
 * @description
 * @author: lc
 * @create: 2020-11-26 21:35
 **/
@ApiModel(value = "结果封装对象")
public class ResultInfo {
    @ApiModelProperty(value = "状态码",example = "200")
    private Integer code = 200;
    @ApiModelProperty(value = "提升信息")
    private String msg = "操作成功";
    //返回的结果集
    @ApiModelProperty(value = "返回对象")
    private Object result ;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
