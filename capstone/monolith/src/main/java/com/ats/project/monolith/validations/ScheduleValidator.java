package com.ats.project.monolith.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.ats.project.monolith.annotations.ScheduleConstraint;
import com.ats.project.monolith.service.dto.ScheduleDTO;

public class ScheduleValidator implements ConstraintValidator<ScheduleConstraint, ScheduleDTO> {

	@Override
	public boolean isValid(ScheduleDTO value, ConstraintValidatorContext context) {
		
		if(value.getArrivalDatetime()==null || value.getDepartDatetime()==null) {
			return false;
		}
		if(!value.getDepartDatetime().isBefore(value.getArrivalDatetime())) {
			return false;
		}

		return false;
	}

}
