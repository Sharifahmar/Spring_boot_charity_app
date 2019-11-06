/**
 * 
 */
package com.ecomm.akhtar.model;

/**
 * @author Ahmar
 *
 */
public class DonarContributionRequestDTO {

	private String phoneNumber;
	
	private Long donationTypeId;
	
	private String fromDate;
	
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
	
	
	
}
