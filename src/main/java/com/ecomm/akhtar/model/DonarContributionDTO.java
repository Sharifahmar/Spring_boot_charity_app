/**
 * 
 */
package com.ecomm.akhtar.model;

import java.text.SimpleDateFormat;

/**
 * @author Ahmar
 *
 */
public class DonarContributionDTO {

	private Long donationAmountId;

	private String fullName;

	private String phoneNumber;

	private String address;

	private String donationType;

	private Long donationTypeId;

	private String donationAmount;

	private java.util.Date date;

	public DonarContributionDTO(Long donationAmountId, String fullName, String phoneNumber, String address,
			String donationType, Long donationTypeId, String donationAmount,
			java.util.Date date) {
		super();
		this.donationAmountId = donationAmountId;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.donationType = donationType;
		this.donationTypeId = donationTypeId;
		this.donationAmount = donationAmount;
		this.date = date;
	}

	public DonarContributionDTO() {
		super();

	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDonationType() {
		return donationType;
	}

	public void setDonationType(String donationType) {
		this.donationType = donationType;
	}

	public Long getDonationTypeId() {
		return donationTypeId;
	}

	public void setDonationTypeId(Long donationTypeId) {
		this.donationTypeId = donationTypeId;
	}

	public String getDonationAmount() {
		return donationAmount;
	}

	public void setDonationAmount(String donationAmount) {
		this.donationAmount = donationAmount;
	}

	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public Long getDonationAmountId() {
		return donationAmountId;
	}

	public void setDonationAmountId(Long donationAmountId) {
		this.donationAmountId = donationAmountId;
	}

	public String getDateString() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(this.getDate());
	}

}
