package com.cnblogs.sishang;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * https://www.cnblogs.com/sishang/p/6588542.html
 * @create 2018/7/17
 */
public class BeanFactoryPostProcessorTest implements InitializingBean,DisposableBean,BeanNameAware,BeanFactoryAware {
    private String name;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public void setBeanFactory(BeanFactory paramBeanFactory)
            throws BeansException {
        System.out.println("》》》调用了BeanFactoryAware的setBeanFactory方法了");
    }

    @Override
    public void setBeanName(String paramString) {
        System.out.println("》》》调用了BeanNameAware的setBeanName方法了");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("》》》调用了DisposableBean的destroy方法了");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("》》》调用了Initailization的afterPropertiesSet方法了");
    }

    @Override
    public String toString() {
        return "BeanFactoryPostProcessorTest [name=" + name + ", sex=" + sex
                + "]";
    }
}