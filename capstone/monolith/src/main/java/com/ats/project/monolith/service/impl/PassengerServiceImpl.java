package com.ats.project.monolith.service.impl;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ats.project.monolith.entity.Passenger;
import com.ats.project.monolith.repository.PassengerRepository;
import com.ats.project.monolith.repository.impl.IncrementRepository;
import com.ats.project.monolith.service.PassengerService;
import com.ats.project.monolith.service.dto.PassengerDTO;
import com.ats.project.monolith.service.mapper.PassengerMapper;

@Service
@Transactional
public class PassengerServiceImpl implements PassengerService {

	private PassengerMapper mapper;
	
	private PassengerRepository repository;
	
	private IncrementRepository incRepo;
	
	public PassengerServiceImpl(PassengerMapper mapper, PassengerRepository repository, IncrementRepository incRepo) {
		this.mapper = mapper;
		this.repository = repository;
		this.incRepo = incRepo;
	}
	
	@Override
	public Map<String,Object> createPassenger(PassengerDTO passenger) {
		if(passenger.getPassengerId()!=null) {
			throw new ConstraintViolationException("id cannot exist for new passengers", null);
		}
		passenger.setPassengerId( "G" + String.format("%04d",incRepo.getPassengerIdCounter()));
		Passenger entity = mapper.toEntity(passenger);
		entity = repository.save(entity);
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("passengerId", mapper.toDto(entity).getPassengerId());
        return result;
	}
	
	@Override
	public Optional<PassengerDTO> updatePassenger(PassengerDTO passenger) {
		Optional<Passenger> resultSet = repository.findFirstByPassengerId(passenger.getPassengerId());
		if(resultSet.isPresent()) {
			Passenger result = resultSet.get();
			mapper.updateEntity(result, passenger);
			result = repository.save(result);
			return Optional.of(result).map(mapper::toDto);
		}
		return Optional.empty();
	}
}
