package com.ats.project.monolith.service.impl;

import java.util.Base64;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.ConstraintViolationException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ats.project.monolith.entity.Plane;
import com.ats.project.monolith.repository.PlaneRepository;
import com.ats.project.monolith.repository.impl.IncrementRepository;
import com.ats.project.monolith.service.PlaneService;
import com.ats.project.monolith.service.dto.PlaneDTO;
import com.ats.project.monolith.service.mapper.PlaneMapper;

@Service
@Transactional
public class PlaneServiceImpl implements PlaneService {

	private Set<Integer> capacity = Stream.of(50,100,150,500).collect(Collectors.toSet());
	private PlaneMapper mapper;
	private PlaneRepository repository;
	private IncrementRepository incRepo;
	
	public PlaneServiceImpl(PlaneMapper mapper,PlaneRepository repository,IncrementRepository incRepo) {
		this.mapper =mapper;
		this.repository = repository;
		this.incRepo = incRepo;
	}
	
	@Override
	public PlaneDTO createPlane(PlaneDTO dto) {
		
		if(!capacity.contains(dto.getPlaceCapacity())) {
			throw new ConstraintViolationException("The seating capacity should be 50,100,150 or 500", null);
		}
		
		if(dto.getPlaneRegNo()!=null) {
			throw new ConstraintViolationException("id cannot exist for new planes", null);
		}
		dto.setPlaneRegNo( "R" + String.format("%04d",incRepo.getPlaneRegNoCounter()));
		Plane entity = mapper.toEntity(dto);
		String image = dto.getPlaneImage();
		if(image!=null) {
			entity.setPlaneImage(Base64.getMimeDecoder().decode(image));
		}
		entity = repository.save(entity);
		PlaneDTO result = new PlaneDTO();
		result.setPlaneRegNo(entity.getPlaneRegNo());
		return result;
	}
	
	@Override
	public List<PlaneDTO> findAllPlanes() {
		return repository.findAll().stream().map(t -> {
			PlaneDTO dto = mapper.toDto(t);
			if (t.getPlaneImage() != null) {
				dto.setPlaneImage(Base64.getMimeEncoder().encodeToString(t.getPlaneImage()));
			}
			return dto;
		}).collect(Collectors.toCollection(LinkedList::new));

	}
	
	@Override
	public void deletePlane(String regNo) {
		repository.deleteById(regNo);
	}
}
