package spring.think.ch06.customerEditorConfigurer;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Creator Tan Liwei
 * @Date 2018/10/4 9:13
 */
public class Main2 {
    @Test
    public void testDate(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ch06/beans2.xml");
        UserManager userManager = (UserManager) ctx.getBean("userManager");
        /**
         * Console:
         * dataValue:Fri Mar 15 00:00:00 CST 2013
         */
        System.out.println(userManager);
    }
}
