package cn.tanlw.spring.config;

import org.junit.Test;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.InputStreamResource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @create 2018/7/10
 */
public class YamlPropertiesFactoryBeanTest2 {
    public static void main(String[] args) throws IOException {

        String input = "a.b.c=aa\na.b=cccc";

        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new InputStreamResource(new ByteArrayInputStream(input.getBytes())));//File引入
        Properties properties = yaml.getObject();
        System.out.println(properties.get("a.b.c"));

        Properties properties1 = new Properties();
        properties1.load(new ByteArrayInputStream(input.getBytes()));
        System.out.println(properties.get("a.b.c"));
    }


    @Test
    public void test(){
        String input = "spec:\n" +
                "  selector:\n" +
                "    k: noa\n" +
                "  ports:\n" +
                "    - name: web\n" +
                "      port: 8080\n" +
                "      targetPort: 8080\n" +
                "    - name: server\n" +
                "      port: 9191\n" +
                "      targetPort: 9191\n" +
                "---\n" +
                "api: ext\n" +
                "kind: Ingress";
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new InputStreamResource(new ByteArrayInputStream(input.getBytes())));//File引入
        Properties properties = yaml.getObject();
        /**
         * noa
         * web
         * server
         * ext
         */
        System.out.println(properties.get("spec.selector.k"));
        System.out.println(properties.get("spec.ports[0].name"));
        System.out.println(properties.get("spec.ports[1].name"));
        System.out.println(properties.get("api"));

    }
}
