package spring.think.ch06.customerEditorConfigurer;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Creator Tan Liwei
 * @Date 2018/10/4 9:13
 */
public class Main {
    @Test
    public void testDate(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ch06/beans.xml");
        UserManager userManager = (UserManager) ctx.getBean("userManager");
        /**
         * Console:
         * arg0:2013-03-15
         * dataValue:Fri Mar 15 00:00:00 CST 2013
         */
        System.out.println(userManager);
    }
}
