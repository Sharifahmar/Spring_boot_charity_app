/**
 * 
 */
package com.ecomm.akhtar.model;

import java.util.Date;

/**
 * @author Ahmar
 *
 */
public class DonarContributionRequestDTO {
	
	private String fullName;

	private String phoneNumber;
	
	private Long donationTypeId;
	
	private String fromDate;
	
	private Date fromDateObj;
	
	private Date toDateObj;
	
	private String toDate;
	
	private Boolean status;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getDonationTypeId() {
		return donationTypeId;
	}

	public void setDonationTypeId(Long donationTypeId) {
		this.donationTypeId = donationTypeId;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Date getFromDateObj() {
		return fromDateObj;
	}

	public void setFromDateObj(Date fromDateObj) {
		this.fromDateObj = fromDateObj;
	}

	public Date getToDateObj() {
		return toDateObj;
	}

	public void setToDateObj(Date toDateObj) {
		this.toDateObj = toDateObj;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
}
