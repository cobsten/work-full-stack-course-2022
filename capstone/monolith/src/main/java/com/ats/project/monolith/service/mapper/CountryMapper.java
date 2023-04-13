package com.ats.project.monolith.service.mapper;

import org.mapstruct.Mapper;

import com.ats.project.monolith.entity.Country;
import com.ats.project.monolith.service.dto.CountryDTO;

@Mapper(componentModel = "spring", uses = {})
public interface CountryMapper extends EntityMapper<CountryDTO, Country> {

}
