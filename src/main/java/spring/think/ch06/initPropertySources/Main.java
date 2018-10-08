package spring.think.ch06.initPropertySources;


import org.springframework.context.ApplicationContext;

/**
 * @Creator Tan Liwei
 * @Date 2018/10/3 22:25
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext bf = new MyClassPathXmlApplicationContext("ch06/test.xml");
        /**
         * Console:
         * org.springframework.core.env.MissingRequiredPropertiesException:
         * The following properties were declared as required but could not be resolved: [VAR]
         */
        User user = (User) bf.getBean("testBean");
    }
}
