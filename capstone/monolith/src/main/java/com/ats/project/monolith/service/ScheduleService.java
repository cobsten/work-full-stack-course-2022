package com.ats.project.monolith.service;

import com.ats.project.monolith.service.dto.ScheduleDTO;

public interface ScheduleService {

	ScheduleDTO createSchedule(ScheduleDTO dto);

	void updateSchedule(ScheduleDTO dto);

	void deleteSchedule(String scheduleId);

}
