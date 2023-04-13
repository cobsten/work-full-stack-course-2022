package com.ats.project.monolith.service.mapper;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.ats.project.monolith.entity.Airport;
import com.ats.project.monolith.service.dto.AirportDTO;

@Mapper(componentModel = "spring", uses = {})
public interface AirportMapper extends EntityMapper<AirportDTO, Airport> {

//	@Mapping(target="country.countryCode", source = "countryCode")
//	@Mapping(target="country.countryName",ignore = true)
//	@Mapping(target="coutnry.countryCity",ignore = true)
//	@Mapping(target="country.countryState",ignore = true)
//	Airport toEntity(AirportDTO dto);
//	
//	@Mapping(target="countryCode", source = "country.countryCode")
//	AirportDTO toDto(Airport entity);
	
	@Mapping(target = "airportCode", ignore=true)
	void updateAirport (@MappingTarget AirportDTO target,AirportDTO source);
}
