package com.ats.project.monolith.service;

import java.util.List;

import com.ats.project.monolith.service.dto.PlaneDTO;

public interface PlaneService {

	PlaneDTO createPlane(PlaneDTO dto);

	List<PlaneDTO> findAllPlanes();

	void deletePlane(String regNo);

}
