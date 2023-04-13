package com.ats.project.monolith.entity;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="tb_schedule")
public class Schedule implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "schedule_id", length =5 , unique = true, insertable = false,updatable = false)
	private String scheduleId;

	@Column(name = "source", nullable= false)
	private String source;
	
	@Column(name = "destination", nullable= false)
	private String destination;

	@Column(name = "depart_datetime")
	private Instant departDatetime;
	
	@Column(name = "arrival_datetime")
	private Instant arrivalDatetime;
	
	@JoinColumn(name = "plane_reg_no", referencedColumnName = "plane_reg_no", nullable= false)
	private Plane plane;

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

	public Plane getPlane() {
		return plane;
	}

	public void setPlane(Plane plane) {
		this.plane = plane;
	}


}
