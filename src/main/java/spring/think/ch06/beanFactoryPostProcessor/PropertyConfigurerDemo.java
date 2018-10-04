package spring.think.ch06.beanFactoryPostProcessor;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @Creator Tan Liwei
 * @Date 2018/10/4 15:51
 */
public class PropertyConfigurerDemo {
    public static void main(String[] args) {
        ConfigurableListableBeanFactory bf = new XmlBeanFactory(new ClassPathResource("ch06/BeanFactory.xml"));

        BeanFactoryPostProcessor bfpp = (BeanFactoryPostProcessor) bf.getBean("bfpp");
        bfpp.postProcessBeanFactory(bf);
        /**
         * Console:
         * SimplePostProcessor{connectionString='*****', password='imaginecup', username='*****'}
         */
        System.out.println(bf.getBean("simpleBean"));
    }
}
