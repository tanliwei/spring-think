package spring.think.ch09;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 9.3.1 sqlSessionFactory创建
 * @create 2018/7/6
 */
@Component("initializingBeanTest")
public class InitializingBeanTest  implements InitializingBean {
    private String a;

    /**
     * 实现此接口的Bean会在初始化的时候调用afterPropertiesSet来进行bean的逻辑初始化
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
        a = "a";
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext("spring.think");

        InitializingBeanTest springBean =  configApplicationContext.getBean(InitializingBeanTest.class);
        /**
         * Spring管理的Bean:a
         */
        System.out.println("Spring管理的Bean:"+springBean.a);

        InitializingBeanTest newBean = new InitializingBeanTest();
        /**
         * 独立new出来的Bean:null
         */
        System.out.println("独立new出来的Bean:"+newBean.a);
    }
}
