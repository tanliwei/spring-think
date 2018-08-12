package spring.think.ch12.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServerTest {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("ch12/remote/RMIServer.xml");
    }
}
