package com.ats.project.monolith.service.impl;

import javax.validation.ConstraintViolationException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ats.project.monolith.entity.Schedule;
import com.ats.project.monolith.repository.PlaneRepository;
import com.ats.project.monolith.repository.ScheduleRepository;
import com.ats.project.monolith.repository.impl.IncrementRepository;
import com.ats.project.monolith.service.ScheduleService;
import com.ats.project.monolith.service.dto.ScheduleDTO;
import com.ats.project.monolith.service.mapper.ScheduleMapper;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {
	
	private ScheduleRepository scheduleRepository;
	
	private ScheduleMapper mapper;
	
	private PlaneRepository planeRepository;
	
	private IncrementRepository incRepo;
	
	public ScheduleServiceImpl(ScheduleRepository scheduleRepository, ScheduleMapper mapper, PlaneRepository planeRepository, IncrementRepository incRepo) {
		this.scheduleRepository = scheduleRepository;
		this.mapper = mapper;
		this.planeRepository = planeRepository;
		this.incRepo = incRepo;
	}
	
	@Override
	public ScheduleDTO createSchedule(ScheduleDTO dto) {
		 
		if(dto.getScheduleId()!=null) {
			throw new ConstraintViolationException("id cannot exist for new schedule", null);
		}
		dto.setScheduleId("S" + String.format("%04d",incRepo.getScheduleIdCounter()));
		Schedule entity = mapper.toEntity(dto);
		entity = scheduleRepository.save(entity);
		ScheduleDTO result = new ScheduleDTO();
		result.setScheduleId(entity.getScheduleId());
		return result;
	}
	
	@Override
	public void updateSchedule(ScheduleDTO dto) {
		
		scheduleRepository.findById(dto.getScheduleId()).ifPresent(entity ->{
			mapper.updateSchedule(entity, dto);
			scheduleRepository.save(entity);
		});
	}
	
	@Override
	public void deleteSchedule(String scheduleId) {
		scheduleRepository.deleteById(scheduleId);
	}
	
}
