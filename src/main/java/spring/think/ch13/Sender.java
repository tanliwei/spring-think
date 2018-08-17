package spring.think.ch13;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
/**
 * compile('org.apache.activemq:activemq-core:5.7.0')
 * ActivateMQ DOWNLOAD: http://activemq.apache.org/activemq-5155-release.html
 * Activate Admin: http://localhost:8161/admin/  user:admin pwd:admin
 *
 * springframework中的 @ImportResource 和 compile('org.apache.activemq:activemq-all:5.14.0') 中的 @ImportResource 重复定义
 * 改用     compile('org.apache.activemq:activemq-core:5.7.0')
 *
 * @create 2018/8/15
 */
public class Sender {

    public static final String QUEUE_NAME = "my-queue";

    public static void main(String[] args) throws JMSException, InterruptedException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();

        Connection connection = connectionFactory.createConnection();

        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(QUEUE_NAME);

        MessageProducer producer = session.createProducer(destination);
        TextMessage message;
        for (int i = 0; i < 3; i++) {
            message = session.createTextMessage("大家好这是个测试" + i);
            Thread.sleep(1000);
            //
            producer.send(message);
        }
        session.commit();
        session.close();
        connection.close();
    }
}
