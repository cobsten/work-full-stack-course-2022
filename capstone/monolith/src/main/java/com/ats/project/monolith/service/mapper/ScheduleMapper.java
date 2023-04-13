package com.ats.project.monolith.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.ats.project.monolith.entity.Schedule;
import com.ats.project.monolith.service.dto.ScheduleDTO;

@Mapper(componentModel = "spring", uses = {PlaneMapper.class})
public interface ScheduleMapper extends EntityMapper<ScheduleDTO, Schedule> {

	@Mapping(target="scheduleId", ignore = true)
	@Mapping(target="plane", ignore = true)
	public void updateSchedule(@MappingTarget Schedule entity, ScheduleDTO incoming);
}
