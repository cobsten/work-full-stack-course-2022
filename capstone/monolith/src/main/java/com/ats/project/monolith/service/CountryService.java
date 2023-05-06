package com.ats.project.monolith.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ats.project.monolith.repository.CountryRepository;
import com.ats.project.monolith.service.dto.CountryDTO;
import com.ats.project.monolith.service.mapper.CountryMapper;

@Service
@Transactional
public class CountryService {

	private CountryMapper countryMapper;
	private CountryRepository countryRepository;
	
	public CountryService(CountryMapper countryMapper, CountryRepository countryRepository) {
		this.countryMapper = countryMapper;
		this.countryRepository = countryRepository;
	}
	
	public List<CountryDTO> retrieveAllCountries() {
		return countryRepository.findAll().stream().map(countryMapper::toDto).collect(Collectors.toList());
	}
}
