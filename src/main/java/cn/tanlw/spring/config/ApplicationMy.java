package cn.tanlw.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @create 2018/7/10
 */
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = "cn.tanlw")
public class ApplicationMy {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationMy.class, args);
    }

    @RestController
    public class example{

        @Autowired
        PropertyTest propertyTest;

        @Autowired
        Environment environment;

        @GetMapping("/get")
        public void get(){
            System.out.println("propertyTest.host:"+propertyTest.host);
            System.out.println("propertyTest.port:"+propertyTest.port);
            System.out.println("propertyTest.hostport:"+propertyTest.hostport);
            System.out.println("aaa:"+environment.getProperty("aaa"));
        }
    }
}
