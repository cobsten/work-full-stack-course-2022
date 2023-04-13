package com.ats.project.monolith.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BookingDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String bookingId;
	
	@NotNull
	private PassengerDTO passenger;
	
	@NotNull
	private LocalDate bookingDate;
	
	@NotBlank
	private String seatNo;
	
	@Min(0)
	@NotNull
	private BigDecimal cost;

	@Min(0)
	@NotNull
	private BigDecimal totalAmount;

	@NotNull
	private ScheduleDTO schedule;

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public PassengerDTO getPassenger() {
		return passenger;
	}

	public void setPassenger(PassengerDTO passenger) {
		this.passenger = passenger;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public ScheduleDTO getSchedule() {
		return schedule;
	}

	public void setSchedule(ScheduleDTO schedule) {
		this.schedule = schedule;
	}
	
	
}
