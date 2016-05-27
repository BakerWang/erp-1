package com.f6car.model<#if second?if_exists>.${subPackage}</#if>;

import com.f6car.model.base.BaseModel;
import se.spagettikod.optimist.Identity;
<#if table.version??>
import se.spagettikod.optimist.OptimisticLocking;
</#if>

<#if table.version??>
@OptimisticLocking("${table.tableName}")
</#if>
public class ${table.clazzName} extends BaseModel{
    private static final long serialVersionUID = -1L;

    <#list table.rows as row>
        <#if !excludePo?seq_contains(row.javaName)>
            <#if row.javaName='id'>
    @Identity("${row.rowName}")
            </#if>
    private ${row.javaType} ${row.javaName};

        </#if>
    </#list>



    <#list table.rows as row>
        <#if !excludePo?seq_contains(row.javaName)>
    public void set${row.javaName?cap_first}(${row.javaType} ${row.javaName}){
        this.${row.javaName} = ${row.javaName};
    };

    public ${row.javaType} get${row.javaName?cap_first}(){
        return this.${row.javaName};
    };

        </#if>
    </#list>

}
