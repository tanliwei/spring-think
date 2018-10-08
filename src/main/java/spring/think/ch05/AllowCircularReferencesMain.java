package spring.think.ch05;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * CH 5.7.2
 */
public class AllowCircularReferencesMain {

    @Test
    public void test(){
        ClassPathXmlApplicationContext bf =
                new ClassPathXmlApplicationContext("ch05/circleDependency.xml");
        /**
         * ClassPathXmlApplicationContext 已经加载完成，
         * 再硬编码设置 allowCircularReferences 属性，无用。
         */
        bf.setAllowCircularReferences(false);
        bf.getBean("testA");

    }
}
