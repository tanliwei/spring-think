package spring.think.ch11;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * @create 2018/7/27
 */
public class ClassPathResourceTest {
    private static final String DEFAULT_STRATEGIES_PATH = "ContextLoader.properties";


    private static final Properties defaultStrategies;

    static {
        // Load default strategy implementations from properties file.
        // This is currently strictly internal and not meant to be customized
        // by application developers.
        try {
            ClassPathResource resource = new ClassPathResource(DEFAULT_STRATEGIES_PATH, ClassPathResourceTest.class);
            defaultStrategies = PropertiesLoaderUtils.loadProperties(resource);
        }
        catch (IOException ex) {
            throw new IllegalStateException("Could not load 'ContextLoader.properties': " + ex.getMessage());
        }
    }

    /**
     * ContextLoader.properties 文件手动复制到 out 目录下对应 .class 文件目录
     */
    @Test
    public void loadProperties(){

        System.out.println(defaultStrategies.getProperty("contextLoader"));
    }

}
