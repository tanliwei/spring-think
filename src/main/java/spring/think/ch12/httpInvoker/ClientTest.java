package spring.think.ch12.httpInvoker;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @create 2018/8/13
 */
public class ClientTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ch12/httpInvoker/HttpInvoker-client.xml");
        HttpInvokerI httpInvokerI = (HttpInvokerI) context.getBean("remoteService");
        System.out.println(httpInvokerI.getTestPo(" Hello httpInvoker "));
    }
}
