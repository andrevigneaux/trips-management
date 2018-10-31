package com.andre.tripsmanagement.repositories;

import com.andre.tripsmanagement.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Integer> {

}
