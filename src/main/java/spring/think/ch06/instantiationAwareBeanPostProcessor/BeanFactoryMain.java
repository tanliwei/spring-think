package spring.think.ch06.instantiationAwareBeanPostProcessor;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import spring.think.ch06.initPropertySources.User;

/**
 * @Creator Tan Liwei
 * @Date 2018/10/4 18:01
 */
public class BeanFactoryMain {
    public static void main(String[] args) {

        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("ch06/instantiationAwareBeanPostProcessor.xml"));
        User user = (User) bf.getBean("testBean");
        /**
         * Console:
         */
    }
}
