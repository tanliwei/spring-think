package spring.think.ch05.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * @Creator Tan Liwei
 * @Date 2018/10/3 18:06
 */
public class Test implements BeanFactoryAware {
    private BeanFactory beanfactory;

    //声明bean的时候 Spring 会自动注入 beanFactory
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanfactory = beanFactory;
    }

    public void testAware(){
        //通过hello这个bean id从beanFactory获取实例
        Hello hello = (Hello) beanfactory.getBean("hello");
        hello.say();
    }
}
