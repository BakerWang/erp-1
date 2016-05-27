package com.f6car.mapper<#if second?if_exists>.${subPackage}</#if>;

import com.f6car.biz<#if second?if_exists>.${subPackage}</#if>.so.${table.clazzName}So;
import com.f6car.mapper.base.BaseRepository;
import com.f6car.model.<#if second?if_exists>.${subPackage}</#if>${table.clazzName};
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface ${table.clazzName}Repository extends BaseRepository<${table.clazzName},${table.clazzName}So,Long>{

}
