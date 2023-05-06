package com.ats.project.monolith.web.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ats.project.monolith.service.CountryService;
import com.ats.project.monolith.service.dto.CountryDTO;

@RestController
@RequestMapping("/api/countries")
public class CountryController {
	
	private CountryService countryService;
	
	public CountryController(CountryService countryService) {
		this.countryService = countryService;
	}
	
	@GetMapping("")
	public List<CountryDTO> retrieveAllCountries(){
		return countryService.retrieveAllCountries();
	}
	
}
