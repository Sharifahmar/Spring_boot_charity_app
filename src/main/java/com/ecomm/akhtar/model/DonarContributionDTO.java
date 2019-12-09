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
	
	private String firstName;

	private String lastName;

	private String phoneNumber;

	private String email;
	
	private String address;
	
	private String receiptNumber;

	private String donationType;
	
	private Long donationTypeId;

	private String donationAmount;

	private java.util.Date date;
	

	public DonarContributionDTO(Long donationAmountId, String firstName, String lastName, String phoneNumber,
			String email, String address, String receiptNumber, String donationType, Long donationTypeId,
			String donationAmount, java.util.Date date) {
		super();
		this.donationAmountId = donationAmountId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.receiptNumber = receiptNumber;
		this.donationType = donationType;
		this.donationTypeId = donationTypeId;
		this.donationAmount = donationAmount;
		this.date = date;
	}
	
	

	public DonarContributionDTO() {
		super();
	
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getReceiptNumber() {
		return receiptNumber;
	}

	public void setReceiptNumber(String receiptNumber) {
		this.receiptNumber = receiptNumber;
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
