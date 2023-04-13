package com.ats.project.monolith.service.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PassengerDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("passengerId")
	private String passengerId;
	
	@JsonProperty("passengerName")
	private String passengerName;
	
	@Size(min=10, max =10)
	@JsonProperty("contactNo")
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PassengerDTO [passengerId=").append(passengerId).append(", passengerName=")
				.append(passengerName).append(", contactNo=").append(contactNo).append("]");
		return builder.toString();
	}
	
}
