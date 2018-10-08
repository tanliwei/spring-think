package spring.think.ch06.applicationEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Creator Tan Liwei
 * @Date 2018/10/4 21:41
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ch06/applicationEvent.xml");

        TestEvent event = new TestEvent("hello", "msg");
        /**
         * Console:
         * msg
         */
        context.publishEvent(event);
    }
}
