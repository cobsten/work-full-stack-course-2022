package com.ats.project.monolith.web.rest;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ats.project.monolith.service.PlaneService;
import com.ats.project.monolith.service.dto.PlaneDTO;

@RestController
@Validated
@RequestMapping("/api/planes")
public class PlaneController {

	private PlaneService planeService;
	
	public PlaneController(PlaneService planeService) {
		this.planeService = planeService;
	}
	
	@PostMapping("")
	public ResponseEntity<?> createPlane(@RequestBody @Valid PlaneDTO plane) {
		return ResponseEntity.ok(planeService.createPlane(plane));
	}

	@GetMapping("")
	public ResponseEntity<?> retrievePlanes() {
		return ResponseEntity.ok(planeService.findAllPlanes());
	}
	@DeleteMapping("")
	public ResponseEntity<?> deletePlane(@RequestBody @NotNull String regNo) {
		planeService.deletePlane(regNo);
		return ResponseEntity.ok().build();
	}
}
