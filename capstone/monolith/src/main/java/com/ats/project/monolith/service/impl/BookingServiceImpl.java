package com.ats.project.monolith.service.impl;

import javax.validation.ConstraintViolationException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ats.project.monolith.entity.Booking;
import com.ats.project.monolith.repository.BookingRepository;
import com.ats.project.monolith.repository.impl.IncrementRepository;
import com.ats.project.monolith.service.BookingService;
import com.ats.project.monolith.service.dto.BookingDTO;
import com.ats.project.monolith.service.mapper.BookingMapper;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

	private BookingRepository bookingRepository;
	private BookingMapper bookingMapper;
	private IncrementRepository incRepo;
	
	public BookingServiceImpl(BookingRepository bookingRepository, BookingMapper bookingMapper, IncrementRepository incRepo) {
		this.bookingRepository= bookingRepository;
		this.bookingMapper = bookingMapper;
		this.incRepo = incRepo;
	}
	
	@Override
	public BookingDTO createBooking(BookingDTO dto) {
		if(dto.getBookingId()==null) {
			throw new ConstraintViolationException("Booking Id cannot exist for new bookings", null);
		}
		
		dto.setBookingId( "B" + String.format("%04d",incRepo.getBookingIdCounter()));
		Booking entity = bookingMapper.toEntity(dto);
		entity = bookingRepository.save(entity);
		BookingDTO result = new BookingDTO();
		result.setBookingId(entity.getBookingId());
		return result;
	}
	
	@Override
	public void deleteBooking(String bookingId) {
		bookingRepository.deleteById(bookingId);
	}
}
