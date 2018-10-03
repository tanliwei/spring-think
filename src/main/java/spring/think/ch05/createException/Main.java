package spring.think.ch05.createException;

import org.junit.Test;
import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    @Test(expected = BeanCurrentlyInCreationException.class)
    public void testCircleByConstructor() throws Throwable{
        try {
            new ClassPathXmlApplicationContext("ch05/test.xml");
        } catch (Exception e) {
            Throwable el = e.getCause().getCause().getCause();
            throw el;
        }

    }
}
