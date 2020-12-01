package com.aaa.vo;

/**
 * @program: springboot
 * @description
 * @author: lc
 * @create: 2020-11-25 17:24
 **/
public class Kuser {
    public Integer kno;
    public String  kname;
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
