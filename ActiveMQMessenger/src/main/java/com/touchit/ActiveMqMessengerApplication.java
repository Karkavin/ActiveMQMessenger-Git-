package com.touchit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ActiveMqMessengerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActiveMqMessengerApplication.class, args);

		JMSConsumer consumer = new JMSConsumer();
		consumer.initialise();
	}
}