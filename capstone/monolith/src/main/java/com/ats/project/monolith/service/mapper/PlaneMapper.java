package com.ats.project.monolith.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ats.project.monolith.entity.Plane;
import com.ats.project.monolith.service.dto.PlaneDTO;

@Mapper(componentModel = "spring", uses = {})
public interface PlaneMapper extends EntityMapper<PlaneDTO, Plane> {

	@Mapping(target="planeImage", ignore= true)
	Plane toEntity(PlaneDTO dto);
	
	@Mapping(target="planeImage", ignore= true)
	PlaneDTO toDto(Plane entity);
}
