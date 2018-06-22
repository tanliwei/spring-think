package com.wugz.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/***
 * Spring 的监听事件 ApplicationListener 和 ApplicationEvent 用法
 * @ClassName(类名)      : DemoPublisher
 * @Description(描述)    : 事件发布类
 * @author(作者)         ：吴桂镇
 * @date (开发日期)      ：2017年11月22日 下午3:41:13
 *
 */
@Component
public class DemoPublisher {

    @Autowired
    ApplicationContext context;

    public void published() {
        DemoEvent event = new DemoEvent(this, "发布成功！");
        System.out.println("发部event："+event);
        context.publishEvent(event);
    }
}
