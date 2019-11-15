package cn.liuhp.wheel.util;

import java.util.List;
/*
* 分页工具
* */
public class Pagination<T> {

    public static final int DEFAULT_PAGENO = 1;

    public static final int DEFAULT_PAGESIZE = 20;

    private int total; // 总共多少条

    private int pageSize = DEFAULT_PAGESIZE; // 每页多少条

    private int pageNo = DEFAULT_PAGENO; // 第几页，从1开始

    private List<T> data;

    public Pagination() {
    }

    public Pagination(List<T> data, int total) {
        this.total = total;
        this.data = data;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
}
