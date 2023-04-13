package com.ats.project.monolith.entity;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="tb_plane")
public class Plane implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "plane_reg_no", length =5)
	private String planeRegNo;
	
    @Column(name = "plane_model",updatable = false)
	private String planeModel;
	
    @Column(name = "plane_capacity",updatable = false)
	private Integer placeCapacity;
  
    @Column(name = "plane_maker",updatable = false)
    private String planeMaker;
    
    @Lob
    @Column(name = "plane_image")
    private byte[] planeImage;
    
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

	public byte[] getPlaneImage() {
		return planeImage;
	}

	public void setPlaneImage(byte[] planeImage) {
		this.planeImage = planeImage;
	}
	
}
