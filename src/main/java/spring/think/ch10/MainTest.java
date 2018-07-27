package spring.think.ch10;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @create 2018/7/19
 */
public class MainTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext =
                new AnnotationConfigApplicationContext("spring.think.ch10");
        InstantiationAwareBeanPostProcessorTest instance = configApplicationContext.getBean(InstantiationAwareBeanPostProcessorTest.class);
        instance = configApplicationContext.getBean(InstantiationAwareBeanPostProcessorTest.class);
        System.out.println(instance.getName());

    }
}
