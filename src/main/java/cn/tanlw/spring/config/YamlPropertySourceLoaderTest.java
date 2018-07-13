package cn.tanlw.spring.config;

import com.alibaba.fastjson.JSON;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ByteArrayResource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @create 2018/7/11
 */
public class YamlPropertySourceLoaderTest {
    public static void main(String[] args) {

        YamlPropertySourceLoader loader = new YamlPropertySourceLoader();
        String input = "a:\r\n  b: test\r\nc=b";

        /*try {
            List<PropertySource<?>> loaded = loader.load("test", new ByteArrayResource(input.getBytes()),null);
            System.out.println(JSON.toJSONString(sources.get(0).getSource()));
            System.out.println((Map)loaded.get(0).getSource());;
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
