package com.ats.project.monolith.service.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)
public class AirportDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String airportCode;

	@NotBlank
	private String airportName;

	@NotBlank
	private String countryCode;

	public String getAirportCode() {
		return airportCode;
	}

	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AirportDTO [airportCode=").append(airportCode).append(", airportName=").append(airportName)
				.append(", countryCode=").append(countryCode).append("]");
		return builder.toString();
	}	

}
