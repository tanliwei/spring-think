package spring.think.ch05;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CircleDependencyMain {
    @Test
    public void test(){
        ApplicationContext bf =
                new ClassPathXmlApplicationContext("ch05/circleDependency.xml");
        bf.getBean("testA");

    }
}
