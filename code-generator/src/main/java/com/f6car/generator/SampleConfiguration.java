package com.f6car.generator;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * Created by qixiaobo on 16/5/20.
 */
@ConfigurationProperties(prefix = "sample")
public class SampleConfiguration {

    private String so;
    private String vo;
    private String model;
    private String mapper;
    private String controller;
    private String rep;
    private String service;
    private String serviceImpl;

    private String filePath;

    private List<String> excludeVo;

    private List<String> excludePo;

    private List<String> excludeSo;

    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so;
    }

    public String getVo() {
        return vo;
    }

    public void setVo(String vo) {
        this.vo = vo;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMapper() {
        return mapper;
    }

    public void setMapper(String mapper) {
        this.mapper = mapper;
    }

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller;
    }

    public String getRep() {
        return rep;
    }

    public void setRep(String rep) {
        this.rep = rep;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getServiceImpl() {
        return serviceImpl;
    }

    public void setServiceImpl(String serviceImpl) {
        this.serviceImpl = serviceImpl;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public List<String> getExcludeVo() {
        return excludeVo;
    }

    public void setExcludeVo(List<String> excludeVo) {
        this.excludeVo = excludeVo;
    }

    public List<String> getExcludePo() {
        return excludePo;
    }

    public void setExcludePo(List<String> excludePo) {
        this.excludePo = excludePo;
    }

    public List<String> getExcludeSo() {
        return excludeSo;
    }

    public void setExcludeSo(List<String> excludeSo) {
        this.excludeSo = excludeSo;
    }
}
