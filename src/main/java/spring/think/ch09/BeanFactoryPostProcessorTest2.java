package spring.think.ch09;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Spring点滴十一：Spring中BeanFactoryPostProcessor和BeanPostProcessor区别
 * https://www.cnblogs.com/sishang/p/6588542.html
 *
 * @create 2018/7/17
 */
//@Component("beanFactoryPostProcessorTest")
public class BeanFactoryPostProcessorTest2 implements  BeanFactoryPostProcessor {

    private static ApplicationContext applicationcontext=null;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Before
    public void before() {
        System.out.println("》》》Spring ApplicationContext容器开始初始化了......");
        applicationcontext= new ClassPathXmlApplicationContext(new String[]{"ch09/spring.xml"});
        System.out.println("》》》Spring ApplicationContext容器初始化完毕了......");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("******调用了BeanFactoryPostProcessor");
        String[] beanStr = configurableListableBeanFactory
                .getBeanDefinitionNames();
        for (String beanName : beanStr) {
            //不能是 BeanFactoryPostProcessor 的实现类，
            //否则修改结果 在 getBean 时 失效！
            if ("userBean".equals(beanName)) {
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

    @Test
    public void  test() {
        //BeanLifecycle beanLifecycle =applicationcontext.getBean("beanLifecycle",BeanLifecycle.class);
        UserBean userBean=applicationcontext.getBean(UserBean.class);
        System.out.println(userBean.getName());
    }

}
