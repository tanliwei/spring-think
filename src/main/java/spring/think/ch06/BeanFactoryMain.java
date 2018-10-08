package spring.think.ch06;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @Creator Tan Liwei
 * @Date 2018/10/3 21:32
 */
public class BeanFactoryMain {
    public static void main(String[] args) {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("ch06/beanFactoryTest.xml"));
        Test test = (Test) bf.getBean("test");
        System.out.println(test);
    }
}
