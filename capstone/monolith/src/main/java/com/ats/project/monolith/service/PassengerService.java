package com.ats.project.monolith.service;

import java.util.Map;
import java.util.Optional;

import com.ats.project.monolith.service.dto.PassengerDTO;

public interface PassengerService {

	Map<String, Object> createPassenger(PassengerDTO passenger);

	Optional<PassengerDTO> updatePassenger(PassengerDTO passenger);


}
