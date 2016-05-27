package com.f6car.datasource;

/**
 * 数据源操作
 * @author linhy
 */
public class DataSourceHolder {
    //线程本地环境
    private static final ThreadLocal<String> dataSources = new ThreadLocal<String>();
    //设置数据源
    public static void setDataSource(String datasourceId) {
        dataSources.set(datasourceId);
    }
    //获取数据源
    public static String getDataSource() {
        return (String) dataSources.get();
    }
    //清除数据源
    public static void clearDataSource() {
        dataSources.remove();
    }
 
}