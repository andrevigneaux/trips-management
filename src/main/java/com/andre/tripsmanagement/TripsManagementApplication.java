package com.andre.tripsmanagement;

import com.andre.tripsmanagement.model.Trip;
import com.andre.tripsmanagement.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class TripsManagementApplication implements CommandLineRunner {

	@Autowired
	TripRepository tripRepository;
	public static void main(String[] args) {
		SpringApplication.run(TripsManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		tripRepository.save(new Trip("Now", stringDate()));
		tripRepository.save(new Trip("Again", stringDate()));
		tripRepository.save(new Trip("and again", stringDate()));
		tripRepository.save(new Trip("cool", stringDate()));
		tripRepository.save(new Trip("sdsad", stringDate()));
	}

	public Date stringDate() {
		return new Date();
	}
}
