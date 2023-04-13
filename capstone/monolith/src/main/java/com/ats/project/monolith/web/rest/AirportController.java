package com.ats.project.monolith.web.rest;

import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
		airportService.updateAirport(airport);
		return ResponseEntity.ok().build();
	}
	@GetMapping("")
	public ResponseEntity<?> retrieveAirports() {
		return ResponseEntity.ok(airportService.findAllAirports());
	}
}
