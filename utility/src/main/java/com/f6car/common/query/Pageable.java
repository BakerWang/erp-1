package com.f6car.common.query;

/**
 * Created by qixiaobo on 16/5/19.
 */
public interface Pageable {
    public int getCurrentPage();

    public int getPageSize();

    public void setCurrentPage(int currentPage);

    public void setPageSize(int pagesize);
}
