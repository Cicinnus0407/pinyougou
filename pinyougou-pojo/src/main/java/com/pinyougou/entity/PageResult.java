package com.pinyougou.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 分页包装体
 *
 * @author cicinnus
 * @date 2018/6/28
 */
public class PageResult<T> implements Serializable {
    private long total;
    private List<T> rows;

    public static <T> PageResult<T> success(long total, List<T> rows) {
        return new PageResult<T>(total, rows);
    }

    public PageResult(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
