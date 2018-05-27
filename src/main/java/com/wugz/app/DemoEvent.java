package com.wugz.app;

import org.springframework.context.ApplicationEvent;

/***
 *
 * @ClassName(类名)      : DemoEvent(自定义事件)
 * @Description(描述)    : spring的event为bean和bean之间的消息通信提供了支持，可以用一个bean监听当前的bean所发送的事件
 * @author(作者)         ：吴桂镇
 * @date (开发日期)      ：2017年11月22日 下午3:30:04
 *
 */
public class DemoEvent extends ApplicationEvent {

    private static final long serialVersionUID = 1L;

    private String msg;

    public void sysLog() {
        System.out.println(msg);
    }

    public DemoEvent(Object source,String msg) {
        super(source);
        this.setMsg(msg);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
