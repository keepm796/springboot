package com.aaa.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @program: springboot
 * @description
 * @author: lc
 * @create: 2020-11-25 17:24
 **/
@ApiModel(value = "用户实体类")
public class Kuser {
    @ApiModelProperty(name = "kno",value = "用户id",example = "0")
    public Integer kno;
    @ApiModelProperty(name = "kname",value = "用户名")
    public String  kname;
    @ApiModelProperty(name = "kpassword",value = "密码")
    public String kpassword;

    public Integer getKno() {
        return kno;
    }

    public void setKno(Integer kno) {
        this.kno = kno;
    }

    public String getKname() {
        return kname;
    }

    public void setKname(String kname) {
        this.kname = kname;
    }

    public String getKpassword() {
        return kpassword;
    }

    public void setKpassword(String kpassword) {
        this.kpassword = kpassword;
    }
}
