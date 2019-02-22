package com.ecomm.akhtar.model;

import java.util.Date;

import com.ecomm.akhtar.audit.AuditModel;

public class Keys extends AuditModel {

	private static final long serialVersionUID = 1L;
	private int keyId;
	private int userID;
	private String description;
	private Date endDate;
	private Boolean status;
	public int getKeyId() {
		return keyId;
	}
	public void setKeyId(int keyId) {
		this.keyId = keyId;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
}
