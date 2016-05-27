package com.f6car.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 晓波 on 2016/5/8 0008.
 */
@Configuration
public class JsonConfig {
    @Bean
    public FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
        return new FastJsonHttpMessageConverter();
    }

    @Bean
    @Autowired
    public HttpMessageConverters convertersToBeUsed(FastJsonHttpMessageConverter converter) {
        return new HttpMessageConverters(converter);
    }
}
