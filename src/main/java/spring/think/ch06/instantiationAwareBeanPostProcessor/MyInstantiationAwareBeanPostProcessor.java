package spring.think.ch06.instantiationAwareBeanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

/**
 * 6.6.2
 * @Creator Tan Liwei
 * @Date 2018/10/4 17:58
 */
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("====");
        return null;
    }
}
