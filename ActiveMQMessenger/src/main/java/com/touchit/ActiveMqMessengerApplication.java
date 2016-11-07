package com.touchit;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import javax.jms.*;

@SpringBootApplication
public class ActiveMqMessengerApplication{

	public static void main(String[] args) {
		SpringApplication.run(ActiveMqMessengerApplication.class, args);

		JMSConsumer consumer = new JMSConsumer();
		consumer.initialise();
	}
}