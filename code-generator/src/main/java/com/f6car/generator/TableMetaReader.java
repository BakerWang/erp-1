package com.f6car.generator;



import java.util.List;

/**
 * Created by qixiaobo on 16/5/19.
 */
public interface TableMetaReader {

    List<TableInfo> readAllTable();

    TableInfo readTableMetaData(String tableName);
}
