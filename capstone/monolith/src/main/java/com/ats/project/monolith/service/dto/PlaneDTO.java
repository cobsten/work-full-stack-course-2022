package com.ats.project.monolith.service.dto;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

@JsonInclude(Include.NON_NULL)
public class PlaneDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	@Length(min =5 , max=5)
	private String planeRegNo;
	
	@NotBlank
	private String planeModel;
	
	@NotNull
	private Integer placeCapacity;
 
    private String planeMaker;
    
    private String planeImage;
  
	public String getPlaneRegNo() {
		return planeRegNo;
	}

	public void setPlaneRegNo(String planeRegNo) {
		this.planeRegNo = planeRegNo;
	}

	public String getPlaneModel() {
		return planeModel;
	}

	public void setPlaneModel(String planeModel) {
		this.planeModel = planeModel;
	}

	public Integer getPlaceCapacity() {
		return placeCapacity;
	}

	public void setPlaceCapacity(Integer placeCapacity) {
		this.placeCapacity = placeCapacity;
	}

	public String getPlaneMaker() {
		return planeMaker;
	}

	public void setPlaneMaker(String planeMaker) {
		this.planeMaker = planeMaker;
	}

	public String getPlaneImage() {
		return planeImage;
	}

	public void setPlaneImage(String planeImage) {
		this.planeImage = planeImage;
	}
	
}
