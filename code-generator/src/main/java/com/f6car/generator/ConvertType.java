package com.f6car.generator;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by qixiaobo on 16/5/20.
 */
public class ConvertType {
    private static final Map<String, String> TYPE_MAPPING = new HashMap<String, String>();

    static {
        TYPE_MAPPING.put("VARCHAR", "String");
        TYPE_MAPPING.put("CHAR", "String");
        TYPE_MAPPING.put("VARCHAR", "String");

        TYPE_MAPPING.put("TIMESTAMP", "java.sql.Timestamp");
        TYPE_MAPPING.put("DATETIME", "java.sql.Timestamp");
        TYPE_MAPPING.put("DATE", "java.sql.Date");
        TYPE_MAPPING.put("TIME", "java.sql.Time");

        TYPE_MAPPING.put("BYTE", "Byte");
        TYPE_MAPPING.put("SHORT", "Short");
        TYPE_MAPPING.put("SHORT INTEGER", "Short");
        TYPE_MAPPING.put("INT", "Integer");
        TYPE_MAPPING.put("INTEGER", "Integer");
        TYPE_MAPPING.put("BIGINT", "Long");
        TYPE_MAPPING.put("LONG INTEGER", "Long");
        TYPE_MAPPING.put("FLOAT", "Float");
        TYPE_MAPPING.put("DOUBLE", "DOUBLE");
        TYPE_MAPPING.put("DECIMAL", "java.math.BigDecimal");


        TYPE_MAPPING.put("BLOB", "byte[]");


    }

    public static String getJavaType(String jdbcType) {

        String type = jdbcType.split("\\(")[0].toUpperCase();
        return TYPE_MAPPING.get(type);
    }
}
