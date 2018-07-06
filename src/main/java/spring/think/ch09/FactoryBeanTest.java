package spring.think.ch09;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 9.3.1 sqlSessionFactory创建
 * @create 2018/7/6
 */
@Component("factoryBeanTest")
public class FactoryBeanTest implements FactoryBean {

    private String a;
    private int b;

    public FactoryBeanTest() {
    }

    public FactoryBeanTest(String a, int b) {
        this.a = a;
        this.b = b;
    }

    /**
     * 实现此接口的bean，通过getBean方法获取bean时，其实是获取此类的getObject方法作为突破点
     * @return
     * @throws Exception
     */
    @Override
    public Object getObject() throws Exception {
        return new FactoryBeanTest("a",1);
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }


    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext("spring.think");
        FactoryBeanTest factoryBeanTest = (FactoryBeanTest) configApplicationContext.getBean("factoryBeanTest");
        /**
         * 继承FactoryBean:a - 1
         */
        System.out.println("继承FactoryBean:" + factoryBeanTest.a + " - " + factoryBeanTest.b);
        FactoryBeanTest factoryBeanTest1 = new FactoryBeanTest();
        /**
         * 独立new的Bean:null - 0
         */
        System.out.println("独立new的Bean:" + factoryBeanTest1.a + " - " + factoryBeanTest1.b);
    }
}
