package com.aaa.query;

/**
 * @program: springboot
 * @description
 * @author: lc
 * @create: 2020-11-25 23:07
 **/
public class KUserQuery {
    private Integer pageNum = 1; // 当前页
    private Integer pageSize = 10; // 每页显示的数量

    public String getKname() {
        return kname;
    }

    public void setKname(String kname) {
        this.kname = kname;
    }

    private String kname; // 查询条件：用户名

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
