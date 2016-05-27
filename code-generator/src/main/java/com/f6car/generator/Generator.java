package com.f6car.generator;


import com.google.common.io.Files;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qixiaobo on 16/5/19.
 */
@SpringBootApplication
@EnableConfigurationProperties({SampleConfiguration.class})
public class Generator implements CommandLineRunner {

    @Autowired
    private TableMetaReader tableMetaReader;
    @Autowired
    private SampleConfiguration sampleConfiguration;
    @Autowired
    private Configuration freemarkerConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(Generator.class, args);
    }

    public void run(String... args) throws Exception {
        List<TableInfo> tables = tableMetaReader.readAllTable();
        for (TableInfo tableInfo : tables) {
            generateFiles(tableInfo);
            //TODO mapper && exclude filed
        }

    }

    private void generateFiles(TableInfo table) {
        Map<String, Object> data = getData(table);
        generateFile(table, data, sampleConfiguration.getController(), "Controller.java");
        generateFile(table, data, sampleConfiguration.getSo(), "So.java");
        generateFile(table, data, sampleConfiguration.getVo(), "Vo.java");
        generateFile(table, data, sampleConfiguration.getRep(), "Repository.java");
        generateFile(table, data, sampleConfiguration.getService(), "Service.java");
        generateFile(table, data, sampleConfiguration.getServiceImpl(), "ServiceImpl.java");
        generateFile(table, data, sampleConfiguration.getMapper(), "Mapper.xml");
        generateFile(table, data, sampleConfiguration.getModel(), ".java");
    }

    private Map<String, Object> getData(TableInfo table) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("table", table);
        /*boolean isSecondDir = table.getTableName().split("_").length > 2;//eg: t_order_detail
        String secondDir = isSecondDir ? table.getTableName().split("_")[1] : "";
        data.put("second",isSecondDir);*/
        String secondDir = table.getTableName().split("_")[1];
        data.put("second", true);
        data.put("subPackage", secondDir);
        data.put("excludeVo", sampleConfiguration.getExcludeVo());
        data.put("excludePo", sampleConfiguration.getExcludePo());
        data.put("excludeSo", sampleConfiguration.getExcludeSo());
        return data;
    }

    private void generateFile(TableInfo table, Map<String, Object> data, String templatePath, String fileSuffix) {
        try {
            /*boolean isSecondDir = table.getTableName().split("_").length > 2;//eg: t_order_detail
            String secondDir = isSecondDir ? table.getTableName().split("_")[1] : "";*/
            boolean isSecondDir = true;
            String secondDir = table.getTableName().split("_")[1];

            String path = sampleConfiguration.getFilePath() + File.separator + secondDir + File.separator + table.getClazzName() + fileSuffix;
            if (isSecondDir) {
                File dir = new File(sampleConfiguration.getFilePath() + File.separator + secondDir);
                if (!dir.exists()) {
                    dir.mkdir();
                }
            }
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            Writer writer = Files.newWriter(file, Charset.defaultCharset());

            Template controller = freemarkerConfiguration.getTemplate(templatePath);
            controller.process(data, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    @Bean
    public Configuration freemarkerConfiguration() {
        Configuration cfg = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        //设置FreeMarker的模版文件位置
        try {
            cfg.setDirectoryForTemplateLoading(new File(getClass().getClassLoader().getResource("").toURI()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return cfg;
    }
}
