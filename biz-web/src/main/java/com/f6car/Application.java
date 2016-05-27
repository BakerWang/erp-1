package com.f6car;

import com.f6car.interceptor.SetDatasourceInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by qixiaobo on 16/5/17.
 */
@Configuration
@ComponentScan("com.f6car")
@EnableAutoConfiguration
public class Application extends WebMvcConfigurerAdapter {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SetDatasourceInterceptor())
                .addPathPatterns("/**");
    }

}