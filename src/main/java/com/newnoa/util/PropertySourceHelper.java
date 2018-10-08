package com.newnoa.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.util.StringUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/**
 *
 * @author liwei.tan
 * @Date 2018/8/31 14:46
 */
@Slf4j
public class PropertySourceHelper {
    //classpath对应resources目录, file对应项目根路径
    private static final String DEFAULT_SEARCH_LOCATIONS = "classpath:/,classpath:/config/,file:./,file:./config/";
    private static final String DEFAULT_SEARCH_FILENAME = "application.properties,application.xml,application.yml,application.yaml";
    public static final String SPRING_PROFILES_ACTIVE = "spring.profiles.active";


    /**
     * 读取配置文件的spring.profiles.active属性
     * @return
     */
    public String getSpringProfileActive() {
        return getProperties().getProperty(SPRING_PROFILES_ACTIVE);
    }

    public Properties getProperties() {
        Properties properties = new Properties();
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource;
        String[] locations = StringUtils.commaDelimitedListToStringArray(DEFAULT_SEARCH_LOCATIONS);
        String[] filenames = StringUtils.commaDelimitedListToStringArray(DEFAULT_SEARCH_FILENAME);
        //组合路径和文件名 检查本地是否有配置文件
        //TODO spring.config.name 自定义了资源配置路径的情况
        for (String location : locations) {
            for (String filename : filenames) {
                resource = resourceLoader.getResource(location + filename);
                if (resource != null && resource.exists()) {
                    try {
                        loadResource(properties, resource, filename);
                        return properties;
                    } catch (IOException e) {
                        log.error("getURI IOException", e);
                    }
                }
            }
        }
        return properties;
    }

    private void loadResource(Properties properties, Resource resource, String filename) throws IOException {
        try {
            if ("application.properties".equals(filename) || "application.xml".equals(filename)) {
                properties.load(new FileInputStream(resource.getFile()));
            }
            if ("application.yml".equals(filename) || "application.yaml".equals(filename)) {
                YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
                yaml.setResources(resource);//File引入
                properties.putAll(yaml.getObject());
            }
        } catch (Exception e) {
            log.error("加载配置文件异常", e);
        }
    }
}
