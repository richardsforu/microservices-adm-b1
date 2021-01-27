package com.cts.flight.dao;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.flight.entity.Flight;

public interface FlightDao extends JpaRepository<Flight, Integer> {

	public Flight findFlightByFlightNumberAndOriginAndDestinationAndFlightDateAndFlightTime(String flightNumber,String origin, String destination,
			LocalDate flightDate, LocalTime flightTime);

}
