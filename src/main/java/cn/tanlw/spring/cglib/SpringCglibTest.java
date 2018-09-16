package cn.tanlw.spring.cglib;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringCglibTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext
                = new AnnotationConfigApplicationContext("cn.tanlw.spring.cglib");
        Son son = (Son)configApplicationContext.getBean("son");

        System.out.println();
    }
}
