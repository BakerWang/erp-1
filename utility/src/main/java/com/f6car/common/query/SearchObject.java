package com.f6car.common.query;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by qixiaobo on 16/5/19.
 */
public class SearchObject implements Pageable, Sortable, Serializable {
    private int currentPage;
    private int pageSize;
    private List<Sort> sorts = new LinkedList<Sort>();

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<Sort> getSorts() {
        return sorts;
    }

    public void setSorts(List<Sort> sorts) {
        this.sorts = sorts;
    }

    public void addSort(Sort sort) {
        sorts.add(sort);
    }
}
