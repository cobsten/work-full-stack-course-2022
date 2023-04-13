package com.ats.project.monolith.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ats.project.monolith.service.BookingService;
import com.ats.project.monolith.service.dto.BookingDTO;

@RestController
@Validated
@RequestMapping("/api/bookings")
public class BookingController {

	private BookingService bookingService;
	
	public BookingController(BookingService bookingService) {
		this.bookingService = bookingService;
	}
	
	@PostMapping("")
	public ResponseEntity<?> createBooking(BookingDTO dto){
		return ResponseEntity.ok(bookingService.createBooking(dto));
	}
	
	@DeleteMapping("")
	public ResponseEntity<?> deleteBooking(String bookingId){
		bookingService.deleteBooking(bookingId);
		return ResponseEntity.ok(null);
	}
}
