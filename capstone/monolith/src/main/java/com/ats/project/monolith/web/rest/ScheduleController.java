package com.ats.project.monolith.web.rest;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ats.project.monolith.service.ScheduleService;
import com.ats.project.monolith.service.dto.ScheduleDTO;

@RestController
@Validated
@RequestMapping("/api/schedule")
public class ScheduleController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	private ScheduleService scheduleService;
	
	public ScheduleController(ScheduleService scheduleService) {
		this.scheduleService = scheduleService;
	}
	
	@PostMapping("")
	public ResponseEntity<?> createSchedule(@RequestBody @Valid ScheduleDTO dto){
		return ResponseEntity.ok(scheduleService.createSchedule(dto));
	}

	@PatchMapping("")
	public ResponseEntity<?> updateSchedule(@RequestBody @Valid ScheduleDTO dto){
		scheduleService.updateSchedule(dto);
		return ResponseEntity.ok(null);
	}
	
	@DeleteMapping("")
	public ResponseEntity<?> deleteSchedule(@RequestBody String scheduleId){
		scheduleService.deleteSchedule(scheduleId);
		return ResponseEntity.ok(null);
	}
	
	
	
}
