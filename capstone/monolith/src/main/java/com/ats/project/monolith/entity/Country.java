package com.ats.project.monolith.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_country")
public class Country implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="country_code", length = 5, insertable = false,updatable = false)
	private String countryCode;
	
	@Column(name="country_name")
	private String countryName;
	
	@Column(name="country_city")
	private String countryCity;
	
	@Column(name="country_state")
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
