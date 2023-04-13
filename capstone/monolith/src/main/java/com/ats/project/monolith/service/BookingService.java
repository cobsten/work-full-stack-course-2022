package com.ats.project.monolith.service;

import com.ats.project.monolith.service.dto.BookingDTO;

public interface BookingService {

	BookingDTO createBooking(BookingDTO dto);

	void deleteBooking(String bookingId);

}
