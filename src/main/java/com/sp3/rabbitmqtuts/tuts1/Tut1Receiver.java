package com.sp3.rabbitmqtuts.tuts1;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "hello")
public class Tut1Receiver {
	
	@RabbitHandler 
	public void receive(String in) {
		System.out.println(" [x] Reieved '" + "'");
	}
}
