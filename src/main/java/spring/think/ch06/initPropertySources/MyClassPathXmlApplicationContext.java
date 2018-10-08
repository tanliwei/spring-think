package spring.think.ch06.initPropertySources;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Creator Tan Liwei
 * @Date 2018/10/3 22:23
 */
public class MyClassPathXmlApplicationContext extends ClassPathXmlApplicationContext{
    public MyClassPathXmlApplicationContext(String... configLocations){
        super(configLocations);
    }

    protected void initPropertySources(){
        //添加验证要求
        getEnvironment().setRequiredProperties("VAR");
    }
}
