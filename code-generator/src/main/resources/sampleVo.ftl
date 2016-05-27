package com.f6car.biz<#if second?if_exists>.${subPackage}</#if>.vo;

import com.f6car.common.query.BaseVo;


public class ${table.clazzName}Vo extends BaseVo {
    private static final long serialVersionUID = -1L;

    <#list table.rows as row>
        <#if !excludeVo?seq_contains(row.javaName)>
    private ${row.javaType} ${row.javaName};

        </#if>
    </#list>



    <#list table.rows as row>
        <#if !excludeVo?seq_contains(row.javaName)>
    public void set${row.javaName?cap_first}(${row.javaType} ${row.javaName}){
    this.${row.javaName} = ${row.javaName};
    };

    public ${row.javaType} get${row.javaName?cap_first}(){
    return this.${row.javaName};
    };

        </#if>
    </#list>

}
