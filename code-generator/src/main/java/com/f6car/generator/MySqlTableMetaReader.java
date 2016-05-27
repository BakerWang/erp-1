package com.f6car.generator;


import com.google.common.base.CaseFormat;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by qixiaobo on 16/5/19.
 */
@Component
public class MySqlTableMetaReader implements TableMetaReader {

    @Value("${generator.prefix.del}")
    private boolean deletePrefix = true;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<TableInfo> readAllTable() {
        List<String> tables=new LinkedList<String>();
        try {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            DatabaseMetaData meta = con.getMetaData();
            ResultSet res = meta.getTables(null,null,"%",new String[]{"TABLE"});
            while (res.next()) {
                String db = res.getString("TABLE_NAME");
                tables.add(db);
            }
            res.close();
            con.close();
        }catch (Exception ex){

        }
        return Lists.transform(tables, new Function<String, TableInfo>() {
            public TableInfo apply(String input) {
                return readTableMetaData(input);
            }
        });
    }

    public TableInfo readTableMetaData(final String tableName) {
        final TableInfo tableInfo = new TableInfo();
        List<RowInfo> rows = jdbcTemplate.query("DESC " + tableName, new RowMapper<RowInfo>() {
            public RowInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
                RowInfo rowInfo = new RowInfo();
                rowInfo.setRowName(rs.getString("Field"));
                String oriType=rs.getString("Type");
                rowInfo.setType(oriType.split("\\(")[0]);
//                rowInfo.setLength(oriType.equals(rowInfo.getType())?0:Integer.parseInt(oriType.split("\\(")[1].split("\\)")[0])); //n-m
                rowInfo.setJavaType(ConvertType.getJavaType(rowInfo.getType()));
                boolean isPk = "PRI".equals(rs.getString("Key"));
                if(isPk){
                    tableInfo.setPkName(rowInfo.getRowName());
                    tableInfo.setPkType(rowInfo.getType());
                    tableInfo.setPkJavaType(rowInfo.getJavaType());
                    tableInfo.setPkAutoIncrment("auto_increment".equals(rs.getString("Extra")));
                }
                rowInfo.setJavaName(isPk ? "id" : CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, rowInfo.getRowName().toLowerCase()));


                if(rowInfo.getJavaName().equals("version")){
                    tableInfo.setVersion(true);
                }
                return rowInfo;
            }
        });

        tableInfo.setTableName(tableName);
        tableInfo.setRows(rows);
        String oriName = deletePrefix ? tableName.split("_", 2)[1] : tableName;
        tableInfo.setClazzName(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, oriName.toLowerCase()));
        return tableInfo;
    }
}
