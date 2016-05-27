package com.f6car.controller<#if second?if_exists>.${subPackage}</#if>;

import com.f6car.biz<#if second?if_exists>.${subPackage}</#if>.vo.${table.clazzName}Vo;
import com.f6car.biz<#if second?if_exists>.${subPackage}</#if>.so.${table.clazzName}So;
import com.f6car.service<#if second?if_exists>.${subPackage}</#if>.${table.clazzName}Service;
import com.f6car.controller.order.base.BaseController;
import com.f6car.mapper<#if second?if_exists>.${subPackage}</#if>.${table.clazzName}Repository;
import com.f6car.model<#if second?if_exists>.${subPackage}</#if>.${table.clazzName};
import com.f6car.service<#if second?if_exists>.${subPackage}</#if>.${table.clazzName}Service;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/${table.clazzName?uncap_first}s")
public class ${table.clazzName}Controller extends BaseController<${table.pkJavaType},${table.clazzName}Vo,${table.clazzName}So,${table.clazzName},${table.clazzName}Repository,${table.clazzName}Service>{


}