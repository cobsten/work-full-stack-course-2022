package com.ats.project.monolith.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_airport")
public class Airport implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "airport_code", length = 5)
	private String airportCode;
    
    @Column(name = "airport_name")
	private String airportName;
	
//    @ManyToOne
//	@JoinColumn(name = "country_code", referencedColumnName = "country_code", nullable= false)
//	private Country country;
    
    @Column(name = "country_code", length = 5)
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
	
	
    
}
