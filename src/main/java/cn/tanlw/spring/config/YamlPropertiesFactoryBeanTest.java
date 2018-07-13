package cn.tanlw.spring.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.InputStreamResource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @create 2018/7/10
 */
public class YamlPropertiesFactoryBeanTest {
    public static void main(String[] args) {

        String input = "a.b.c:aa";
        String input2 = "noa:\n" +
                "  govern:\n" +
                "    host: 127.1.1.1\n" +
                "    port: 3306";

        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new InputStreamResource(new ByteArrayInputStream(input2.getBytes())));//File引入
        Properties properties = yaml.getObject();
        System.out.println(properties.get("a.b.c"));
//        Properties properties = new Properties();
//        try {
//            properties.load(new ByteArrayInputStream(input.getBytes()));
//            properties.load(new ByteArrayInputStream(input2.getBytes()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        System.out.println(properties.get("a.b.c"));
    }
}
