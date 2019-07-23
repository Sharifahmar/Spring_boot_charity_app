package com.ecomm.akhtar.model;

import java.util.Date;

public class DonationTypeModel {

	private Long donationTypeId;

	private String donationType;
	
	private String donationTypeName;

	private Boolean status;

	private Date createdDt;

	private Date updatedDt;

	public Long getDonationTypeId() {
		return donationTypeId;
	}

	public void setDonationTypeId(Long donationTypeId) {
		this.donationTypeId = donationTypeId;
	}

	public String getDonationType() {
		return donationType;
	}

	public void setDonationType(String donationType) {
		this.donationType = donationType;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Date getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	public Date getUpdatedDt() {
		return updatedDt;
	}

	public void setUpdatedDt(Date updatedDt) {
		this.updatedDt = updatedDt;
	}

	public String getDonationTypeName() {
		return donationTypeName;
	}

	public void setDonationTypeName(String donationTypeName) {
		this.donationTypeName = donationTypeName;
	}
	

}
