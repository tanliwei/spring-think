package spring.think.ch09;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Spring点滴十一：Spring中BeanFactoryPostProcessor和BeanPostProcessor区别
 * https://www.cnblogs.com/sishang/p/6588542.html
 *
 * @create 2018/7/17
 */
@Component("beanFactoryPostProcessorTest")
public class BeanFactoryPostProcessorTest implements BeanFactoryPostProcessor {

    private String name="张三";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("******调用了BeanFactoryPostProcessor");
        String[] beanStr = configurableListableBeanFactory
                .getBeanDefinitionNames();
        for (String beanName : beanStr) {
            if ("beanFactoryPostProcessorTest".equals(beanName)) {
                BeanDefinition beanDefinition = configurableListableBeanFactory
                        .getBeanDefinition(beanName);
                MutablePropertyValues m = beanDefinition.getPropertyValues();
                if (m.contains("name")) {
                    m.addPropertyValue("name", "赵四");
                    System.out.println("》》》修改了name属性初始值了");
                }
            }
        }
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext("spring.think");
        BeanFactoryPostProcessorTest tester = (BeanFactoryPostProcessorTest) configApplicationContext.getBean("beanFactoryPostProcessorTest");
        System.out.println(tester.getName());
    }
}
