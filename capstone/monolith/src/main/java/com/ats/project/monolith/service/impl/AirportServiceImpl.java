package com.ats.project.monolith.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ats.project.monolith.entity.Airport;
import com.ats.project.monolith.repository.AirportRepository;
import com.ats.project.monolith.repository.impl.IncrementRepository;
import com.ats.project.monolith.service.AirportService;
import com.ats.project.monolith.service.dto.AirportDTO;
import com.ats.project.monolith.service.mapper.AirportMapper;

@Service
@Transactional
public class AirportServiceImpl implements AirportService {

	private AirportRepository repository;
	private AirportMapper mapper;
	private IncrementRepository incRepo;

	public AirportServiceImpl(AirportRepository repository, AirportMapper mapper, IncrementRepository incRepo) {
		this.repository = repository;
		this.mapper = mapper;
		this.incRepo = incRepo;
	}

	@Override
	public AirportDTO createAirport(AirportDTO dto) {
		if (dto.getAirportCode() != null) {
			throw new ConstraintViolationException("id cannot exist for new passengers", null);
		}
		dto.setAirportCode("A" + String.format("%04d", incRepo.getAirportIdCounter()));
		Airport entity = mapper.toEntity(dto);
		entity = repository.save(entity);
		AirportDTO result = new AirportDTO();
		result.setAirportCode(entity.getAirportCode());
		return result;
	}

	@Override
	public void updateAirport(AirportDTO dto) {
		repository.findFirstByAirportCode(dto.getAirportCode()).map(mapper::toDto).ifPresent(existing -> {
			mapper.updateAirport(existing, dto);
			repository.save(mapper.toEntity(existing));
		});
		return;
	}

	@Override
	public List<AirportDTO> findAllAirports() {
		return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toCollection(LinkedList::new));
	}

	@Override
	public void deleteAirport(String airportCode) {
		repository.deleteById(airportCode);
	}

	@Override
	public List<AirportDTO> searchAirport(AirportDTO airport) {
		ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny().withMatcher("airport_name",
				matcher -> matcher.ignoreCase().contains());
		return repository.findAll(Example.of(mapper.toEntity(airport), exampleMatcher)).stream().map(mapper::toDto)
				.collect(Collectors.toList());
	}
}
