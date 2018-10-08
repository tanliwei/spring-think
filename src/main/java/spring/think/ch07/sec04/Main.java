package spring.think.ch07.sec04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TODO 7.4
 * @create 2018/6/22
 */
public class Main {
    public static void main(String[] args) {

        ApplicationContext bf = new ClassPathXmlApplicationContext("ch07/aspectTest4.xml");

    }
}
