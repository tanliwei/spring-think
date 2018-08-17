package spring.think.ch13;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @create 2018/8/15
 */
public class MyMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        TextMessage msg = (TextMessage) message;
        try {
            System.out.println("MyMessageListener:"+msg.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
