package com.ats.project.monolith.web.rest;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ats.project.monolith.service.PassengerService;
import com.ats.project.monolith.service.dto.PassengerDTO;

@Validated
@RestController
@RequestMapping("/api/passengers")
public class PassengerController {

	Logger log = LoggerFactory.getLogger(this.getClass());
	
	private PassengerService passengerService;
	
	public PassengerController(PassengerService passengerService) {
		this.passengerService = passengerService;
	}
	
	@PostMapping("")
	public ResponseEntity<?> createPassenger(@RequestBody @Valid PassengerDTO passenger) {
		return ResponseEntity.ok(passengerService.createPassenger(passenger));
	}
	@PatchMapping("")
	public ResponseEntity<?> updatePassenger(@RequestBody @Valid PassengerDTO passenger) {
		log.info(passenger.toString());
		return ResponseEntity.ok(passengerService.updatePassenger(passenger));
	}
}
