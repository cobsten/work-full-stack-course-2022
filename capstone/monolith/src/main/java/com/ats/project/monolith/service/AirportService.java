package com.ats.project.monolith.service;

import java.util.List;

import com.ats.project.monolith.entity.Airport;
import com.ats.project.monolith.service.dto.AirportDTO;

public interface AirportService {

	AirportDTO createAirport(AirportDTO dto);

	void updateAirport(AirportDTO dto);

	List<AirportDTO> findAllAirports();

	void deleteAirport(String airportCode);

	List<AirportDTO> searchAirport(AirportDTO airport);

}
