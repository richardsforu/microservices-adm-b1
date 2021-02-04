package com.cts.flight.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.flight.entity.Fare;
import com.cts.flight.service.FareService;

@RestController
@CrossOrigin
@RequestMapping("/api/fare")
@RefreshScope
public class FareRestController {

	@Value("${fare.discount}")
	private String faresDiscount;

	@Autowired
	private FareService fareService;

	@GetMapping("/{flightNumber}/{flightDate}/{origin}/{destination}")
	public ResponseEntity<Object> getFareByFlightDateAndFlightTime(@PathVariable("flightNumber") String flightNumber,
			@PathVariable("flightDate") @DateTimeFormat(iso = ISO.DATE) LocalDate flightDate,
			@PathVariable("origin") String origin, @PathVariable("destination") String destination) {

		System.out.println(">>>>>>>> Applying discount on Fare:: "+faresDiscount);
		Fare fare = fareService.findFlightByFlightNumberAndFlightDateAndOriginAndDestination(flightNumber, flightDate,
				origin, destination);

		if (fare != null) {

			return new ResponseEntity<>(fare, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("SOmething", HttpStatus.NO_CONTENT);
		}

	}

	@GetMapping("/{fareId}")
	public Fare getFare(@PathVariable("fareId") int fareId) {
		System.out.println(">>>>>>>> Applying discount on Fare:: "+faresDiscount);
		return fareService.getFareById(fareId);
	}

}