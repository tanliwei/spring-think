package spring.think.ch03.lookupMethod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext bf =
                new ClassPathXmlApplicationContext("ch03/lookupTest.xml");
        GetBeanTest getBeanTest = (GetBeanTest)bf.getBean("getBeanTest");
        getBeanTest.showMe();
    }
}
