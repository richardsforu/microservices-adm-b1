package com.cts.flight.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;

@Controller
@RefreshScope
public class Receiver {
	
	@Autowired
    private JavaMailSender javaMailSender;
	

	@Bean
	Queue emailQ() {
		return new Queue("EmailQ", false);
	}
	
	@RabbitListener(queues = "EmailQ")
    public void processMessage(Map<String,Object> bookingDetails) {
		
        System.out.println("===========> Email-Service:: ****====**** <===========");
		System.out.println(bookingDetails);
		System.out.println("===========> Email-Service:: ****====**** <===========");
       

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("richardsforu@gmail.com", "ctsgit@gmail.com", "praveen.somireddy@gmail.com");

        String flightNumber=(String)bookingDetails.get("FLIGHT_NUMBER");
        LocalDate flightDate=(LocalDate)bookingDetails.get("DATE");
        String firstName=(String)bookingDetails.get("FIRST_NAME");
        String lastName=(String)bookingDetails.get("LAST_NAME");
        LocalTime time=(LocalTime)bookingDetails.get("TIME");
        String origin=(String)bookingDetails.get("ORIGIN");
        String destination=(String)bookingDetails.get("DESTINATION");
        int bookingId=(int)bookingDetails.get("BOOKING_ID");


        
        
        msg.setSubject("Booking Conformation on Booking ID "+bookingId);
        msg.setText("Dear "+firstName+" "+lastName+", You Flight Number "+flightNumber+" is confirmed on "+flightDate +" at "+time +" from "+origin+" to  "+destination+". You booking id is "+bookingId);

        javaMailSender.send(msg);
        
		// Logic to send email ...
		
		// searchService.updateInventory((String)fare.get("FLIGHT_NUMBER"),(LocalDate)fare.get("FLIGHT_DATE"),(int)fare.get("NEW_INVENTORY"));
       //call repository and update the fare for the given flight
    }	

}
