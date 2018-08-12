package spring.think.ch12.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ch12/remote/RMIClient.xml");
        HelloRMIService hrs = context.getBean("myClient", HelloRMIService.class);
        System.out.println(hrs.add(1 ,2));
    }
}
