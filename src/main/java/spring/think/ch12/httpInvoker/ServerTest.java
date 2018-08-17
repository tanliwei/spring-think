package spring.think.ch12.httpInvoker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * springframework中的 @ImportResource 和 compile('org.apache.activemq:activemq-all:5.14.0') 中的 @ImportResource 重复定义
 * 改用     compile('org.apache.activemq:activemq-core:5.7.0')
 */
@ImportResource(locations = "classpath:ch12/httpInvoker/HttpInvoker-server.xml")
@SpringBootApplication(scanBasePackages = "spring.think.ch12")
public class ServerTest {
    public static void main(String[] args) {
        SpringApplication.run(ServerTest.class, args);
//        new ClassPathXmlApplicationContext("");
    }
}
