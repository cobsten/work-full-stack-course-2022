package com.ats.project.monolith.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_passenger")
public class Passenger implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="passenger_id", unique = true, updatable = false)
	private String passengerId;
	
	@Column(name="passenger_name")
	private String passengerName;
	
	@Column(name="contact_no", length=10)
	private String contactNo;


	public String getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	
}
