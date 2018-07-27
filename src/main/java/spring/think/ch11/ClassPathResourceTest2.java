package spring.think.ch11;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * Spring之ClassPathResource加载资源文件
 * https://www.cnblogs.com/ruiati/p/6225093.html
 * @create 2018/7/27
 */
public class ClassPathResourceTest2 {

    @Test
    public void testResouce() {
        /**
         * Class.getResource("")获取的是相对于当前类的相对路径

         Class.getResource("／")获取的是classpath的根路径

         ClassLoader.getResource("")获取的是classpath的根路径
         */
        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        /**
         * /E:/Java/github_tlw/spring-think/out/production/classes/
         /E:/Java/github_tlw/spring-think/out/production/classes/spring/think/ch11/
         /E:/Java/github_tlw/spring-think/out/production/classes/
         E:\Java\github_tlw\spring-think
         */
        System.out.println(loader.getResource("").getPath());
        System.out.println(this.getClass().getResource("").getPath());
        System.out.println(this.getClass().getResource("/").getPath());
        System.out.println(System.getProperty("user.dir"));
    }
}
