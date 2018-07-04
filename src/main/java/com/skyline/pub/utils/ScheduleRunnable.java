package com.skyline.pub.utils;

import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/**
 * 执行定时任务
 * https://www.cnblogs.com/jurendage/p/9153835.html -- Java开源生鲜电商平台-定时器,定时任务quartz的设计与架构(源码可下载）
 * @author Administrator
 *
 */
public class ScheduleRunnable implements Callable {
    private Object target;
    private Method method;
    private String params;

    public ScheduleRunnable(String beanName, String methodName, String params)
            throws NoSuchMethodException, SecurityException {
        this.target = SpringContextUtil.getBean(beanName);
        this.params = params;

        if (!StringUtils.isEmpty(params)) {
            this.method = target.getClass().getDeclaredMethod(methodName, String.class);
        } else {
            this.method = target.getClass().getDeclaredMethod(methodName);
        }
    }

    /**
     * java捕获线程异常 -- https://blog.csdn.net/liuxiao723846/article/details/51902636
     * @return
     * @throws Exception
     */
    @Override
    public Object call() throws Exception {
        ReflectionUtils.makeAccessible(method);
        if (!StringUtils.isEmpty(params)) {
            method.invoke(target, params);
        } else {
            method.invoke(target);
        }
        return "OK";
    }
}
