package com.wugz.app;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/***
 *
 * @ClassName(类名)      : DemoListener
 * @Description(描述)    : 事件监听器
 *                     实现ApplicationListener并制定监听的事件类型
 * @author(作者)         ：吴桂镇
 * @date (开发日期)      ：2017年11月22日 下午3:35:37
 *
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

    /***
     * 对消息进行接受处理
     */
    @Override
    public void onApplicationEvent(DemoEvent event) {
        String msg = event.getMsg();
        System.out.println("demoListener接受到了demoPublisher发布的消息："+msg);
    }


}
