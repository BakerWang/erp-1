package com.f6car.generator;


import com.google.common.base.MoreObjects;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by qixiaobo on 16/5/19.
 */
public class TableInfo {
    private String tableName;
    private String clazzName;
    private boolean version;
    private String pkName;
    private String pkType;
    private String pkJavaType;
    private boolean pkAutoIncrment;


    private List<RowInfo> rows=new LinkedList<RowInfo>();

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public List<RowInfo> getRows() {
        return rows;
    }

    public void setRows(List<RowInfo> rows) {
        this.rows = rows;
    }

    public void addRow(RowInfo row){
        this.rows.add(row);
    }

    public boolean isVersion() {
        return version;
    }

    public void setVersion(boolean version) {
        this.version = version;
    }

    public String getPkName() {
        return pkName;
    }

    public void setPkName(String pkName) {
        this.pkName = pkName;
    }

    public String getPkType() {
        return pkType;
    }

    public void setPkType(String pkType) {
        this.pkType = pkType;
    }

    public String getPkJavaType() {
        return pkJavaType;
    }

    public void setPkJavaType(String pkJavaType) {
        this.pkJavaType = pkJavaType;
    }

    public boolean isPkAutoIncrment() {
        return pkAutoIncrment;
    }

    public void setPkAutoIncrment(boolean pkAutoIncrment) {
        this.pkAutoIncrment = pkAutoIncrment;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("tableName", tableName)
                .add("clazzName", clazzName)
                .add("rows", rows)
                .toString();
    }
}
