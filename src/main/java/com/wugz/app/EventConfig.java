package com.wugz.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * https://blog.csdn.net/sinat_33625560/article/details/78605367
 */
@Configuration
@ComponentScan({"com.wugz.app"})
public class EventConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);
        DemoPublisher publisher = context.getBean(DemoPublisher.class);
        publisher.published();
        context.close();
    }
}
