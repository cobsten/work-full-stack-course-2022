package com.ats.project.monolith.service.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import com.ats.project.monolith.entity.Passenger;
import com.ats.project.monolith.service.dto.PassengerDTO;

@Mapper(componentModel = "spring", uses = {})
public interface PassengerMapper extends EntityMapper<PassengerDTO, Passenger> {
	
	@Mapping(target="passengerId", ignore=true)
	void updateEntity(@MappingTarget Passenger entity, PassengerDTO incoming);

}
