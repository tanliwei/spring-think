package spring.think.ch06.instantiationAwareBeanPostProcessor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.think.ch06.initPropertySources.User;

/**
 * @Creator Tan Liwei
 * @Date 2018/10/4 18:04
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("ch06/instantiationAwareBeanPostProcessor.xml");
        User user = (User) ctx.getBean("testBean");
        /**
         * Console:
         * ====
         */
    }
}
