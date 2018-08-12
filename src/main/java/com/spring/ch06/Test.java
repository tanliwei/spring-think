package com.spring.ch06;

import com.wugz.app.EventConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Test {
    public static void main(String[] args) {
        TestEvent event = new TestEvent("hello", "msg");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Test.class);
        context.publishEvent(event);
    }
}
