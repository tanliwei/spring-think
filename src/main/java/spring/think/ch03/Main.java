package spring.think.ch03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext bf =
                new ClassPathXmlApplicationContext("ch03/replaceMethodTest.xml");
        TestChangeMethod test = (TestChangeMethod) bf.getBean("testChangeMethod");
        /**
         * Console:
         * 我替换了原有的方法
         */
        test.changeMe();
    }
}
