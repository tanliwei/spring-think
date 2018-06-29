package com.newnoa.framework.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @create 2018/6/29
 */
@EnableAspectJAutoProxy
@Component("myTest")
public class MyTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.newnoa");
        MyTest myTest = (MyTest)context.getBean("myTest");
        myTest.test(1);
        myTest.test(1);
    }

    @RepeatSubmit
    public void test(Integer id){
        System.out.println("test...");
    }
}
