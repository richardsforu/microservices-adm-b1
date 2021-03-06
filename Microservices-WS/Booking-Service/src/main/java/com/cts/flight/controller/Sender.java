package com.cts.flight.controller;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class Sender {

	@Autowired
	private RabbitMessagingTemplate template;

	@Bean
	public Queue queue1() {
		return new Queue("InventoryQ", false);
	}

	@Bean
	public Queue queue2() {
		return new Queue("CheckinQ", false);
	}

	@Bean
	Queue queue3() {
		return new Queue("EmailQ", false);
	}
	public void sendInventoryData(Object map) {
		template.convertAndSend("InventoryQ", map);
	}
	public void sendEmail(Object bookingObj) {
		template.convertAndSend("EmailQ",bookingObj);
	}


}
