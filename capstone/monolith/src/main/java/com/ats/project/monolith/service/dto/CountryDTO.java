package com.ats.project.monolith.service.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CountryDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@NotBlank
	@Size(min=1, max=5)
	private String countryCode;
	
	private String countryName;
	
	private String countryCity;
	
	private String countryState;

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCity() {
		return countryCity;
	}

	public void setCountryCity(String countryCity) {
		this.countryCity = countryCity;
	}

	public String getCountryState() {
		return countryState;
	}

	public void setCountryState(String countryState) {
		this.countryState = countryState;
	}
}
