package com.ats.project.monolith.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.project.monolith.entity.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, String> {
	
	Optional<Passenger> findFirstByPassengerId(String passengerId);

}
