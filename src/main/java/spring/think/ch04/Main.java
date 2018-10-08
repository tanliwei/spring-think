package spring.think.ch04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext bf =
                new ClassPathXmlApplicationContext("ch04/test.xml");
        User user = (User) bf.getBean("testbean");
        /**
         * Console:
         * aaa,bbb
         */
        System.out.println(user.getUserName()+","+user.getEmail());
    }
}
