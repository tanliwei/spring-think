package com.newnoa.framework.annotation.x;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @create 2018/7/23
 */
@Service("myTest2")
public class MyTest2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext
                configApplicationContext = new AnnotationConfigApplicationContext("com.newnoa");
        MyTest2 t2 = (MyTest2) configApplicationContext.getBean("myTest2");
        t2.test();
        t2.test2();
    }

    @DoubleClick
    public void test(){
        System.out.println("come in.");
    }
    @DoubleClick(timeout = 5)
    public void test2(){
        System.out.println("come in.");
    }
}
