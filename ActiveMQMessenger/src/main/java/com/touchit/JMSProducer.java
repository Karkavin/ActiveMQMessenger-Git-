package com.touchit;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JMSProducer extends Thread {
    private static final String QUEUE_NAME = "ActiveMQMessenger.in";
    private ActiveMQConnectionFactory connectionFactory;
    private String message;

    public JMSProducer(String url){
        System.out.println("JMSProducer() -> object created");
        connectionFactory = new ActiveMQConnectionFactory(url);
        this.message = "";
    }

    public void addMessage(String message){
        System.out.println("addMessage() -> message added");
        this.message = message;
    }

    @Override
    public synchronized void start() {
        System.out.println("start() -> thread started");
        if (!message.equals("")) {
            try {
                Connection connection = connectionFactory.createConnection();
                connection.start();

                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

                Destination destination = session.createQueue(QUEUE_NAME);
                MessageProducer producer = session.createProducer(destination);

                Message msg = session.createTextMessage(this.message);
                producer.send(msg);

                System.out.println("start() -> message(" + this.message + ") sent!");

                close(connection, session);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

    private void close(Connection connection, Session session){
        try {
            connection.close();
            session.close();
            System.out.println("close() -> connections Producer closed!");
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}