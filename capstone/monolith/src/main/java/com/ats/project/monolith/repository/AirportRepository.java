package com.ats.project.monolith.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.project.monolith.entity.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, String>{

	Optional<Airport> findFirstByAirportCode(String airportCode);
}
