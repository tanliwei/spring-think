package com.cnblogs.sishang;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring点滴十一：Spring中BeanFactoryPostProcessor和BeanPostProcessor区别
 * https://www.cnblogs.com/sishang/p/6588542.html
 * @create 2018/7/17
 */
public class T {
    ApplicationContext applicationcontext=null;
    @Before
    public void before() {
        System.out.println("》》》Spring ApplicationContext容器开始初始化了......");
        applicationcontext= new ClassPathXmlApplicationContext(new String[]{"spring-service.xml"});
        System.out.println("》》》Spring ApplicationContext容器初始化完毕了......");
    }
    @Test
    public void  test() {
        //BeanLifecycle beanLifecycle =applicationcontext.getBean("beanLifecycle",BeanLifecycle.class);
        BeanFactoryPostProcessorTest beanFactoryPostProcessorTest=applicationcontext.getBean(BeanFactoryPostProcessorTest.class);
        System.out.println(beanFactoryPostProcessorTest.toString());
        beanFactoryPostProcessorTest=applicationcontext.getBean(BeanFactoryPostProcessorTest.class);
        System.out.println(beanFactoryPostProcessorTest.toString());
    }
}
