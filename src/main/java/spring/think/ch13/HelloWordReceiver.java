package spring.think.ch13;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @create 2018/8/15
 */
public class HelloWordReceiver {
    public static void main(String[] args) throws JMSException {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("ch13/applicationContext.xml");
        JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsTemplate");
        Destination destination = (Destination) context.getBean("destination");

        TextMessage msg = (TextMessage) jmsTemplate.receive(destination);
        System.out.println("received msg is: " + msg.getText());
    }
}
