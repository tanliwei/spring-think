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
        SpringContextUtilTest springContextUtilTest3 = (SpringContextUtilTest) SpringContextUtil.getBeanByClassName("com.skyline.pub.utils.SpringContextUtilTest");
         springContextUtilTest3 = (SpringContextUtilTest) SpringContextUtil.getBeanByClassName("com.skyline.pub.utils.SpringContextUtilTest");
         springContextUtilTest3 = (SpringContextUtilTest) SpringContextUtil.getBeanByClassName("com.skyline.pub.utils.SpringContextUtilTest");
         springContextUtilTest3 = (SpringContextUtilTest) SpringContextUtil.getBeanByClassName("com.skyline.pub.utils.SpringContextUtilTest");
        System.out.println(springContextUtilTest == springContextUtilTest2);
        System.out.println(springContextUtilTest == springContextUtilTest3);


    }

    private void doTask(Integer a){
        System.out.println(a * a );
    }
}
