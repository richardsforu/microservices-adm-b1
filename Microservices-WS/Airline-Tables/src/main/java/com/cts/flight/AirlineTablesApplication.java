package com.cts.flight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cts.flight.dao.BookingRecordDao;
import com.cts.flight.dao.CheckinDao;
import com.cts.flight.dao.FlightDao;
import com.cts.flight.dao.PassengerDao;
import com.cts.flight.entity.AirlineInfo;
import com.cts.flight.entity.BookingRecord;
import com.cts.flight.entity.CheckIn;
import com.cts.flight.entity.CoPassenger;
import com.cts.flight.entity.Fare;
import com.cts.flight.entity.Flight;
import com.cts.flight.entity.FlightInfo;
import com.cts.flight.entity.Inventory;
import com.cts.flight.entity.Passenger;

@SpringBootApplication
public class AirlineTablesApplication {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(AirlineTablesApplication.class, args);

		FlightDao flightRepository = ac.getBean(FlightDao.class);
		PassengerDao passengerDao=ac.getBean(PassengerDao.class);
		BookingRecordDao bookingRecord=ac.getBean(BookingRecordDao.class);
		FlightDao  flightDao=ac.getBean(FlightDao.class);
		CheckinDao checkinDao=ac.getBean(CheckinDao.class);

		List<Flight> flights = new ArrayList<>();
		List<AirlineInfo> airlines = new ArrayList<>();

		AirlineInfo a1 = new AirlineInfo("Air India", "airindia.png");
		AirlineInfo a2 = new AirlineInfo("Indigo", "indigo.png");
		AirlineInfo a3 = new AirlineInfo("Air Asia", "air-asia.png");
		AirlineInfo a4 = new AirlineInfo("Spicejet", "spicejet.png");
		AirlineInfo a5 = new AirlineInfo("Vistara", "vistara.png");
		AirlineInfo a6 = new AirlineInfo("Trujet", "truejet.png");
		AirlineInfo a7 = new AirlineInfo("GoAir", "goair.png");

		airlines.add(a1);
		airlines.add(a2);
		airlines.add(a3);
		airlines.add(a4);
		airlines.add(a5);
		airlines.add(a6);
		airlines.add(a7);

		FlightInfo f1 = new FlightInfo("AI-840", "Airbus", 150,a1);
		FlightInfo f2 = new FlightInfo("AI-850", "Airbus", 150,a1);
		FlightInfo f3 = new FlightInfo("AI-860", "Airbus", 150,a1);
		FlightInfo f4 = new FlightInfo("AI-870", "Airbus", 150,a1);

		FlightInfo f5 = new FlightInfo("6E-6684", "Airbus", 150,a2);
		FlightInfo f6 = new FlightInfo("6E-6685", "Airbus", 150,a2);
		FlightInfo f7 = new FlightInfo("6E-6686", "Airbus", 150,a2);
		FlightInfo f8 = new FlightInfo("6E-6687", "Airbus", 150,a2);

		FlightInfo f9 = new FlightInfo("I5-755", "Airbus", 150,a3);
		FlightInfo f10 = new FlightInfo("I5-756", "Airbus", 150,a3);
		FlightInfo f11 = new FlightInfo("I5-757", "Airbus", 150,a3);
		FlightInfo f12 = new FlightInfo("I5-758", "Airbus", 150,a3);

		FlightInfo f13 = new FlightInfo("SG-432", "Airbus", 150,a4);
		FlightInfo f14 = new FlightInfo("SG-433", "Airbus", 150,a4);
		FlightInfo f15 = new FlightInfo("SG-434", "Airbus", 150,a4);
		FlightInfo f16 = new FlightInfo("SG-435", "Airbus", 150,a4);

		FlightInfo f17 = new FlightInfo("UK-830", "Airbus", 150,a5);
		FlightInfo f18 = new FlightInfo("UK-831", "Airbus", 150,a5);
		FlightInfo f19 = new FlightInfo("UK-832", "Airbus", 150,a5);
		FlightInfo f20 = new FlightInfo("UK-833", "Airbus", 150,a5);

		FlightInfo f21 = new FlightInfo("2T-518", "Airbus", 150,a6);
		FlightInfo f22 = new FlightInfo("2T-519", "Airbus", 150,a6);
		FlightInfo f23 = new FlightInfo("2T-520", "Airbus", 150,a6);
		FlightInfo f24 = new FlightInfo("2T-521", "Airbus", 150,a6);

		FlightInfo f25 = new FlightInfo("G8-424", "Airbus", 150,a7);
		FlightInfo f26 = new FlightInfo("G8-425", "Airbus", 150,a7);
		FlightInfo f27 = new FlightInfo("G8-426", "Airbus", 150,a7);
		FlightInfo f28 = new FlightInfo("G8-427", "Airbus", 150,a7);

		a1.getFlights().add(f1);
		a1.getFlights().add(f2);
		a1.getFlights().add(f3);
		a1.getFlights().add(f4);

		a2.getFlights().add(f5);
		a2.getFlights().add(f6);
		a2.getFlights().add(f7);
		a2.getFlights().add(f8);

		a3.getFlights().add(f9);
		a3.getFlights().add(f10);
		a3.getFlights().add(f11);
		a3.getFlights().add(f12);

		a4.getFlights().add(f13);
		a4.getFlights().add(f14);
		a4.getFlights().add(f15);
		a4.getFlights().add(f16);

		a5.getFlights().add(f17);
		a5.getFlights().add(f18);
		a5.getFlights().add(f19);
		a5.getFlights().add(f20);

		a6.getFlights().add(f21);
		a6.getFlights().add(f22);
		a6.getFlights().add(f23);
		a6.getFlights().add(f24);

		a7.getFlights().add(f25);
		a7.getFlights().add(f26);
		a7.getFlights().add(f27);
		a7.getFlights().add(f28);

		// airlineDao.saveAll(airlines); // never enable it. coz flight itself saves all other cascading entities.

		flights.add(new Flight(f1.getFlightNumber(), "DELHI", "CHENNAI", "2 hrs 15 mins", LocalDate.of(2021, 2, 26),
				LocalTime.of(2, 12), new Fare(4800, "INR"), new Inventory(100), f1));
		flights.add(new Flight(f2.getFlightNumber(), "DELHI", "HYDERABAD", "2 hrs 45 mins", LocalDate.of(2021, 2, 26),
				LocalTime.of(1, 15), new Fare(3500, "INR"), new Inventory(100), f2));
		flights.add(new Flight(f3.getFlightNumber(), "CHENNAI", "MUMBAI", "2 hrs 50 mins", LocalDate.of(2021, 2, 26),
				LocalTime.of(2, 30), new Fare(5000, "INR"), new Inventory(100), f3));
		flights.add(new Flight(f4.getFlightNumber(), "PUNE", "HYDERABAD", "1 hrs 45 mins", LocalDate.of(2021, 2, 18),
				LocalTime.of(2, 45), new Fare(2546, "INR"), new Inventory(100), f4));
		flights.add(new Flight(f5.getFlightNumber(), "CHENNAI", "PORTBLAIR", "3 hrs 00 mins", LocalDate.of(2021, 2, 21),
				LocalTime.of(3, 00), new Fare(7500, "INR"), new Inventory(100), f5));
		flights.add(new Flight(f6.getFlightNumber(), "BENGULURU", "DELHI", "3 hrs 15 mins", LocalDate.of(2021, 2, 26),
				LocalTime.of(3, 15), new Fare(10000, "INR"), new Inventory(100), f6));
		flights.add(new Flight(f7.getFlightNumber(), "DELHI", "PUNE", "3 hrs 07 mins", LocalDate.of(2021, 4, 24),
				LocalTime.of(3, 15), new Fare(7438, "INR"), new Inventory(100), f7));
		flights.add(new Flight(f8.getFlightNumber(), "HYDERABAD", "MANGALORE", "3 hrs 30 mins",
				LocalDate.of(2021, 3, 18), LocalTime.of(3, 15), new Fare(8743, "INR"), new Inventory(100), f8));
		flights.add(new Flight(f9.getFlightNumber(), "MUMBAI", "AHMADABAD", "6 hrs 00 mins", LocalDate.of(2021, 2, 13),
				LocalTime.of(4, 30), new Fare(1955, "INR"), new Inventory(100), f9));
		flights.add(new Flight(f10.getFlightNumber(), "HYDERABAD", "KOLKATA", "3 hrs 15 mins",
				LocalDate.of(2021, 2, 27), LocalTime.of(4, 45), new Fare(2500, "INR"), new Inventory(100), f10));
		flights.add(new Flight(f11.getFlightNumber(), "KOLKATA", "DELHI", "1 hrs 00 mins", LocalDate.of(2021, 2, 26),
				LocalTime.of(7, 45), new Fare(4943, "INR"), new Inventory(100), f11));
		flights.add(new Flight(f15.getFlightNumber(), "DELHI", "MUMBAI", "1 hrs 20 mins", LocalDate.of(2021, 2, 26),
				LocalTime.of(11, 45), new Fare(4943, "INR"), new Inventory(100), f15));

		flights.add(new Flight(f16.getFlightNumber(), "DELHI", "CHENNAI", "2 hrs 10 mins", LocalDate.of(2021, 2, 26),
				LocalTime.of(2, 45), new Fare(4500, "INR"), new Inventory(100), f16));
		flights.add(new Flight(f17.getFlightNumber(), "DELHI", "CHENNAI", "2 hrs 05 mins", LocalDate.of(2021, 2, 26),
				LocalTime.of(10, 15), new Fare(6200, "INR"), new Inventory(100), f17));
		flights.add(new Flight(f18.getFlightNumber(), "DELHI", "CHENNAI", "2 hrs 14 mins", LocalDate.of(2021, 2, 26),
				LocalTime.of(11, 30), new Fare(5000, "INR"), new Inventory(100), f18));

		flights.add(new Flight(f19.getFlightNumber(), "DELHI", "CHENNAI", "2 hrs 12 mins", LocalDate.of(2021, 3, 17),
				LocalTime.of(11, 55), new Fare(1200, "INR"), new Inventory(120), f19));
		flights.add(new Flight(f20.getFlightNumber(), "DELHI", "CHENNAI", "1 hrs 55 mins", LocalDate.of(2021, 2, 23),
				LocalTime.of(11, 55), new Fare(1389, "INR"), new Inventory(100), f20));
		flights.add(new Flight(f21.getFlightNumber(), "DELHI", "CHENNAI", "2 hrs 10 mins", LocalDate.of(2021, 2, 26),
				LocalTime.of(10, 15), new Fare(11000, "INR"), new Inventory(100), f21));
		flights.add(new Flight(f22.getFlightNumber(), "DELHI", "CHENNAI", "2 hrs 22 mins", LocalDate.of(2021, 2, 26),
				LocalTime.of(19, 35), new Fare(15000, "INR"), new Inventory(100), f22));
		flights.add(new Flight(f23.getFlightNumber(), "DELHI", "CHENNAI", "1 hrs 45 mins", LocalDate.of(2021, 2, 26),
				LocalTime.of(6, 15), new Fare(3000, "INR"), new Inventory(100), f23));
		flights.add(new Flight(f24.getFlightNumber(), "DELHI", "CHENNAI", "1 hrs 55 mins", LocalDate.of(2021, 2, 26),
				LocalTime.of(22, 45), new Fare(9000, "INR"), new Inventory(100), f24));
		
		flightRepository.saveAll(flights);

		Passenger p1 = new Passenger("Praveen", "Reddy", "praveen@abc.com", "Male", 9776565434L);
		Passenger p2 = new Passenger("Divya", "Gopu", "geet@abc.com", "Female", 9876565432L);
		Passenger p3 = new Passenger("Saravanan", "Valli", "saru@abc.com", "Male", 9376568754L);

		CoPassenger cp1 = new CoPassenger("James", "Goedic", "Male");
		CoPassenger cp2 = new CoPassenger("Rose", "Ella", "Female");
		CoPassenger cp3 = new CoPassenger("Bucky", "Wall", "Male");
		CoPassenger cp4 = new CoPassenger("Aarush", "S", "Male");
		CoPassenger cp5 = new CoPassenger("Sameera", "Reddy", "Female");
		CoPassenger cp6 = new CoPassenger("Ravi", "Kumar", "Male");
		
		
		p1.getCopassengers().add(cp1);
		p1.getCopassengers().add(cp2);
		p2.getCopassengers().add(cp3);
		p2.getCopassengers().add(cp4);
		p2.getCopassengers().add(cp5);
		p3.getCopassengers().add(cp6);
		
		Flight flight1=flightDao.findFlightByFlightNumberAndFlightDate("AI-840", LocalDate.of(2021, 02, 26));
		Flight flight2=flightDao.findFlightByFlightNumberAndFlightDate("6E-6685", LocalDate.of(2021, 02, 26));
		Flight flight3=flightDao.findFlightByFlightNumberAndFlightDate("UK-830", LocalDate.of(2021, 02, 26));

		
		BookingRecord b1=new BookingRecord(flight1.getFlightDate(), flight1.getFlightTime(), LocalDateTime.now(), flight1.getFlightNumber(), flight1.getOrigin(), flight1.getDestination(), flight1.getFare().getFare(), p1, "CONFIRMED",f1);
		BookingRecord b2=new BookingRecord(flight2.getFlightDate(), flight2.getFlightTime(), LocalDateTime.now(), flight2.getFlightNumber(), flight2.getOrigin(), flight2.getDestination(), flight2.getFare().getFare(), p2,  "CONFIRMED",f6);
		BookingRecord b3=new BookingRecord(flight3.getFlightDate(), flight3.getFlightTime(), LocalDateTime.now(), flight3.getFlightNumber(), flight3.getOrigin(), flight3.getDestination(), flight3.getFare().getFare(), p3, "CONFIRMED",f17);
		
		CheckIn chk1=new CheckIn(LocalDateTime.now(), "A4", b1);
		CheckIn chk2=new CheckIn(LocalDateTime.now(), "A3", b2);
		CheckIn chk3=new CheckIn(LocalDateTime.now(), "B2", b3);

		bookingRecord.save(b1);
		bookingRecord.save(b2);
		bookingRecord.save(b3);

		checkinDao.save(chk1);
		checkinDao.save(chk2);
		checkinDao.save(chk3);

		
		




		
		
		

	}

}
