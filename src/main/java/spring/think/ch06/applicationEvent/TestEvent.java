package spring.think.ch06.applicationEvent;

import org.springframework.context.ApplicationEvent;

/**
 * @Creator Tan Liwei
 * @Date 2018/10/4 21:38
 */
public class TestEvent extends ApplicationEvent {
    public String msg;
    public TestEvent(Object source) {
        super(source);
    }
    public TestEvent(Object source, String msg){
        super(source);
        this.msg = msg;
    }
    public void print(){
        System.out.println(msg);
    }
}
