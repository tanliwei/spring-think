package com.skyline.pub.utils;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @create 2018/7/2
 */
@Component("springContextUtilTest")
public class SpringContextUtilTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("com.skyline");
        SpringContextUtilTest springContextUtilTest = (SpringContextUtilTest) context.getBean("springContextUtilTest");
        SpringContextUtilTest springContextUtilTest2 = (SpringContextUtilTest) SpringContextUtil.getBean("springContextUtilTest");
        System.out.println(springContextUtilTest == springContextUtilTest2);


    }

    private void doTask(Integer a){
        System.out.println(a * a );
    }
}
