package spring.think.ch07.sec04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @create 2018/6/22
 */
public class TestMain {
    public static void main(String[] args) {
        ApplicationContext bf = new ClassPathXmlApplicationContext("ch07/aspectTest.xml");

    }
}
