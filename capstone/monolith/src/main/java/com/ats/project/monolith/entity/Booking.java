package com.ats.project.monolith.entity;

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

@Entity
@Table(name="tb_booking")
public class Booking implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "booking_id")
	private String bookingId;
	
	@JoinColumn(name = "passenger_id", referencedColumnName = "passenger_id", nullable= false)
	private Passenger passenger;
	
	@Column(name = "booking_date")
	private LocalDate bookingDate;
	
	@Column(name = "seat_no")
	private String seatNo;
	
	@Column(name = "cost")
	private BigDecimal cost;
	
	@Column(name = "total_amount")
	private BigDecimal totalAmount;

	@JoinColumn(name = "schedule_id", referencedColumnName = "schedule_id", nullable= false)
	private Schedule schedule;

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
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

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	
}
