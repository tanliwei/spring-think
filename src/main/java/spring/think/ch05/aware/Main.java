package spring.think.ch05.aware;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Creator Tan Liwei
 * @Date 2018/10/3 18:08
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ch05/applicationContext.xml");
        Test test = (Test) ctx.getBean("test");
        /**
         * Console:
         * hello
         */
        test.testAware();
    }
}
