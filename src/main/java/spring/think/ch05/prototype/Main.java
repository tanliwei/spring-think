package spring.think.ch05.prototype;

import org.junit.Test;
import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    @Test(expected = BeanCurrentlyInCreationException.class)
    public void testCircleBySetterAndPrototype() throws Throwable {
        try {
            /**
             * Spring容器不进行缓存"prototype"作用域的bean,因此无法提前暴露一个创建中的bean
             */
            ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ch05/testPrototype.xml");
            System.out.println(ctx.getBean("testA"));
        } catch (Exception e) {
            Throwable el = e.getCause().getCause().getCause();
            throw el;
        }
    }
}
