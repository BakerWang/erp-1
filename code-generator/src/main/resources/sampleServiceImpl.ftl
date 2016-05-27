package com.f6car.service<#if second?if_exists>.${subPackage}</#if>.impl;

import com.f6car.biz.<#if second?if_exists>.${subPackage}</#if>so.${table.clazzName}So;
import com.f6car.biz.<#if second?if_exists>.${subPackage}</#if>vo.${table.clazzName}Vo;
import com.f6car.mapper.<#if second?if_exists>.${subPackage}</#if>${table.clazzName}Repository;
import com.f6car.model.${table.clazzName};
import com.f6car.service.<#if second?if_exists>.${subPackage}</#if>${table.clazzName}Service;
import com.f6car.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;



@Service("${table.clazzName?uncap_first}Service")
public class ${table.clazzName}ServiceImpl extends BaseServiceImpl<${table.clazzName}Vo,${table.clazzName}So,${table.pkJavaType},${table.clazzName},${table.clazzName}Repository> implements ${table.clazzName}Service{


}
