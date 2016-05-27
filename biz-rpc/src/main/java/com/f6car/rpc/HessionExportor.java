package com.f6car.rpc;

import com.f6car.service.base.BaseService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * Created by qixiaobo on 16/5/22.
 */
@Component
public class HessionExportor implements ApplicationContextAware {

    @Value("${hession.deployRoot}")
    private String hessionDeployPath;

    private ApplicationContext applicationContext;


    @PostConstruct
    public void init() {
        Map<String, BaseService> serviceBeanMap = applicationContext.getBeansOfType(BaseService.class);
        for (Map.Entry<String, BaseService> entry : serviceBeanMap.entrySet()) {
            BeanDefinitionBuilder exPorter = BeanDefinitionBuilder.genericBeanDefinition(HessianServiceExporter.class);
            exPorter.addPropertyValue("service", entry.getValue());
            exPorter.addPropertyValue("serviceInterface", entry.getValue().getClass().getInterfaces()[0]);
            exPorter.setLazyInit(true);
            getBeanDefinitionRegistry().registerBeanDefinition(hessionDeployPath + entry.getKey(), exPorter.getRawBeanDefinition());
        }


    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private BeanDefinitionRegistry getBeanDefinitionRegistry() {
        return (BeanDefinitionRegistry) ((ConfigurableApplicationContext)applicationContext).getBeanFactory();
    }
}
