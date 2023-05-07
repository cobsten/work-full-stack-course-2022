package com.ats.project.monolith.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.project.monolith.entity.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, String>{

	Optional<Airport> findFirstByAirportCode(String airportCode);
	
	@Query("select a from Airport a where (:countryCode is null or a.countryCode=:countryCode) and (:airportName is null or a.airportName like :airportName)")
	List<Airport> findByCountryCodeAndAirportNameContaining(@Param("countryCode")String countryCode,@Param("airportName") String airportName);
}
