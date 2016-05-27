package com.f6car.generator;


import com.google.common.base.MoreObjects;

/**
 * Created by qixiaobo on 16/5/19.
 */
public class RowInfo {
    private String rowName;
    private String javaName;
    private String type;
    private String javaType;
    private int length;

    public String getRowName() {
        return rowName;
    }

    public void setRowName(String rowName) {
        this.rowName = rowName;
    }

    public String getJavaName() {
        return javaName;
    }

    public void setJavaName(String javaName) {
        this.javaName = javaName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("rowName", rowName)
                .add("javaName", javaName)
                .add("type", type)
                .add("javaType", javaType)
                .toString();
    }
}
