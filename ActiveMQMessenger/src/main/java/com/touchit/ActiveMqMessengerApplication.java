package com.touchit;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ActiveMqMessengerApplication{

	public static void main(String[] args) {
		SpringApplication.run(ActiveMqMessengerApplication.class, args);

		String url = "localhost:61616";
		JMSConsumer consumer = new JMSConsumer(url);
		consumer.initialise();
	}
}