package spring.think.ch07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Creator Tan Liwei
 * @Date 2018/10/5 10:16
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext bf =
                new ClassPathXmlApplicationContext("ch07/aspectTest.xml");
        TestBean bean = (TestBean) bf.getBean("test");
        bean.test();
    }
}
