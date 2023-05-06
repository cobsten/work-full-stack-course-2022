package com.ats.project.monolith.web.rest;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ats.project.monolith.service.AirportService;
import com.ats.project.monolith.service.dto.AirportDTO;

@Validated
@RestController
@RequestMapping("/api/airports")
public class AirportController {
	
	private Logger log = LoggerFactory.getLogger(getClass());

	private AirportService airportService;
	
	public AirportController(AirportService airportService) {
		this.airportService = airportService;
	}
	
	@PostMapping("")
	public ResponseEntity<?> createAirport(@RequestBody @Valid AirportDTO airport) {
		return ResponseEntity.ok(airportService.createAirport(airport));
	}
	@PatchMapping("")
	public ResponseEntity<?> updateAirport(@RequestBody @Valid AirportDTO airport) {
		log.info(airport.toString());
		airportService.updateAirport(airport);
		return ResponseEntity.ok().build();
	}
	@GetMapping("")
	public ResponseEntity<?> retrieveAirports() {
		return ResponseEntity.ok(airportService.findAllAirports());
	}
	
	@DeleteMapping("/{airportCode}")
	public ResponseEntity<?> deleteAirport(@PathVariable("airportCode") String airportCode){
		airportService.deleteAirport(airportCode);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/search")
	public ResponseEntity<?> findAirport(@RequestBody AirportDTO airport){
		return ResponseEntity.ok().body(airportService.searchAirport(airport));
	}

}
	

