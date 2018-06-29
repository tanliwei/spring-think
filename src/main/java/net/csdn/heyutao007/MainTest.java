package net.csdn.heyutao007;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Import注解
 * https://blog.csdn.net/heyutao007/article/details/74994161
 * 在4.2之前只支持导入配置类
 * 在4.2，@Import注解支持导入普通的java类,并将其声明成一个bean
 * @create 2018/6/25
 */
public class MainTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("net.csdn");
        DemoService ds = context.getBean(DemoService.class);
        ds.doSomething();
    }
}
