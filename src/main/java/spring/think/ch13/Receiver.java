package spring.think.ch13;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @create 2018/8/15
 */
public class Receiver {
    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        Connection connection = connectionFactory.createConnection();
        connection.start();

        final Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(Sender.QUEUE_NAME);

        MessageConsumer consumer = session.createConsumer(destination);

        int i =0;
        while (i < 3){
            i++;
            TextMessage message = (TextMessage) consumer.receive();
            session.commit();
            System.out.println("收到消息: " + message.getText());
        }
        session.close();
        connection.close();
    }
}
