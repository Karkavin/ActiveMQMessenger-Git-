package com.touchit;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import javax.jms.Connection;

public class JMSConsumer implements MessageListener{
    private static final String QUEUE_NAME = "ActiveMQMessenger.in";
    private ActiveMQConnectionFactory connectionFactory;
    private Connection connection;
    private Session session;

    public JMSConsumer(){
        System.out.println("JMSConsumer() -> object created");
        connectionFactory = new ActiveMQConnectionFactory();
    }

    public void initialise(){
        try {
            System.out.println("initialise() -> initialise Consumer");
            connection = connectionFactory.createConnection();
            connection.start();

            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue(QUEUE_NAME);
            MessageConsumer consumer = session.createConsumer(destination);
            consumer.setMessageListener(this);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("onMessage() -> messageID = " + message.getJMSMessageID());
            TextMessage textMessage = (TextMessage) message;
            System.out.println("onMessage() -> message = " +  textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void close(){
        try {
            connection.close();
            session.close();
            System.out.println("close() -> connection Consumer closed");
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}