package cn.tanlw.spring.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @create 2018/7/10
 */
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = "cn.tanlw")
public class ApplicationConfigLoadFlow {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationConfigLoadFlow.class, args);
    }
}
