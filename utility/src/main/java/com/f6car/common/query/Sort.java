package com.f6car.common.query;

import java.io.Serializable;

public class Sort implements Serializable {

    private static final long serialVersionUID = 7739709965769082011L;

    private String sortKey;

    private String sortDir;

    public Sort() {

    }

    public Sort(String sortKey, String sortDir) {
        this.sortKey = sortKey;
        this.sortDir = sortDir;
    }

    public Sort(String sortKey) {
        this.sortKey = sortKey;
    }

    public String getSortKey() {
        return sortKey;
    }

    public void setSortKey(String sortKey) {
        this.sortKey = sortKey;
    }

    public String getSortDir() {
        return sortDir;
    }

    public void setSortDir(String sortDir) {
        this.sortDir = sortDir;
    }

    public static Sort valueOf(String sortKey) {
        return new Sort(sortKey);
    }

    public static Sort valueOf(String sortKey, String sortDir) {
        return new Sort(sortKey, sortDir);
    }
}
