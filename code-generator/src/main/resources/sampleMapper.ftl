<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >

<mapper namespace="${table.clazzName}">
    <sql id="Table_Name">${table.tableName}</sql>
    <sql id="Base_Column_List">
        <#list table.rows as row>
            <#if row_index%8==0>

            </#if>${row.rowName}<#if row_has_next>,</#if></#list>
    </sql>

    <sql id="SO_Where_Clause">
        <!--
        <#list table.rows as row>
        <if test="${row.javaName} != null">
            AND o.${row.rowName}= ${r"#{"}${row.javaName}${r"}"}
        </if>
        </#list>
        -->
    </sql>

    <resultMap id="${table.clazzName}Map" type="com.f6car.model<#if second?if_exists>.${subPackage}</#if>.${table.clazzName}">
        <#list table.rows as row>
        <result column="${row.rowName}" jdbcType="${row.type}" property="${row.javaName}" />
        </#list>

    </resultMap>
    <resultMap id="${table.clazzName}VoMap" type="com.f6car.biz<#if second?if_exists>.${subPackage}</#if>.vo.${table.clazzName}Vo">
        <#list table.rows as row>
            <result column="${row.rowName}" jdbcType="${row.type}" property="${row.javaName}" />
        </#list>
    </resultMap>

    <select id="findById" resultMap="${table.clazzName}Map"
            parameterType="${table.pkJavaType}">
        select
        <include refid="${table.clazzName}.Base_Column_List"/>
        from
        <include refid="${table.clazzName}.Table_Name" />
        where ${table.pkName} = ${r"#{"}id,jdbcType=${table.pkType}${r"}"}
    </select>

    <delete id="deleteById"  parameterType="${table.pkJavaType}">
        delete from
        <include refid="${table.clazzName}.Table_Name" />
        where ${table.pkName} = ${r"#{"}id,jdbcType=${table.pkType}${r"}"}
    </delete>

    <select id="searchBySo" resultMap="${table.clazzName}Map" parameterType="com.f6car.biz<#if second?if_exists>.${subPackage}</#if>.so.${table.clazzName}So">
        select
        <include refid="${table.clazzName}.Base_Column_List"/>
        from
        <include refid="${table.clazzName}.Table_Name" />
        o
        where
        1=1
        <include refid="${table.clazzName}.SO_Where_Clause" />
    </select>

    <select id="countBySo" resultMap="Integer" parameterType="com.f6car.biz<#if second?if_exists>.${subPackage}</#if>.so.${table.clazzName}So">
        select
        count(${table.pkName})
        from
        <include refid="${table.clazzName}.Table_Name" />
        o
        where
        1=1
        <include refid="${table.clazzName}.SO_Where_Clause" />
    </select>

    <insert id="createReturnPo" parameterType="com.f6car.model<#if second?if_exists>.${subPackage}</#if>.${table.clazzName}"  <#if table.pkAutoIncrment>useGeneratedKeys="true" keyProperty="id"  keyColumn="${table.pkName}"</#if>>
        insert into
        <include refid="${table.clazzName}.Table_Name" /> (
        <#list table.rows as row>
            <!--${row_index}-->${row.rowName}<#if row_has_next>,</#if>
        </#list>
        )
        values (
        <#list table.rows as row>
            <!--${row_index}-->${r"#{"}${row.javaName}, jdbcType=${row.type}${r"}"}<#if row_has_next>,</#if>
        </#list>
        )
    </insert>


    <update id="updatePo" parameterType="com.f6car.model<#if second?if_exists>.${subPackage}</#if>.${table.clazzName}"  >
        update
        <include refid="${table.clazzName}.Table_Name" />
        set
    <#list table.rows as row>
        <!--${row_index}-->${row.rowName}=${r"#{"}${row.javaName}, jdbcType=${row.type}${r"}"}<#if row_has_next>,</#if>
    </#list>
        where ${table.pkName} = ${r"#{"}${table.pkName},jdbcType=${table.pkType}${r"}"}
    </update>

</mapper>
