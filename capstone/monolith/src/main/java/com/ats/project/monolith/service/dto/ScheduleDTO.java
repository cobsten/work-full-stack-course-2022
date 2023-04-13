package com.ats.project.monolith.service.dto;

import java.io.Serializable;
import java.time.Instant;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.ats.project.monolith.annotations.ScheduleConstraint;

@ScheduleConstraint
public class ScheduleDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String scheduleId;

	@NotBlank
	private String source;
	
	@NotBlank
	private String destination;

	private Instant departDatetime;
	
	private Instant arrivalDatetime;
	
	@NotNull
	private PlaneDTO plane;

	public String getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Instant getDepartDatetime() {
		return departDatetime;
	}

	public void setDepartDatetime(Instant departDatetime) {
		this.departDatetime = departDatetime;
	}

	public Instant getArrivalDatetime() {
		return arrivalDatetime;
	}

	public void setArrivalDatetime(Instant arrivalDatetime) {
		this.arrivalDatetime = arrivalDatetime;
	}

	public PlaneDTO getPlane() {
		return plane;
	}

	public void setPlane(PlaneDTO plane) {
		this.plane = plane;
	}


}
